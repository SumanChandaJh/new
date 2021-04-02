package factory.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class LoginPage {

	Interaction interaction;

	@FindBy(xpath = ".//h1[@class='banner-title']")
	public WebElement page_title;

	@FindBy(xpath = ".//*[@id='userName']")
	public WebElement username;

	@FindBy(xpath = ".//*[@id='passwordField']")
	public WebElement password;

	@FindBy(xpath = ".//*[@id='btnLogin']")
	public WebElement login_button;

	public LoginPage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	public boolean checkHeaderTitle(String page_title_string) {
		return interaction.verifyElementTextFromProperties(page_title, page_title_string);
	}

	public void clickLoginButton() {
		if (interaction.waitForElement(page_title)) {
			interaction.clickWebElement(login_button);
		}
	}

}
