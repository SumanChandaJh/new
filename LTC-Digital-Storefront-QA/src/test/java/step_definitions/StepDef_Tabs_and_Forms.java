package step_definitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import base.FormPageContext;
import base.TabPageContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Tabs_and_Forms {

	private TabPageContext tabPageContext;
	private FormPageContext formPageContext;
	private String pageName, tabName, formName;

	public StepDef_Tabs_and_Forms(TabPageContext tabPageContext, FormPageContext formPageContext) {
		this.tabPageContext = tabPageContext;
		this.formPageContext = formPageContext;

	}

	@Then("I see {string} layout page with appropriate headers")
	public void i_see_layout_page_with_appropriate_headers(String pageName) {
		this.pageName = pageName;
		Assert.assertTrue(tabPageContext.verifyPageHeaders(pageName), "Page Headers are not as expected.");
	}

	@When("I select {string} tab")
	public void i_select_tab(String tabName) {
		Assert.assertTrue(tabPageContext.navigateToTab(pageName, tabName), "Unable to select tab.");
	}

	@Then("I see {string} tab with appropriate headers")
	public void i_see_tab_with_appropriate_headers(String tabName) {
		this.tabName = tabName;
		Assert.assertTrue(tabPageContext.verifyTabAvailability(pageName, tabName), tabName + " tab is not available.");
	}

	/***
	 * ********* Submit Document Tab Steps *****************************
	 */

	@When("I select {string} from policy selector")
	public void i_select_from_policy_selector(String policyNumber) {
		Assert.assertTrue(tabPageContext.selectPolicy(tabName, policyNumber));
	}

	@When("I select {string} from claim selector")
	public void i_select_from_claim_selector(String claimNumber) {
		Assert.assertTrue(tabPageContext.selectClaim(tabName, claimNumber));
	}

	@Then("I see {string} card with expected contents and link")
	public void i_see_card_with_expected_contents_and_link(String cardName) {
		Assert.assertTrue(tabPageContext.verifyCardAvailability(tabName, cardName),
				cardName + " Card is not available.");
	}

	@When("I select {string} card")
	public void i_select_card(String cardName) {
		Assert.assertTrue(tabPageContext.selectCard(tabName, cardName), cardName + " Card is not available.");
	}

	/***
	 * ********* Form Steps *****************************
	 */

	@Then("I see {string} form with appropriate headers")
	public void i_see_form_with_appropriate_headers(String formName) {
		this.formName = formName;
		Assert.assertTrue(formPageContext.verifyPageHeaders(formName));
	}

	@Then("I all the fields for {string} are available")
	public void i_all_the_fields_for_are_available(String formName) {
		Assert.assertTrue(formPageContext.verifyFormFields(formName));
	}

	@When("I fill in the {string} form")
	public void i_fill_in_the_form(String formName) {
		Assert.assertTrue(formPageContext.fillForm(formName));
	}

	@When("click on {string} button")
	public void click_on_button(String submitButtonText) {
		Assert.assertTrue(formPageContext.clickSubmitButton(formName));
	}

	@Then("I see message of successful {string} form submission")
	public void i_see_message_of_successful_form_submission(String formName) {
		Assert.assertTrue(formPageContext.verifySuccessfulSubmissionMessage(formName));
	}

	@Then("I see error message of {string} for the empty fields")
	public void i_see_error_message_of_for_the_empty_fields(String string) {
	}

	/***
	 * ********* Submit Invoice Steps *****************************
	 */

	@When("I select provider of type {string}")
	public void i_select_provider_of_type(String providerType) {
		Assert.assertTrue(formPageContext.submitInvoiceForm.selectProviderByType(providerType));
	}

	@When("I fill submit invoice form for {string}")
	public void i_fill_submit_invoice_form_for(String providerType) throws InvalidFormatException, IOException {
		Assert.assertTrue(formPageContext.submitInvoiceForm.fillInvoiceForm(providerType));
	}

	@When("I click on the submit button")
	public void i_click_on_the_submit_button() {
	}

}
