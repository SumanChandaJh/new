package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class SFDC_Home {
	private Interaction interaction;
	private Driver driver;
	private static Logger log = Logger.getLogger(SFDC_Home.class);

	public SFDC_Home(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@FindBy(xpath = ".//one-app-launcher-header")
	public WebElement page_title_logo;

	@FindBy(xpath = ".//one-app-nav-bar/nav/div//a[@title='Home']")
	public WebElement tab_Home;

	@FindBy(xpath = ".//one-app-nav-bar/nav/div//a[@title='Accounts']")
	public WebElement tab_accounts;

	@FindBy(xpath = ".//*[contains(@class,'oneHeader')]//div[contains(@class,'uiInput uiAutocomplete ')]/input")
	public WebElement searchbox;

	@FindBy(xpath = ".//*[contains(@class,'breadcrumb__item')]/span")
	public WebElement tab_identifier_text;

	// *[contains(text(),'$1')]//parent::a

	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//tbody/tr[1]/th/span/a")
	public WebElement search_result_table_first_item;

}
