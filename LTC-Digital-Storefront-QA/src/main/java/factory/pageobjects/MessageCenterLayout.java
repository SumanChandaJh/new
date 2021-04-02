package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.TabPageTemplate;

public class MessageCenterLayout extends TabPageTemplate {

	Interaction interaction;
	Driver driver;
	public static Logger log = Logger.getLogger(MessageCenterLayout.class);

	@FindBy(xpath = ".//*[text()='Message Center']")
	public WebElement Header_Text;

	@FindBy(xpath = ".//h4/parent::*/h1")
	public WebElement SubHeader_Text;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[1]//a")
	public WebElement Inbox_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[2]//a")
	public WebElement Ask_A_Question_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[3]//a")
	public WebElement Submit_Document_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[4]//a")
	public WebElement Document_History_Tab;

	@FindBy(xpath = ".//*[@role=\"tablist\"]//li[5]//a")
	public WebElement Tax_Forms_Tab;

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//thead//th[1]//b")
	public WebElement Inbox_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//h4")
	public WebElement Ask_A_Question_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//*[contains(text(),'Select the document')]")
	public WebElement Submit_Document_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//*[contains(text(),'Submitted forms')]")
	public WebElement Document_History_Tab_Header_Text;

	@FindBy(xpath = ".//*[@data-region-name=\"content\"]//section//*[contains(text(),' forms ')]")
	public WebElement Tax_Forms_Tab_Header_Text;

	public MessageCenterLayout(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public boolean verifyPageHeaders() {
		// interaction.waitForSeconds(4);
		WebElement element = getElementFromName("Message_Center_Layout_Header_Text");
		if (interaction.isElementVisible(element)) {
			return TestUtility.compareText(element, "Message_Center_Layout_Header_Text", true);
		}
		return false;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {

		WebElement element = null;
		switch (propertyName) {
		case "Message_Center_Layout_Header_Text":
			element = Header_Text;
			break;
		case "Message_Center_SubHeader_Text":
			element = SubHeader_Text;
			break;
		case "Inbox_Tab":
			element = Inbox_Tab;
			break;
		case "Ask_A_Question_Tab":
			element = Ask_A_Question_Tab;
			break;
		case "Submit_Document_Tab":
			element = Submit_Document_Tab;
			break;
		case "Document_History_Tab":
			element = Document_History_Tab;
			break;
		case "Tax_Forms_Tab":
			element = Tax_Forms_Tab;
			break;
		case "Inbox_Tab_Header_Text":
			element = Inbox_Tab_Header_Text;
			break;
		case "Ask_A_Question_Tab_Header_Text":
			element = Ask_A_Question_Tab_Header_Text;
			break;
		case "Submit_Document_Tab_Header_Text":
			element = Submit_Document_Tab_Header_Text;
			break;
		case "Document_History_Tab_Header_Text":
			element = Document_History_Tab_Header_Text;
			break;
		case "Tax_Forms_Tab_Header_Text":
			element = Tax_Forms_Tab_Header_Text;
			break;
		}
		if (interaction.waitForElement(element)) {
			log.info("Returning element for input name - " + propertyName);
			return element;
		} else {
			return null;
		}
	}

	@Override
	public boolean navigateToTab(String tabName) {
		String inputTabName = tabName.replaceAll(" ", "_") + "_Tab";
		log.info("Navigating to Tab : " + inputTabName);
		WebElement tabNameObj = getElementFromName(inputTabName);
		if (interaction.clickWebElement(tabNameObj)) {
			String tabHeaderObjName = inputTabName + "_Header_Text";
			log.info("Tab Header Object Name :: " + tabHeaderObjName);
			WebElement tabNameHeaderObj;

			// finding objects that reload DOM
			if (inputTabName.contentEquals("Tax_Forms_Tab")) {
				return true;
				/*
				 * interaction.waitForSeconds(5); tabNameHeaderObj = driver.findElement( By.
				 * xpath(".//*[@data-region-name=\"content\"]//section//*[contains(text(),' forms ')]"
				 * ));
				 */
			} else {
				tabNameHeaderObj = getElementFromName(tabHeaderObjName);
			}

			// Verifying if Tab Header is loaded
			if (interaction.isElementVisible(tabNameHeaderObj)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean verifyTabAvailability(String tabName) {

		String inputTabName = tabName.replaceAll(" ", "_") + "_Tab";
		if (TestUtility.compareText(getElementFromName(inputTabName), inputTabName, true)) {
			String tabHeaderObjName = inputTabName + "_Header_Text";
			WebElement tabNameHeaderObj;
			// finding objects that reload DOM
			if (inputTabName.contentEquals("Tax_Forms_Tab")) {
				return true;
				/*
				 * interaction.waitForSeconds(5); tabNameHeaderObj = driver.findElement( By.
				 * xpath(".//*[@data-region-name=\"content\"]//section//*[contains(text(),' forms ')]"
				 * ));
				 */
			} else {
				tabNameHeaderObj = getElementFromName(tabHeaderObjName);
			}
			if (TestUtility.compareText(tabNameHeaderObj, tabHeaderObjName, true)) {
				return true;
			}
		}
		return false;
	}

}
