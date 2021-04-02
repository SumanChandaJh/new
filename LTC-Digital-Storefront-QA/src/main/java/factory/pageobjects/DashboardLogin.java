package factory.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class DashboardLogin {

	Interaction interaction;

	@FindBy(xpath = ".//h1[@id='loginpage']")
	public WebElement page_title;

	@FindBy(xpath = ".//*[@id='userName']")
	public WebElement username;

	@FindBy(xpath = ".//*[@id='passwordField']")
	public WebElement password;

	@FindBy(xpath = ".//*[@value=\"Login\"]")
	public WebElement login_button;

	public DashboardLogin(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	public boolean checkHeaderTitle(String page_title_string) {

		if (interaction.verifyElementTextFromProperties(page_title, page_title_string)) {
			interaction.highlightElement(page_title, true);
			return true;
		}
		return false;
	}

	public void clickLoginButton() {
		if (interaction.waitForElement(login_button)) {
			interaction.clickWebElement(login_button);
		}
	}
}
