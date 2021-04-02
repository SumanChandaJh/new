package step_definitions;

import org.testng.Assert;

import base.TabPageContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_DigitalPayments {

	private TabPageContext tabPageContext;

	public StepDef_DigitalPayments(TabPageContext tabPageContext) {
		this.tabPageContext = tabPageContext;
	}

	@Then("I see Premium Amount due as {string}")
	public void i_see_premium_amount_due_as(String amount_due) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyAmountDue(amount_due));
	}

	@Then("I see Premium Amount due date as {string}")
	public void i_see_premium_amount_due_date_as(String amount_due_date) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyAmountDueDate(amount_due_date));
	}

	@Then("I see Premium Amount frequency as {string}")
	public void i_see_premium_amount_frequency_as(String amount_amount_frequency) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyAmountFrequency(amount_amount_frequency));
	}

	@When("I click on link to view amount due details")
	public void i_click_on_link_to_view_amount_due_details() {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.clickMoreDetailsLink());
	}

	@Then("I see Premium Amount as {string}")
	public void i_see_premium_amount_as(String premium_amount) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyPremiumAmount(premium_amount));
	}

	@Then("I see Premium Amount received as {string}")
	public void i_see_premium_amount_received_as(String premium_amount_received) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyPremiumAmountReceived(premium_amount_received));
	}

	@Then("I see net amount due as {string}")
	public void i_see_net_amount_due_as(String net_amount_due) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyNetAmountDue(net_amount_due));
	}

	@Then("I see One-Time Payment Card with header as {string} and content as {string}")
	public void i_see_one_time_payment_card_with_header_as_and_content_as(String card_header_text, String card_content) {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.verifyOneTimePaymentCardText(card_header_text,card_content));
	}

	@When("I click on One-Time Payment Card link")
	public void i_click_on_one_time_payment_card_link() {
		Assert.assertTrue(tabPageContext.digitalPaymentsLayout.clickOneTimePaymentCardLink());
	}

	@Then("I see Terms of Use Modal Window with appropriate headers ans content")
	public void i_see_terms_of_use_modal_window_with_appropriate_headers_ans_content() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click to agree to terms of use checkbox")
	public void i_click_to_agree_to_terms_of_use_checkbox() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on Submit button on terms of use modal window")
	public void i_click_on_submit_button_on_terms_of_use_modal_window() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I wait for One Inc Payment Modal window to display for {string} seconds")
	public void i_wait_for_one_inc_payment_modal_window_to_display_for_seconds(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I see {string} screen of One Inc Modal Window with appropriate fields")
	public void i_see_screen_of_one_inc_modal_window_with_appropriate_fields(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I click on {string} button of One Inc Modal Window")
	public void i_click_on_button_of_one_inc_modal_window(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter {string} in routing number field")
	public void i_enter_in_routing_number_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter {string} in Account Number field")
	public void i_enter_in_account_number_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@When("I enter {string} in Repeat Account Number field")
	public void i_enter_in_repeat_account_number_field(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I click to download the Print Receipt")
	public void i_click_to_download_the_print_receipt() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("I close the One Inc Modal Window")
	public void i_close_the_one_inc_modal_window() {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
