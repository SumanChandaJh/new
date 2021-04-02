package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class SFDC_Login {

	private Interaction interaction;
	private Driver driver;
	private static Logger log = Logger.getLogger(SubmitInvoiceForm.class);

	public SFDC_Login(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@FindBy(xpath = ".//*[@id=\"logo\"]")
	public WebElement page_title_logo;

	@FindBy(xpath = ".//*[@id=\"username\"]")
	public WebElement username;

	@FindBy(xpath = ".//*[@id=\"password\"]")
	public WebElement password;

	@FindBy(xpath = ".//*[@id=\"Login\"]")
	public WebElement login_button;

}
