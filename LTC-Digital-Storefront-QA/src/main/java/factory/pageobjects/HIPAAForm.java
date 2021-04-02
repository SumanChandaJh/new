package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;
import factory.pagetemplates.FormPageTemplate;

public class HIPAAForm extends FormPageTemplate {

	private Interaction interaction;
	private Driver driver;
	private static Logger log = Logger.getLogger(HIPAAForm.class);  

	@FindBy(xpath = ".//*[@class=\"container cLtcDescriptionHeader\"]/h4")
	public WebElement Header_Policy_Title;

	@FindBy(xpath = ".//*[@class=\"container cLtcDescriptionHeader\"]/h1")
	public WebElement Header_Insured_Name_Title;

	@FindBy(xpath = ".//*[@id=\"addhippaagentform\"]/h3")
	public WebElement Header_Form_Title;

	@FindBy(xpath = ".//*[@id=\"addhippaagentform\"]/div[1]")
	public WebElement Header_Form_Text;

	public HIPAAForm(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public boolean verifyPageHeaders() {
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

	@Override
	public boolean fillForm() {
		// TODO Auto-generated method stub
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

}
