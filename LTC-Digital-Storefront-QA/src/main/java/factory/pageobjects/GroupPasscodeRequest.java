package factory.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;

public class GroupPasscodeRequest {

	private Interaction interaction;
	private static Logger log = Logger.getLogger(GroupPasscodeRequest.class);

	public GroupPasscodeRequest(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcDescriptionHeader\"]//h1//span")
	public WebElement GROUP_PASSCODE_REQUEST_HEADER_TEXT;

	@FindBy(xpath = ".//*[contains(text(),'Register here for online access to your Long-Term Care coverage')]/parent::*")
	public WebElement GROUP_PASSCODE_REQUEST_HEADER_CONTENT;

	@FindBy(xpath = ".//*[contains(text(),'I need a passcode')]")
	public WebElement NEED_PASSCODE_CARD_TITLE;

	@FindBy(xpath = ".//*[contains(text(),'I need a passcode')]/following-sibling::div")
	public WebElement NEED_PASSCODE_CARD_CONTENT;

	@FindBy(xpath = ".//*[contains(text(),'I need a passcode')]/parent::*/following-sibling::div")
	public WebElement NEED_PASSCODE_CARD_LINK;

	@FindBy(xpath = ".//*[contains(text(),'I have a passcode')]")
	public WebElement HAVE_PASSCODE_CARD_TITLE;

	@FindBy(xpath = ".//*[contains(text(),'I have a passcode')]/following-sibling::div")
	public WebElement HAVE_PASSCODE_CARD_CONTENT;

	@FindBy(xpath = ".//*[contains(text(),'I have a passcode')]/parent::*/following-sibling::div")
	public WebElement HAVE_PASSCODE_CARD_LINK;

	@FindBy(xpath = ".//*[text()='First name']")
	public WebElement FIRST_NAME_LABEL;

	@FindBy(xpath = ".//*[text()='First name']//following-sibling::div//input")
	public WebElement FIRST_NAME_INPUT;

	@FindBy(xpath = ".//*[text()='Last name']")
	public WebElement LAST_NAME_LABEL;

	@FindBy(xpath = ".//*[text()='Last name']//following-sibling::div//input")
	public WebElement LAST_NAME_INPUT;

	@FindBy(xpath = ".//*[text()='Long-Term Care Coverage ID']")
	public WebElement POLICY_LABEL;

	@FindBy(xpath = ".//*[text()='Long-Term Care Coverage ID']//following-sibling::div//input")
	public WebElement POLICY_INPUT;

	@FindBy(xpath = ".//*[text()='Date of birth']")
	public WebElement DATE_OF_BIRTH_LABEL;

	@FindBy(xpath = ".//*[text()='Date of birth']//following-sibling::div//input")
	public WebElement DATE_OF_BIRTH_INPUT;

	@FindBy(xpath = ".//*[text()='Submit request']/parent::a")
	public WebElement SUBMIT_REQUEST_LINK;

	@FindBy(xpath = ".//*[contains(@class,'cLtcConfirmationModal ')]//h2")
	public WebElement CONFIRM_PASSCODE_CHANGE_POPUP_TITLE;

	@FindBy(xpath = ".//*[contains(text(),'This request will generate')]")
	public WebElement CONFIRM_PASSCODE_CHANGE_POPUP_CONTENT;

