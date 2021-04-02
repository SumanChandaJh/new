package factory.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class HomePage {

	Interaction interaction;

	@FindBy(xpath = ".//*[@class=\"header cLtcLightningHeader\"]//img[@class=\"header-logo\"]")
	public WebElement header_item_logo;

	@FindBy(xpath = ".//section//ul/div[1]/a")
	public WebElement header_item_fullname;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]")
	public WebElement flyout_menu_item_contact_us;

	@FindBy(xpath = ".//*[@data-id=\"messageMenuItem\"]")
	public WebElement flyout_menu_item_message_center;

	@FindBy(xpath = ".//*[@data-id=\"policyMenuItem\"]")
	public WebElement flyout_menu_item_policies;

	@FindBy(xpath = ".//*[@data-id=\"claimMenuItem\"]")
	public WebElement flyout_menu_item_claims;

	@FindBy(xpath = ".//*[@data-id=\"premiumMenuItem\"]")
	public WebElement flyout_menu_item_premiums;

	@FindBy(xpath = ".//*[@class=\"jh-nav-pad \"]//*[text()='My Dashboard']")
	public WebElement myDashboardTab;

	@FindBy(xpath = ".//section//ul//li//p")
	public WebElement old_header_item_fullname;

	public HomePage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	/**
	 * @description Method to select flyout by name
	 * @param flyout_name
	 * @return boolean
	 */
	public boolean selectFlyout(String flyout_name) {
		WebElement element = null;
		if (flyout_name.contentEquals("Contact Us")) {
			element = flyout_menu_item_contact_us;
		} else if (flyout_name.contentEquals("Message Center")) {
			element = flyout_menu_item_message_center;
		} else if (flyout_name.contentEquals("Policies")) {
			element = flyout_menu_item_policies;
		} else if (flyout_name.contentEquals("Claims")) {
			element = flyout_menu_item_claims;
		} else if (flyout_name.contentEquals("Premiums")) {
			element = flyout_menu_item_premiums;
		}

		if (interaction.waitForElement(element)) {
			return interaction.clickWebElement(element);
		}
		return false;
	}
}
