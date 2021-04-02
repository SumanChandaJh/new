package factory.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import General.Interaction;
import base.TestUtility;
import factory.dataobjects.Policy;
import factory.driver.Driver;
import factory.pagetemplates.TabPageTemplate;
import support.businesslogic.AppVariables;
import support.businesslogic.DataUtility;
import support.fileoperations.FileOps_Common;

public class ClaimsLayout extends TabPageTemplate {

	Interaction interaction;
	Driver driver;
	private static Logger log = Logger.getLogger(ClaimsLayout.class);

	@FindBy(xpath = ".//*[contains(text(),'for policy:')]")
	public WebElement Header_Text_Retail_Policy;

	@FindBy(xpath = ".//*[contains(text(),'for Coverage ID:')]")
	public WebElement Header_Text_Group_Policy;

	@FindBy(xpath = ".//h4/parent::*/h1")
	public WebElement SubHeader_Text;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[1]//a")
	public WebElement Claim_overview_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[2]//a")
	public WebElement Submit_an_invoice_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[3]//a")
	public WebElement Payment_and_invoice_history_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[4]//a")
	public WebElement Approved_providers_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[5]//a")
	public WebElement Submit_documents_Tab;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcClaim\"]//*[text()='Claim Status:']")
	public WebElement Claim_overview_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcInvoiceForm\"]//h3")
	public WebElement Submit_an_invoice_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcClaimPaymentHistory\"]//h3")
	public WebElement Payment_and_invoice_history_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcClaimApprovedProviders\"]//thead//th[1]//b")
	public WebElement Approved_providers_Tab_Header_Text;

	@FindBy(xpath = "")
	public WebElement Submit_documents_Tab_Header_Text;

	public ClaimsLayout(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;

	}

	@Override
	public boolean verifyPageHeaders() {
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		Policy current_policy = FileOps_Common.getDetailsForPolicy(AppVariables.POLICY);
		String propertyName;
		WebElement headerObj;
		if (DataUtility.isGroupPolicy(current_policy)) {
			propertyName = "Group_Policy_Claims_Layout_Header_Text";
			headerObj = Header_Text_Group_Policy;
		} else {
			propertyName = "Retail_Policy_Claims_Layout_Header_Text";
			headerObj = Header_Text_Retail_Policy;
		}
		if (TestUtility.compareDynamicText(headerObj, propertyName, AppVariables.CLAIM, AppVariables.POLICY, true)) {
			interaction.highlightElement(headerObj, true);
			resultList.add(true);
		} else {
			resultList.add(false);
		}

		String insured_name = FileOps_Common.getInsuredForPolicy(AppVariables.POLICY);
		if (TestUtility.compareDynamicText(SubHeader_Text, "Claims_Layout_SubHeader_Text",
				TestUtility.addUsernameSuffix(insured_name), true)) {
			interaction.highlightElement(SubHeader_Text, true);
			resultList.add(true);
		} else {
			resultList.add(false);
		}

		if (resultList.contains(false)) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public WebElement getElementFromName(String propertyName) {

		switch (propertyName) {
		case "Claims_Layout_Header_Text":
			return Header_Text_Retail_Policy;
		case "Claims_Layout_SubHeader_Text":
			return SubHeader_Text;
		case "Claim_overview_Tab":
			return Claim_overview_Tab;
		case "Submit_an_invoice_Tab":
			return Submit_an_invoice_Tab;
		case "Payment_and_invoice_history_Tab":
			return Payment_and_invoice_history_Tab;
		case "Approved_providers_Tab":
			return Approved_providers_Tab;
		case "Submit_documents_Tab":
			return Submit_documents_Tab;
		case "Claim_overview_Tab_Header_Text":
			return Claim_overview_Tab_Header_Text;
		case "Submit_an_invoice_Tab_Header_Text":
			return Submit_an_invoice_Tab_Header_Text;
		case "Payment_and_invoice_history_Tab_Header_Text":
			return Payment_and_invoice_history_Tab_Header_Text;
		case "Approved_providers_Tab_Header_Text":
			return Approved_providers_Tab_Header_Text;
		case "Submit_documents_Tab_Header_Text":
			return Submit_documents_Tab_Header_Text;
		default:
			log.error("No element found with  name : " + propertyName);
			return null;
		}
	}

	@Override
	public boolean verifyTabAvailability(String tabName) {
		// declaring variables
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();

		if (navigateToTab(tabName)) {
			String inputTabName = tabName.replaceAll(" ", "_") + "_Tab";
			WebElement obj = getElementFromName(inputTabName);

			if (TestUtility.compareText(obj, inputTabName, true)) {
				interaction.highlightElement(obj, true);
				resultList.add(true);
			} else {
				resultList.add(false);
			}
			obj = getElementFromName(inputTabName + "_Header_Text");
			if (TestUtility.compareText(obj, inputTabName + "_Header_Text", true)) {
				interaction.highlightElement(obj, true);
				resultList.add(true);
			} else {
				resultList.add(false);
			}
		}

		if (resultList.contains(false)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean navigateToTab(String tabName) {
		String inputTabName = tabName.replaceAll(" ", "_") + "_Tab";
		if (interaction.clickWebElement(getElementFromName(inputTabName))) {
			if (interaction.waitForElement(getElementFromName(inputTabName + "_Header_Text"))) {
				return true;
			}
		} else {
			log.error("No such tab name available in Claims Layout page.");
		}
		return false;
	}

}
