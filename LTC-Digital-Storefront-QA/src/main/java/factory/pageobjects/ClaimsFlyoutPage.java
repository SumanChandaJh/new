package factory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.dataobjects.Claim;
import factory.dataobjects.Policy;
import factory.driver.Driver;
import factory.pagetemplates.FlyoutPageTemplate;
import support.businesslogic.AppVariables;
import support.businesslogic.DataUtility;
import support.fileoperations.FileOps_Common;

public class ClaimsFlyoutPage extends FlyoutPageTemplate {

	Interaction interaction;
	Driver driver;
	private static Logger log = Logger.getLogger(ClaimsFlyoutPage.class);

	@FindBy(xpath = ".//*[@data-id=\"claimMenuItem\"]//section[1]//*[contains(@class,'top-header')]")
	public WebElement Claims_Flyout_Header_Text;

	@FindBy(xpath = ".//*[@data-id=\"claimMenuItem\"]//section[1]//*[contains(@class,'top-subheader')]")
	public WebElement Claims_Flyout_SubHeader_Text;

	@FindBy(xpath = ".//*[@data-id=\"claimMenuItem\"]/aside/div")
	public WebElement Claims_Flyout_Sections;

	public ClaimsFlyoutPage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public boolean clickElement(String properyName) {

		return false;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		WebElement element = null;

		if (propertyName.contains("Claims_Flyout_Header_Text")) {
			element = Claims_Flyout_Header_Text;
		} else if (propertyName.contains("Claims_Flyout_SubHeader_Text")) {
			element = Claims_Flyout_SubHeader_Text;
		}

		if (interaction.waitForElement(element)) {
			return element;
		} else
			return element;
	}

	@Override
	public boolean verifyElementTextForFlyout(String properyName) {
		WebElement element = getElementFromName(properyName);
		if (TestUtility.compareText(element, properyName, true)) {
			interaction.highlightElement(element, true);
			return true;
		}
		return false;
	}

	public boolean verifyFlyoutContent(String user_full_name) {

		// declaring variables
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		String policy_number;
		String insured_name;
		String flyout_policy_number_property_name = null;
		WebElement current_section;
		List<WebElement> section_elements;
		WebElement actual_insured_title, actual_policy_number_text;

		// getting expected values
		ArrayList<Policy> listOfPoliciesForUser = new ArrayList<Policy>();
		listOfPoliciesForUser = FileOps_Common.readPolicyForUser(user_full_name);
		listOfPoliciesForUser = DataUtility.sortPolicyList(listOfPoliciesForUser);

		// getting actual values
		List<WebElement> flyout_sections = Claims_Flyout_Sections.findElements(By.tagName("section"));

		if (flyout_sections != null) {
			int section_number = 1;
			while (section_number < flyout_sections.size()) {

				// initializing expected values for current policy section
				Policy policy = listOfPoliciesForUser.get(section_number - 1);

				if (DataUtility.isGroupPolicy(policy)) {
					policy_number = policy.getCoverage_Id();
					flyout_policy_number_property_name = "flyout_coverage_id_text";
				} else {
					policy_number = policy.getPolicy_Number();
					flyout_policy_number_property_name = "flyout_policy_number_text";
				}
				insured_name = policy.getInsuredFullName();

				// getting elements for current section
				current_section = flyout_sections.get(section_number);
				section_elements = current_section.findElements(By.tagName("div"));
				if (section_elements != null) {

					actual_insured_title = section_elements.get(0);
					actual_policy_number_text = section_elements.get(1);
					WebElement claimSectionObject = section_elements.get(4);

					// comparing Insured's Name on the section
					if (TestUtility.compareDynamicText(actual_insured_title, "flyout_insured_name_text",
							TestUtility.addUsernameSuffix(insured_name), true)) {
						interaction.highlightElement(actual_insured_title, true);
						resultList.add(true);
					} else {
						resultList.add(false);
					}

					// comparing Policy Details on the section
					if (TestUtility.compareDynamicText(actual_policy_number_text, flyout_policy_number_property_name,
							policy_number, true)) {
						interaction.highlightElement(actual_policy_number_text, true);
						resultList.add(true);
					} else {
						resultList.add(false);
					}

					Policy currentPolicyDetail = FileOps_Common.getDetailsForPolicy(policy_number);

					// comparing claim details for current policy
					resultList.add(
							verifyClaimDetailsForFlyoutPolicy(claimSectionObject, currentPolicyDetail.getClaimList()));
				}
				section_number++;
			}
			if (resultList.contains(false)) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	private Boolean verifyClaimDetailsForFlyoutPolicy(WebElement claimSectionObject, ArrayList<Claim> claimList) {
		// declaring variables
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		String claim_text_property_name = "";

		if (claimList.size() == 0) {
			log.info("Case for policy with no claim.");
			claim_text_property_name = "flyout_no_claim_property_name";
			// Our records indicate that you do not have an active claim
			// Initiate a claim
			return true;
		} else if (claimList.size() == 1) {
			log.info("Case for policy with single claim.");

			claim_text_property_name = "flyout_most_recent_claim_number_property_name";

			// comparing Policy Details on the section
			if (TestUtility.compareDynamicText(claimSectionObject, claim_text_property_name,
					claimList.get(0).getClaim_Number(), true)) {
				interaction.highlightElement(claimSectionObject, true);
				resultList.add(true);
			} else {
				resultList.add(false);
			}

		}
		if (claimList.size() > 1) {
			log.info("Case for policy with multiple claims.");
		}

		if (resultList.contains(false)) {
			return false;
		} else {
			return true;
		}

	}

	public boolean selectClaim(String policyNumber, String claimToSelect) {

		log.info("Trying to select claim : " + claimToSelect + " for policy : " + policyNumber);

		List<WebElement> current_section_element_list;
		WebElement current_section;
		List<WebElement> flyout_sections = Claims_Flyout_Sections.findElements(By.tagName("section"));

		if (flyout_sections != null) {
			int section_number = 2;
			while (section_number <= flyout_sections.size()) {

				current_section = flyout_sections.get(section_number - 1);
				current_section_element_list = current_section.findElements(By.tagName("div"));

				if (current_section_element_list != null) {
					WebElement policyNumberObject = current_section_element_list.get(1);
					if (policyNumberObject.getText().contains(policyNumber)) {
						log.info("Policy " + policyNumber + " is available");
						// interaction.highlightElement(policyNumberObject, true);
						WebElement claimSectionObject = current_section_element_list.get(4);

						if (claimSectionObject.getText().contains(claimToSelect)) {
							log.info("Scenario for claim being the most recent one.");
							interaction.highlightElement(claimSectionObject, true);
							WebElement viewLinkObj = current_section.findElement(By.tagName("c-ltc-button"));

							if (interaction.isElementVisible(viewLinkObj)) {
								log.info("Successfully found claim number to select.");
								AppVariables.POLICY = policyNumber;
								AppVariables.CLAIM = claimToSelect;

								interaction.scrollToElement(viewLinkObj);
								interaction.hoverElement(viewLinkObj);
								interaction.clickWebElement(viewLinkObj);
								return true;
							} else {
								log.error("Unable to find claim number link to select.");
							}
						} else {
							log.info("Scenario for claim being available in list.");
							log.info("Yet to implement this scenario");
							return true;
						}
					}
				}
				section_number++;
			}
		}
		return false;
	}

}
