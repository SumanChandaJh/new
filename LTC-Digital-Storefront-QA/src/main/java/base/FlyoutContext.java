package base;

import factory.driver.Driver;
import factory.driver.DriverManager;
import factory.pageobjects.ClaimsFlyoutPage;
import factory.pageobjects.ContactUsFlyoutPage;
import factory.pageobjects.MessageCenterFlyoutPage;
import factory.pageobjects.PolicyFlyoutPage;
import factory.pageobjects.PremiumsFlyoutPage;

public class FlyoutContext extends TestContext {

	// FlyoutPages
	public PolicyFlyoutPage policyFlyoutPage;
	public ContactUsFlyoutPage contactUsFlyoutPage;
	public MessageCenterFlyoutPage messageCenterFlyoutPage;
	public ClaimsFlyoutPage claimsFlyoutPage;
	public PremiumsFlyoutPage premiumsFlyoutPage;

	public FlyoutContext() {
		super();
		inititializePages();
	}

	private void inititializePages() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		policyFlyoutPage = new PolicyFlyoutPage(driver);
		contactUsFlyoutPage = new ContactUsFlyoutPage(driver);
		messageCenterFlyoutPage = new MessageCenterFlyoutPage(driver);
		claimsFlyoutPage = new ClaimsFlyoutPage(driver);
		premiumsFlyoutPage = new PremiumsFlyoutPage(driver);
	}

	public boolean verifyTextForFlyoutElement(String flyout_name, String propertyName) {

		if (flyout_name.contentEquals("Policies")) {
			return policyFlyoutPage.verifyElementTextForFlyout(propertyName);
		} else if (flyout_name.contentEquals("Premiums")) {
			return premiumsFlyoutPage.verifyElementTextForFlyout(propertyName);
		} else if (flyout_name.contentEquals("Claims")) {
			return claimsFlyoutPage.verifyElementTextForFlyout(propertyName);
		} else if (flyout_name.contentEquals("Message Center")) {
			return messageCenterFlyoutPage.verifyElementTextForFlyout(propertyName);
		} else if (flyout_name.contentEquals("Contact Us")) {
			return contactUsFlyoutPage.verifyElementTextForFlyout(propertyName);
		}
		return false;
	}

	public boolean clickElementForFlyouts(String flyout_name, String propertyName) {

		if (flyout_name.contentEquals("Policies")) {

		} else if (flyout_name.contentEquals("Premiums")) {

		} else if (flyout_name.contentEquals("Claims")) {

		} else if (flyout_name.contentEquals("Message Center")) {
			return messageCenterFlyoutPage.clickElement(propertyName);

		} else if (flyout_name.contentEquals("Contact Us")) {
			return contactUsFlyoutPage.clickElement(propertyName);
		}
		return false;
	}
}
