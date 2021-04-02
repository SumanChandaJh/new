package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class DashboardHome {
	Interaction interaction;
	private static Logger log = Logger.getLogger(DashboardHome.class);

	@FindBy(xpath = ".//*[@class=\"header-desktop\"]//*[@class=\"header-logo\"]")
	public WebElement header_item_logo;

	@FindBy(xpath = ".//*[@class=\"csfHeaderDropdown__nameText\"]")
	public WebElement header_item_fullname;

	@FindBy(xpath = ".//*[@data-id=\"contactMenuItem\"]")
	public WebElement flyout_menu_item_contact_us;

	@FindBy(xpath = ".//*[@class=\"policyCard__container\"]//h3[text()='Long-Term Care']")
	public WebElement card_LTC;

	@FindBy(xpath = ".//*[@class=\"policyCard__container\"]//h3[text()='Life Insurance']")
	public WebElement card_Life;

	@FindBy(xpath = ".//*[contains(text(),' sorry')]")
	public WebElement card_Error;

	public DashboardHome(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	public boolean verifyDashboardCardVisibility(String policyType) {
		WebElement element;
		log.info("Card Type to look for is : " + policyType);
		if (policyType.contains("LTC")) {
			element = card_LTC;
		} else if (policyType.contains("Life")) {
			element = card_Life;
		} else {
			element = card_Error;
		}

		if (interaction.waitForElement(element)) {
			if (interaction.isElementVisible(element)) {
				log.info("Card for " + policyType + " is visible.");
				interaction.highlightElement(element, true);
				return true;
			}
		}
		return false;
	}

}
