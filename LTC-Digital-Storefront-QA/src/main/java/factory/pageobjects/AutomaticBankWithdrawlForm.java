package factory.pageobjects;

import org.openqa.selenium.WebElement;

import factory.driver.Driver;
import factory.pagetemplates.FormPageTemplate;


public class AutomaticBankWithdrawlForm extends FormPageTemplate {

	public AutomaticBankWithdrawlForm(Driver driver) {
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
	public boolean verifyFormFields() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean fillForm(String... inputStrings) {
		return false;
	}

	@Override
	public boolean clickSubmitButton() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean verifySuccessfulSubmissionMessage() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fillForm() {
		// TODO Auto-generated method stub
		return false;
	}

}
