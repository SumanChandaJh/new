package step_definitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.RegistrationContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Registration {

	private RegistrationContext registrationContext;

	public StepDef_Registration(RegistrationContext registrationContext) {
		this.registrationContext = registrationContext;
	}

	@Then("I see {string} as title of the Registration page")
	public void i_see_as_title_of_the_registration_page(String page_title_string) {
		Assert.assertTrue(registrationContext.checkBlueRibbonTitle(page_title_string));
	}

	@When("I select role as {string}")
	public void i_select_role_as(String role) {
		Assert.assertTrue(registrationContext.selectRegistrationRole(role));
	}

	@When("I enter {string} as Policy Number")
	public void i_enter_as_policy_number(String policyNumber) {
		Assert.assertTrue(registrationContext.interaction.setElementTextByJS(
				registrationContext.customerRegistrationPage.Insured_Policy_Number_Text, policyNumber));
	}

	@When("I enter {string} as Insured First Name")
	public void i_enter_as_insured_first_name(String insuredFirstName) {
		Assert.assertTrue(registrationContext.interaction.setTextElement(
				registrationContext.customerRegistrationPage.Insured_First_Name_Text, insuredFirstName));
	}

	@When("I enter {string} as Insured Last Name")
	public void i_enter_as_insured_last_name(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Last_Name_Text, string));
	}

	@When("I enter {string} as Insured Date of Birth")
	public void i_enter_as_insured_date_of_birth(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setElementTextByJS(registrationContext.customerRegistrationPage.Insured_Date_Of_Birth_Text, string));
	}

	@When("I enter {string} as Insured SSN last {int} digits")
	public void i_enter_as_insured_ssn_last_digits(String string, Integer int1) {
		Assert.assertTrue(registrationContext.interaction
				.setElementTextByJS(registrationContext.customerRegistrationPage.Insured_SSN_Text, string));
	}

	@When("I enter {string} as email address")
	public void i_enter_as_email_address(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Email_Address_Text, string));
	}

	@When("I enter {string} as confirm email address")
	public void i_enter_as_confirm_email_address(String string) {
		Assert.assertTrue(registrationContext.interaction.setTextElement(
				registrationContext.customerRegistrationPage.Insured_Confirm_Email_Address_Text, string));
	}

	@When("I enter {string} as Insured Daytime Phone Number")
	public void i_enter_as_insured_daytime_phone_number(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Phone_Number_Text, string));
	}

	@When("I enter {string} as Username")
	public void i_enter_as_username(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Username_Text, string));
	}

	@When("I enter {string} as Password")
	public void i_enter_as_password(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Password_Text, string));
	}

	@When("I enter {string} as Confirm Password")
	public void i_enter_as_confirm_password(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Insured_Confirm_Password_Text, string));
	}

	@When("I select {string} as Security Question {int}")
	public void i_select_as_security_question(String string, Integer int1) {

		WebElement element = null;

		switch (int1) {
		case 1:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Question_1_Text;
			break;
		case 2:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Question_2_Text;
			break;
		case 3:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Question_3_Text;
			break;
		default:
			break;
		}

		Assert.assertTrue(registrationContext.interaction.selectDropDownValue(element, string));
	}

	@When("I enter {string} as Security Answer {int}")
	public void i_enter_as_security_answer(String string, Integer int1) {

		WebElement element = null;

		switch (int1) {
		case 1:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Answer_1_Text;
			break;
		case 2:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Answer_2_Text;
			break;
		case 3:
			element = registrationContext.customerRegistrationPage.Insured_SQA_Answer_3_Text;
			break;
		default:
			break;
		}

		Assert.assertTrue(registrationContext.interaction.setTextElement(element, string));

	}

	@When("I click on Submit button")
	public void i_click_on_submit_button() {
		Assert.assertTrue(registrationContext.interaction
				.clickWebElement(registrationContext.customerRegistrationPage.Submit_Button));
	}

	@Then("I see the message for successful registration")
	public void i_see_the_message_for_successful_registration() {

		Assert.assertTrue(registrationContext.verifySuccessfulRegistrationMessage());

	}

	@When("I enter {string} as Registrant First Name")
	public void i_enter_as_registrant_first_name(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Registrant_First_Name_Text, string));
	}

	@When("I enter {string} as Registrant Last Name")
	public void i_enter_as_registrant_last_name(String string) {
		Assert.assertTrue(registrationContext.interaction
				.setTextElement(registrationContext.customerRegistrationPage.Registrant_Last_Name_Text, string));
	}

}
