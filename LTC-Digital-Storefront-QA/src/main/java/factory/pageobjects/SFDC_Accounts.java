package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class SFDC_Accounts {
	private Interaction interaction;
	private Driver driver;
	private static Logger log = Logger.getLogger(SFDC_Accounts.class);

	public SFDC_Accounts(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@FindBy(xpath = ".// *[text()='Person Account']")
	public WebElement tab_identifier_text;

	@FindBy(xpath = ".//records-lwc-record-layout//ul/li[4]//lightning-primitive-icon")
	public WebElement options_dropdown_link;

	@FindBy(xpath = ".//*[@apiname=\"LoginToNetworkAsPersonUser\"]//a")
	public WebElement option_login_to_community_as_user;

	

}
