package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class ProductionSFLogin {

	private Interaction interaction;
	private Driver driver;
	private static Logger log = Logger.getLogger(SFDC_Home.class);

	public ProductionSFLogin(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

}
