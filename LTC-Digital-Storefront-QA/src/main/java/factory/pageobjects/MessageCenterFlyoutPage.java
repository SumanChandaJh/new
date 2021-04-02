package factory.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.FlyoutPageTemplate;

public class MessageCenterFlyoutPage extends FlyoutPageTemplate {

	Interaction interaction;

	@FindBy(xpath = ".//*[@data-id=\"messageMenuItem\"]//section[1]//*[contains(@class,'top-header')]")
	public WebElement Message_Center_Header_Text;

	@FindBy(xpath = ".//*[@data-id=\"messageMenuItem\"]//section[1]//*[contains(@class,'top-subheader')]")
	public WebElement Message_Center_SubHeader_Text;

	@FindBy(xpath = ".//*[@data-id=\"messageMenuItem\"]//section[1]//a")
	public WebElement Message_Center_Link_Text;

	public MessageCenterFlyoutPage(Driver driver) {
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

		if (propertyName.contentEquals("Message_Center_Header_Text")) {
			element = Message_Center_Header_Text;
		} else if (propertyName.contentEquals("Message_Center_SubHeader_Text")) {
			element = Message_Center_SubHeader_Text;
		} else if (propertyName.contentEquals("Message_Center_Link_Text")) {
			element = Message_Center_Link_Text;
		}

		if (interaction.waitForElement(element)) {
			return element;
		} else
			return null;

	}

	@Override
	public boolean verifyElementTextForFlyout(String properyName) {
		return TestUtility.compareText(getElementFromName(properyName), properyName, true);
	}

}
