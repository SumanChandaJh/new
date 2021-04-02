package factory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.dataobjects.Policy;
import factory.driver.Driver;
import factory.pagetemplates.FlyoutPageTemplate;
import support.businesslogic.DataUtility;
import support.fileoperations.FileOps_Common;

public class PolicyFlyoutPage extends FlyoutPageTemplate {

	Interaction interaction;
	Driver driver;

	@FindBy(xpath = ".//*[@data-id=\"policyMenuItem\"]//section[1]//*[contains(@class,'top-header')]")
	public WebElement Policy_Flyout_Header_Text;

	@FindBy(xpath = ".//*[@data-id=\"policyMenuItem\"]//section[1]//*[contains(@class,'top-subheader')]")
	public WebElement Policy_Flyout_SubHeader_Text;

	@FindBy(xpath = ".//*[@data-id=\"policyMenuItem\"]/aside/div")
	public WebElement Policy_Flyout_Sections;

	public PolicyFlyoutPage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public boolean clickElement(String properyName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		WebElement element = null;

		if (propertyName.contains("Policy_Flyout_Header_Text")) {
			element = Policy_Flyout_Header_Text;
		} else if (propertyName.contains("Policy_Flyout_SubHeader_Text")) {
			element = Policy_Flyout_SubHeader_Text;
		}

		if (interaction.waitForElement(element)) {
			return element;
		} else
			return element;
	}

	@Override
	public boolean verifyElementTextForFlyout(String properyName) {
		return TestUtility.compareText(getElementFromName(properyName), properyName, true);
	}

	public boolean verifyFlyoutContent(String user_full_name) {

		// declaring variables
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		String policy_number;
		String policy_status;
		String insured_name;
		String flyout_policy_number_property_name = null, flyout_policy_status_property_name = null;
		WebElement current_section;
		List<WebElement> section_elements;
		WebElement actual_insured_title, actual_policy_number_text, actual_policy_status_text;

		// getting expected values
		ArrayList<Policy> listOfPoliciesForUser = new ArrayList<Policy>();
		listOfPoliciesForUser = FileOps_Common.readPolicyForUser(user_full_name);
		listOfPoliciesForUser = DataUtility.sortPolicyList(listOfPoliciesForUser);

		// getting actual values
		List<WebElement> flyout_sections = Policy_Flyout_Sections.findElements(By.tagName("section"));

		if (flyout_sections != null) {
			int section_number = 1;
			while (section_number <= flyout_sections.size()) {

				// initializing expected values for current policy section
				Policy policy = listOfPoliciesForUser.get(section_number - 1);
				
				if (DataUtility.isGroupPolicy(policy)) {
					policy_number = policy.getCoverage_Id();
					policy_status = policy.getCertificate_Status();
					flyout_policy_number_property_name = "flyout_coverage_id_text";
					flyout_policy_status_property_name = "flyout_certificate_status_text";
				} else {
					policy_number = policy.getPolicy_Number();
					policy_status = policy.getPolicy_Status();
					flyout_policy_number_property_name = "flyout_policy_number_text";
					flyout_policy_status_property_name = "flyout_policy_status_text";
				}
				insured_name = policy.getInsuredFullName();

				// getting elements for current section
				current_section = flyout_sections.get(section_number);
				section_elements = current_section.findElements(By.tagName("div"));
				if (section_elements != null) {
					actual_insured_title = section_elements.get(0);
					actual_policy_number_text = section_elements.get(1);
					actual_policy_status_text = section_elements.get(4);

					resultList.add(TestUtility.compareDynamicText(actual_insured_title, "flyout_insured_name_text",
							TestUtility.addUsernameSuffix(insured_name), true));

					resultList.add(TestUtility.compareDynamicText(actual_policy_number_text,
							flyout_policy_number_property_name, policy_number, true));

					resultList.add(TestUtility.compareDynamicText(actual_policy_status_text,
							flyout_policy_status_property_name, policy_status, true));

					if (resultList.contains(false)) {
						return false;
					}
					return true;
				}

			}
		}

		return false;
	}

}