	@FindBy(xpath = ".//*[contains(text(),'This request will generate')]/following-sibling::div//*[@value='Confirm']")
	public WebElement CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='infoSection']/strong")
	public WebElement GROUP_PASSCODE_REQUEST_PASS_ALERT_TITLE;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='infoSection']/div")
	public WebElement GROUP_PASSCODE_REQUEST_PASS_ALERT_CONTENT;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='closeSection']/button")
	public WebElement GROUP_PASSCODE_REQUEST_PASS_ALERT_CLOSE_LINK;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='infoSection']/strong")
	public WebElement GROUP_PASSCODE_REQUEST_FAIL_ALERT_TITLE;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='infoSection']/strong")
	public WebElement GROUP_PASSCODE_REQUEST_FAIL_ALERT_CONTENT;

	@FindBy(xpath = ".//*[@class='cLtcConfirmationPanel']//*[@class='closeSection']/button")
	public WebElement GROUP_PASSCODE_REQUEST_FAIL_ALERT_CLOSE_LINK;

	public WebElement getElementFromName(String propertyName) {

		WebElement element = null;
		switch (propertyName) {
		case "GROUP_PASSCODE_REQUEST_HEADER_TEXT":
			element = GROUP_PASSCODE_REQUEST_HEADER_TEXT;
			break;
		case "GROUP_PASSCODE_REQUEST_HEADER_CONTENT":
			element = GROUP_PASSCODE_REQUEST_HEADER_CONTENT;
			break;
		case "NEED_PASSCODE_CARD_TITLE":
			element = NEED_PASSCODE_CARD_TITLE;
			break;
		case "NEED_PASSCODE_CARD_CONTENT":
			element = NEED_PASSCODE_CARD_CONTENT;
			break;
		case "NEED_PASSCODE_CARD_LINK":
			element = NEED_PASSCODE_CARD_LINK;
			break;
		case "HAVE_PASSCODE_CARD_TITLE":
			element = HAVE_PASSCODE_CARD_TITLE;
			break;
		case "HAVE_PASSCODE_CARD_CONTENT":
			element = HAVE_PASSCODE_CARD_CONTENT;
			break;
		case "HAVE_PASSCODE_CARD_LINK":
			element = HAVE_PASSCODE_CARD_LINK;
			break;
		case "FIRST_NAME_LABEL":
			element = FIRST_NAME_LABEL;
			break;
		case "FIRST_NAME_INPUT":
			element = FIRST_NAME_INPUT;
			break;
		case "LAST_NAME_LABEL":
			element = LAST_NAME_LABEL;
			break;
		case "LAST_NAME_INPUT":
			element = LAST_NAME_INPUT;
			break;
		case "POLICY_LABEL":
			element = POLICY_LABEL;
			break;
		case "POLICY_INPUT":
			element = POLICY_INPUT;
			break;
		case "DATE_OF_BIRTH_LABEL":
			element = DATE_OF_BIRTH_LABEL;
			break;
		case "DATE_OF_BIRTH_INPUT":
			element = DATE_OF_BIRTH_INPUT;
			break;
		case "SUBMIT_REQUEST_LINK":
			element = SUBMIT_REQUEST_LINK;
			break;
		case "CONFIRM_PASSCODE_CHANGE_POPUP_TITLE":
			element = CONFIRM_PASSCODE_CHANGE_POPUP_TITLE;
			break;
		case "CONFIRM_PASSCODE_CHANGE_POPUP_CONTENT":
			element = CONFIRM_PASSCODE_CHANGE_POPUP_CONTENT;
			break;
		case "CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK":
			element = CONFIRM_PASSCODE_CHANGE_POPUP_OK_LINK;
			break;

		case "GROUP_PASSCODE_REQUEST_PASS_ALERT_TITLE":
			element = GROUP_PASSCODE_REQUEST_PASS_ALERT_TITLE;
			break;
		case "GROUP_PASSCODE_REQUEST_PASS_ALERT_CONTENT":
			element = GROUP_PASSCODE_REQUEST_PASS_ALERT_CONTENT;
			break;
		case "GROUP_PASSCODE_REQUEST_PASS_ALERT_CLOSE_LINK":
			element = GROUP_PASSCODE_REQUEST_PASS_ALERT_CLOSE_LINK;
			break;
		}
		if (interaction.waitForElement(element)) {
			log.info("Returning element for input name - " + propertyName);
			return element;
		} else {
			return null;
		}
	}

}
