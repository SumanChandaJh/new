package factory.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.CardPageTemplate;

public class SubmitDocumentTab extends CardPageTemplate {

	Interaction interaction;
	Driver driver;
	private static Logger log = Logger.getLogger(SubmitDocumentTab.class);

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//*[contains(text(),'Select the document')]")
	public WebElement Header_Text;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]//*[text()='Policy']")
	public WebElement policy_selector_label;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]/div[2]//img")
	public WebElement policy_selector_dropdown_link;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]/div[2]//ul")
	public WebElement policy_selector_dropdown;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]//*[text()='Claim']")
	public WebElement claim_selector_label;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]/div[3]//img")
	public WebElement claim_selector_dropdown_link;

	@FindBy(xpath = ".//*[@role=\"tabpanel\"]//*[@data-aura-class=\"cLtcPolicyClaimSelect\"]/div[3]//ul")
	public WebElement claim_selector_dropdown;

	@FindBy(xpath = ".//*[contains(text(),'Add a new legal representative')]/parent::*/parent::*")
	public WebElement Legal_Representative_Card;
	@FindBy(xpath = ".//*[contains(text(),'Add a new legal representative')]/parent::*/parent::*//b")
	public WebElement Legal_Representative_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'Add a new legal representative')]")
	public WebElement Legal_Representative_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'Add a new legal representative')]/parent::*/parent::*/footer//a")
	public WebElement Legal_Representative_Card_Link;

	@FindBy(xpath = ".//*[contains(text(),'HIPAA Authorized Users')]/parent::*/parent::*")
	public WebElement HIPAA_Card;
	@FindBy(xpath = ".//*[contains(text(),'HIPAA Authorized Person')]")
	public WebElement HIPAA_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'HIPAA Authorized Users')]")
	public WebElement HIPAA_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'HIPAA Authorized Users')]/parent::*/parent::*/footer//a")
	public WebElement HIPAA_Card_Link;

	@FindBy(xpath = ".//*[contains(text(),'Enroll for an automatic ')]/parent::*/parent::*")
	public WebElement Automatic_Deduction_Plan_Card;
	@FindBy(xpath = ".//*[contains(text(),'Automatic Deduction Plan')]")
	public WebElement Automatic_Deduction_Plan_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'Enroll for an automatic ')]")
	public WebElement Automatic_Deduction_Plan_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'Enroll for an automatic ')]/parent::*/parent::*//footer//a")
	public WebElement Automatic_Deduction_Plan_Card_Link;

	@FindBy(xpath = "")
	public WebElement Automatic_Bank_Withdrawl_Card;
	@FindBy(xpath = "")
	public WebElement Automatic_Bank_Withdrawl_Card_Header;
	@FindBy(xpath = "")
	public WebElement Automatic_Bank_Withdrawl_Card_Content;
	@FindBy(xpath = "")
	public WebElement Automatic_Bank_Withdrawl_Card_Link;

	@FindBy(xpath = ".//*[contains(text(),'To receive ')]/parent::*/parent::*")
	public WebElement Direct_Deposit_Card;
	@FindBy(xpath = ".//*[contains(text(),'Direct Deposit')]")
	public WebElement Direct_Deposit_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'To receive ')]")
	public WebElement Direct_Deposit_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'To receive ')]/parent::*/parent::*//footer//a")
	public WebElement Direct_Deposit_Card_Link;

	@FindBy(xpath = ".//*[contains(text(),'The Assignment of Benefits')]/parent::*/parent::*")
	public WebElement Assignment_Of_Benefits_Card;
	@FindBy(xpath = ".//*[contains(text(),'The Assignment of Benefits')]/parent::*/parent::*//b")
	public WebElement Assignment_Of_Benefits_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'The Assignment of Benefits')]")
	public WebElement Assignment_Of_Benefits_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'The Assignment of Benefits')]/parent::*/parent::*//footer//a")
	public WebElement Assignment_Of_Benefits_Card_Link;

	@FindBy(xpath = ".//*[contains(text(),'Submit documentation')]/parent::*/parent::*")
	public WebElement Death_Certificate_Card;
	@FindBy(xpath = ".//*[contains(text(),'Death Certificate')]")
	public WebElement Death_Certificate_Card_Header;
	@FindBy(xpath = ".//*[contains(text(),'Submit documentation')]")
	public WebElement Death_Certificate_Card_Content;
	@FindBy(xpath = ".//*[contains(text(),'Submit documentation')]/parent::*/parent::*//footer//a")
	public WebElement Death_Certificate_Card_Link;

	public SubmitDocumentTab(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		WebElement element = null;
		switch (propertyName) {
		case "Legal_Representative_Card":
			element = Legal_Representative_Card;
			break;
		case "Legal_Representative_Card_Header":
			element = Legal_Representative_Card_Header;
			break;
		case "Legal_Representative_Card_Content":
			element = Legal_Representative_Card_Content;
			break;
		case "Legal_Representative_Card_Link":
			element = Legal_Representative_Card_Link;
			break;
		case "HIPAA_Card":
			element = HIPAA_Card;
			break;
		case "HIPAA_Card_Header":
			element = HIPAA_Card_Header;
			break;
		case "HIPAA_Card_Content":
			element = HIPAA_Card_Content;
			break;
		case "HIPAA_Card_Link":
			element = HIPAA_Card_Link;
			break;
		case "Automatic_Bank_Withdrawl_Card":
			element = Automatic_Bank_Withdrawl_Card;
			break;
		case "Automatic_Bank_Withdrawl_Card_Header":
			element = Automatic_Bank_Withdrawl_Card_Header;
			break;
		case "Automatic_Bank_Withdrawl_Card_Content":
			element = Automatic_Bank_Withdrawl_Card_Content;
			break;
		case "Automatic_Bank_Withdrawl_Card_Link":
			element = Automatic_Bank_Withdrawl_Card_Link;
			break;
		case "Automatic_Deduction_Plan_Card":
			element = Automatic_Deduction_Plan_Card;
			break;
		case "Automatic_Deduction_Plan_Card_Header":
			element = Automatic_Deduction_Plan_Card_Header;
			break;
		case "Automatic_Deduction_Plan_Card_Content":
			element = Automatic_Deduction_Plan_Card_Content;
			break;
		case "Automatic_Deduction_Plan_Card_Link":
			element = Automatic_Deduction_Plan_Card_Link;
			break;
		case "Direct_Deposit_Card":
			element = Direct_Deposit_Card;
			break;
		case "Direct_Deposit_Card_Header":
			element = Direct_Deposit_Card_Header;
			break;
		case "Direct_Deposit_Card_Content":
			element = Direct_Deposit_Card_Content;
			break;
		case "Direct_Deposit_Card_Link":
			element = Direct_Deposit_Card_Link;
			break;
		case "Assignment_Of_Benefits_Card":
			element = Assignment_Of_Benefits_Card;
			break;
		case "Assignment_Of_Benefits_Card_Header":
			element = Assignment_Of_Benefits_Card_Header;
			break;
		case "Assignment_Of_Benefits_Card_Content":
			element = Assignment_Of_Benefits_Card_Content;
			break;
		case "Assignment_Of_Benefits_Card_Link":
			element = Assignment_Of_Benefits_Card_Link;
			break;
		case "Death_Certificate_Card":
			element = Death_Certificate_Card;
			break;
		case "Death_Certificate_Card_Header":
			element = Death_Certificate_Card_Header;
			break;
		case "Death_Certificate_Card_Content":
			element = Death_Certificate_Card_Content;
			break;
		case "Death_Certificate_Card_Link":
			element = Death_Certificate_Card_Link;
			break;
		default:
			log.info("Element with property value not mapped.");
			return null;
		}

		if (interaction.waitForElement(element)) {
			log.info("Returning element for input name - " + propertyName);
			return element;
		} else {
			return null;
		}
	}

	@Override
	public boolean verifyCardAvailability(String cardName) {

		ArrayList<Boolean> status = new ArrayList<Boolean>();
		String inputCardName = cardName.replaceAll(" ", "_") + "_Card";
		String cardHeaderName = inputCardName + "_Header";
		String cardContentName = inputCardName + "_Content";
		if (interaction.waitForElement(getElementFromName(cardHeaderName))) {

			status.add(TestUtility.compareText(getElementFromName(cardHeaderName), cardHeaderName, true));
			status.add(TestUtility.compareText(getElementFromName(cardContentName), cardContentName, true));
			/*
			 * status.add(TestUtility.compareText(getElementFromName(inputCardName +
			 * "_Link"), inputCardName + "_Link", true));
			 */
			WebElement cardObj = getElementFromName(inputCardName);
			if (status.contains(false)) {
				// interaction.highlightElement(cardObj, false);
				return false;
			} else {
				interaction.highlightElement(cardObj, true);
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean selectCard(String cardName) {

		String inputCardName = cardName.replaceAll(" ", "_") + "_Card_Link";
		WebElement element = (getElementFromName(inputCardName));
		if (interaction.waitForElement(element)) {
			return interaction.clickWebElement(element);
		}
		return false;
	}

	public boolean selectPolicy(String policyNumber) {
		if (interaction.isElementVisible(policy_selector_dropdown_link)) {
			if (interaction.clickWebElement(policy_selector_dropdown_link)) {
				if (interaction.selectDropDownValue(policy_selector_dropdown, policyNumber)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean selectClaim(String claimNumber) {
		if (interaction.isElementVisible(claim_selector_dropdown_link)) {
			if (interaction.clickWebElement(claim_selector_dropdown_link)) {
				if (interaction.selectDropDownValue(claim_selector_dropdown, claimNumber)) {
					return true;
				}
			}
		}
		return false;
	}

}
