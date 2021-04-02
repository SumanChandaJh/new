package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.FlyoutPageTemplate;

public class ContactUsFlyoutPage extends FlyoutPageTemplate {

	Logger log = Logger.getLogger(ContactUsFlyoutPage.class);
	Interaction interaction;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[1]//*[contains(@class,'top-header')]")
	public WebElement contact_us_section1_header_text;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[1]//*[contains(@class,'top-subheader')]")
	public WebElement contact_us_section1_subheader_text;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[2]//*[contains(@class,'top-subheader')]")
	public WebElement contact_us_section2_header_title;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[2]/c-ltc-button[1]/a//div")
	public WebElement contact_us_link_faq;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[2]/c-ltc-button[2]/a//div")
	public WebElement contact_us_link_ask_question;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[3]/div")
	public WebElement contact_us_section3_header_title;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]//section[3]//a/div")
	public WebElement contact_us_link_contact_info;

	@FindBy(xpath = "//*[@class='contactus color-overide']//*[text()='Contact Us']")
	public WebElement contact_us_page_header_text;

	@FindBy(xpath = "//*[@class='contactus color-overide']//*[contains(text(),'Get in touch')]")
	public WebElement contact_us_page_subheader_text;

	@FindBy(xpath = "//div[contains(@class, 'slds-p-bottom_small') and contains(text(), 'Long')]")
	public WebElement contact_us_page_section1_header1_text;

	@FindBy(xpath = "//a[contains(@href, 'tel:800 377 7311')]")
	public WebElement contact_us_page_section1_header1_phone;

	@FindBy(xpath = "//div[contains(@class, 'slds-p-bottom_small') and contains(text(), 'Fax')]")
	public WebElement contact_us_page_section1_header1_fax;

	@FindBy(xpath = "//div[contains(text(), 'Long-term')]/parent::div/div[4]")
	public WebElement contact_us_page_section1_header1_textmessage1;
	/*
	 * //div[contains(@class, 'slds-p-bottom_small') and contains(text(),
	 * 'Fax')]/following-sibling::div[contains(text(), 'Monday')]
	 */

	@FindBy(xpath = "//div[contains(text(), 'Long-term')]/parent::div/div[5]")
	public WebElement contact_us_page_section1_header1_textmessage2;
	/*
	 * //div[contains(@class, 'slds-p-bottom_small') and contains(text(),
	 * 'Fax')]/following-sibling::div[contains(text(), 'Closed')]
	 */

	@FindBy(xpath = "//div[contains(@class, 'slds-p-bottom_small') and contains(text(), 'If')]")
	public WebElement contact_us_page_section1_header2_text;

	@FindBy(xpath = "//a[contains(@href, 'tel:800 233 1449')]")
	public WebElement contact_us_page_section1_header2_phone;

	@FindBy(xpath = "//div[contains(@class, 'slds-p-bottom_small') and contains(text(), 'If')]/parent::div/div[4]")
	public WebElement contact_us_page_section1_header2_textmessage1;

	@FindBy(xpath = "//div[contains(@class, 'slds-p-bottom_small') and contains(text(), 'If')]/parent::div/div[5]")
	public WebElement contact_us_page_section1_header2_textmessage2;

	@FindBy(xpath = "//strong[contains(text(), 'Mail:')]")
	public WebElement contact_us_page_section2_mail;

	@FindBy(xpath = "//strong[contains(text(), 'Mail:')]//parent::div//parent::div/div[2]")
	public WebElement contact_us_Page_section2_mail_address_line1;

	@FindBy(xpath = "//*[contains(text(), 'PO Box 852')]")
	public WebElement contact_us_Page_section2_mail_address_line2;

	@FindBy(xpath = "//*[contains(text(), 'Boston, MA 02117-0852')]")
	public WebElement contact_us_Page_section2_mail_address_line3;

	public ContactUsFlyoutPage(Driver driver) {
		PageFactory.initElements(driver, this);
		this.interaction = Interaction.getInstance();
	}

	@Override
	public boolean clickElement(String properyName) {
		return interaction.clickWebElement(getElementFromName(properyName));

	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		WebElement element = null;

		if (propertyName.contentEquals("Contact_Us_Header_Text")) {
			element = contact_us_section1_header_text;
		} else if (propertyName.contentEquals("Contact_Us_SubHeader_Text")) {
			element = contact_us_section1_subheader_text;
		} else if (propertyName.contentEquals("Contact_Us_Quick_Links_Header_Text")) {
			element = contact_us_section2_header_title;
		} else if (propertyName.contentEquals("Contact_Us_View_FAQs_Link_Text")) {
			element = contact_us_link_faq;
		} else if (propertyName.contentEquals("Contact_Us_Ask_Question_Link_Text")) {
			element = contact_us_link_ask_question;
		} else if (propertyName.contentEquals("Contact_Us_Need_Help_Header_Text")) {
			element = contact_us_section3_header_title;
		} else if (propertyName.contentEquals("Contact_Us_Need_Help_Link_Text")) {
			element = contact_us_link_contact_info;
		} else if (propertyName.contentEquals("Contact_Us_Page_Header_Text")) {
			element = contact_us_page_header_text;
		} else if (propertyName.contentEquals("Contact_Us_Page_SubHeader_Text")) {
			element = contact_us_page_subheader_text;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header1_Text")) {
			element = contact_us_page_section1_header1_text;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header1_Phone")) {
			element = contact_us_page_section1_header1_phone;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header1_Fax")) {
			element = contact_us_page_section1_header1_fax;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header1_TextMessage1")) {
			element = contact_us_page_section1_header1_textmessage1;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header1_TextMessage2")) {
			element = contact_us_page_section1_header1_textmessage2;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header2_Text")) {
			element = contact_us_page_section1_header2_text;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header2_Phone")) {
			element = contact_us_page_section1_header2_phone;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header2_TextMessage1")) {
			element = contact_us_page_section1_header2_textmessage1;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section1_Header2_TextMessage2")) {
			element = contact_us_page_section1_header2_textmessage2;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section2_Mail")) {
			element = contact_us_page_section2_mail;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section2_Mail_Address_Line1")) {
			element = contact_us_Page_section2_mail_address_line1;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section2_Mail_Address_Line2")) {
			element = contact_us_Page_section2_mail_address_line2;
		} else if (propertyName.contentEquals("Contact_Us_Page_Section2_Mail_Address_Line3")) {
			element = contact_us_Page_section2_mail_address_line3;
		}
		if (interaction.waitForElement(element)) {
			return element;
		} else {
			return null;
		}
	}

	@Override
	public boolean verifyElementTextForFlyout(String properyName) {
		return TestUtility.compareText(getElementFromName(properyName), properyName, true);
	}

}
