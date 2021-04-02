package factory.pagetemplates;

import org.openqa.selenium.WebElement;

public abstract class FormPageTemplate {

	public abstract boolean verifyPageHeaders();

	public abstract WebElement getElementFromName(String propertyName);

	public abstract boolean verifyFormFields();

	public abstract boolean fillForm();

	public abstract boolean clickSubmitButton();

	public abstract boolean verifySuccessfulSubmissionMessage();

}
