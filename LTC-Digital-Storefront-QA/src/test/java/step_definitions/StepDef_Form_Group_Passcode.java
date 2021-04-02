/**
 * 
 */
package step_definitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import base.TestContext;
import base.TestUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author rajansa
 *
 */
public class StepDef_Form_Group_Passcode {

	private TestContext testContext;

	public StepDef_Form_Group_Passcode(TestContext testContext) {
		this.testContext = testContext;
	}

	@Then("I see the page header as {string}")
	public void i_see_the_page_header_as(String pageHeader) throws AssertionError {
		Assert.assertTrue(TestUtility.compareText(testContext.groupPasscodeRequest.GROUP_PASSCODE_REQUEST_HEADER_TEXT,
				pageHeader, true), "Page Header is not as expected.");
	}

	@Then("I see the content of header as {string}")
	public void i_see_the_content_of_header_as(String pageHeaderContent) throws AssertionError {
		Assert.assertTrue(
				TestUtility.compareText(testContext.groupPasscodeRequest.GROUP_PASSCODE_REQUEST_HEADER_CONTENT,
						pageHeaderContent, true),
				"Page Header Content is not as expected.");
	}

	@Then("I see a card with title {string} with content as {string} and with link {string}")
	public void i_see_a_card_with_title_with_content_as_and_with_link(String cardTitle, String cardContent,
			String cardLink) throws AssertionError {
		String cardType = "";
		if (cardTitle.contains("NEED_PASSCODE")) {
			cardType = "NEED_PASSCODE";
		} else if (cardTitle.contains("HAVE_PASSCODE")) {
			cardType = "HAVE_PASSCODE";
		}
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(TestUtility.compareText(
				testContext.groupPasscodeRequest.getElementFromName(cardType + "_CARD_TITLE"), cardTitle, true));
		softAssert.assertTrue(TestUtility.compareText(
				testContext.groupPasscodeRequest.getElementFromName(cardType + "_CARD_CONTENT"), cardContent, true));
		softAssert.assertTrue(TestUtility.compareText(
				testContext.groupPasscodeRequest.getElementFromName(cardType + "_CARD_LINK"), cardLink, true));
		softAssert.assertAll();

	}

	@When("I click on {string}")
	public void i_click_on(String link) throws AssertionError {
		Assert.assertTrue(
				testContext.interaction.clickWebElement(testContext.groupPasscodeRequest.getElementFromName(link)),
				"Unable to click link for : " + link);
	}

	@Then("I see a Group Passcode Form fields")
	public void i_see_a_group_passcode_form_fields() throws AssertionError {
		SoftAssert softAssert = new SoftAssert();

		softAssert.assertTrue(
				testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.FIRST_NAME_LABEL));
		softAssert.assertTrue(
				testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.FIRST_NAME_INPUT));
		softAssert
				.assertTrue(testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.LAST_NAME_LABEL));
		softAssert
				.assertTrue(testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.LAST_NAME_INPUT));
		softAssert.assertTrue(testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.POLICY_LABEL));
		softAssert.assertTrue(testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.POLICY_INPUT));
		softAssert.assertTrue(
				testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.DATE_OF_BIRTH_LABEL));
		softAssert.assertTrue(
				testContext.interaction.isElementVisible(testContext.groupPasscodeRequest.DATE_OF_BIRTH_INPUT));

		softAssert.assertAll();
	}

	@When("I enter Passcode Requester first name as {string}")
	public void i_enter_passcode_requester_first_name_as(String firstName) throws AssertionError {
		Assert.assertTrue(
				testContext.interaction.setTextElement(testContext.groupPasscodeRequest.FIRST_NAME_INPUT, firstName));
	}

	@When("I enter Passcode Requester last name as {string}")
	public void i_enter_passcode_requester_last_name_as(String lastName) throws AssertionError {
		Assert.assertTrue(
				testContext.interaction.setTextElement(testContext.groupPasscodeRequest.LAST_NAME_INPUT, lastName));
	}

	@When("I enter Passcode Requester policy number as {string}")
	public void i_enter_passcode_requester_policy_number_as(String policyNumber) throws AssertionError {
		Assert.assertTrue(
				testContext.interaction.setTextElement(testContext.groupPasscodeRequest.POLICY_INPUT, policyNumber));
	}

	@When("I enter Passcode Requester date of birth as {string}")
	public void i_enter_passcode_requester_date_of_birth_as(String dateOfBirth) throws AssertionError {
		Assert.assertTrue(testContext.interaction.setTextElement(testContext.groupPasscodeRequest.DATE_OF_BIRTH_INPUT,
				dateOfBirth));
	}

	@Then("I see a popup message for {string}")
	public void i_see_a_popup_message_for(String popupType) throws AssertionError {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(
				TestUtility.compareText(testContext.groupPasscodeRequest.CONFIRM_PASSCODE_CHANGE_POPUP_TITLE,
						popupType + "_POPUP_TITLE", true));
		softAssert.assertTrue(
				TestUtility.compareText(testContext.groupPasscodeRequest.CONFIRM_PASSCODE_CHANGE_POPUP_CONTENT,
						popupType + "_POPUP_CONTENT", true));
		softAssert.assertAll();
	}

	@When("I confirm the {string}")
	public void i_confirm_the(String link) {
		Assert.assertTrue(
				testContext.interaction.clickWebElement(testContext.groupPasscodeRequest.getElementFromName(link)),
				"Unable to click link for : " + link);

	}

	@Then("I see an alert message for {string}")
	public void i_see_an_alert_message_for(String alertName) throws AssertionError {
		String alertType = "";
		if (alertName.contentEquals("GROUP_PASSCODE_REQUEST_PASS")) {
			alertType = "PASS";
		} else if (alertName.contentEquals("GROUP_PASSCODE_REQUEST_FAIL")) {
			alertType = "FAIL";
		} else if (alertName.contentEquals("GROUP_PASSCODE_REQUEST_INVALID")) {
			alertType = "INVALID";
		}

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(TestUtility.compareText(
				testContext.interaction.waitForElementToBeClickable(
						testContext.groupPasscodeRequest.GROUP_PASSCODE_REQUEST_PASS_ALERT_TITLE),
				"GROUP_PASSCODE_REQUEST_" + alertType + "_ALERT_TITLE", true));
		softAssert.assertTrue(TestUtility.compareText(
				testContext.interaction.waitForElementToBeClickable(
						testContext.groupPasscodeRequest.GROUP_PASSCODE_REQUEST_PASS_ALERT_CONTENT),
				"GROUP_PASSCODE_REQUEST_" + alertType + "_ALERT_CONTENT", true));

		softAssert.assertAll();

	}
}
