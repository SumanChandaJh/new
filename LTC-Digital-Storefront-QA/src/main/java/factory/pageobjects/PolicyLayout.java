package factory.pageobjects;

import org.openqa.selenium.WebElement;

import factory.driver.Driver;
import factory.pagetemplates.TabPageTemplate;

public class PolicyLayout extends TabPageTemplate {

	
	//covergae tab objects
	public PolicyLayout(Driver driver) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean verifyPageHeaders() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean navigateToTab(String tabName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifyTabAvailability(String tabName) {
//verify

		return false;
	}

}
