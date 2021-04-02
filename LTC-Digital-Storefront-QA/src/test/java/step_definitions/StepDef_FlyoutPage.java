package step_definitions;

import org.testng.Assert;

import base.FlyoutContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_FlyoutPage {

	private FlyoutContext context;
	private String flyout_name;

	public StepDef_FlyoutPage(FlyoutContext context) {
		this.context = context;
	}

	@Then("^I click on the \"([^\"]*)\"$")
	public void i_click_on_the(String submitButton) throws Throwable {

		Assert.assertTrue(context.clickElementForFlyouts(flyout_name, submitButton),
				submitButton + " couldnt be clicked ");
		Thread.sleep(10000);
	}

	@When("^I click on the quick link \"([^\"]*)\"$")
	public void i_click_on_the_quick_link(String quick_link) throws Throwable {
		Assert.assertTrue(context.clickElementForFlyouts(flyout_name, quick_link),
				"Quick link " + quick_link + " couldnt be clicked ");
		// interaction.waitForSeconds(20);
		// Thread.sleep(20000);
	}


	@When("^I hover over the \"([^\"]*)\" flyout menu item$")
	public void i_hover_over_the_flyout_menu_item(String flyout_name) throws Throwable {
		this.flyout_name = flyout_name;
		Assert.assertTrue(context.homePage.selectFlyout(flyout_name), "Unable to select flyout - " + flyout_name);
	}

	@Then("^I see a fax number as \"([^\"]*)\" below the phone number$")
	public void i_see_a_fax_number_as_below_the_phone_number(String faxnumber) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, faxnumber),
				"Text for " + faxnumber + " is not as expected.");
	}

	@Then("^I see a generic text message as \"([^\"]*)\" below the above headers$")
	public void i_see_a_generic_text_message_as_below_the_above_headers(String text) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, text),
				"Text for " + text + " is not as expected.");
	}

	@Then("^I see a header as \"([^\"]*)\"$")
	public void i_see_a_header_as(String header) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");

	}

	@Then("^I see a header as \"([^\"]*)\" and sub-header as \"([^\"]*)\"$")
	public void i_see_a_header_as_and_sub_header_as(String header, String subheader) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, subheader),
				"Text for " + subheader + " is not as expected.");
	}

	@Then("^I see a phone number as \"([^\"]*)\" below the header in the same section$")
	public void i_see_a_phone_number_as_below_the_header_in_the_same_section(String phonenumber) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, phonenumber),
				"Text for " + phonenumber + " is not as expected.");
	}

	@Then("^I see a section in the page with a header as \"([^\"]*)\"$")
	public void i_see_a_section_in_the_page_with_a_header_as(String header) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
	}

	@Then("^I see a section with header \"([^\"]*)\"$")
	public void i_see_a_section_with_header(String headerName) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, headerName),
				"Text for " + headerName + " is not as expected.");
	}

	@Then("^I see another header as \"([^\"]*)\" on the right side of the page$")
	public void i_see_another_header_as_on_the_right_side_of_the_page(String header) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
	}

	@Then("^I see another phone number as \"([^\"]*)\" below the above header$")
	public void i_see_another_phone_number_as_below_the_above_header(String phonenumber) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, phonenumber),
				"Text for " + phonenumber + " is not as expected.");
	}

	@Then("^I see five quick links as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" below the above one$")
	public void i_see_five_quick_links_as_and_and_and_and_below_the_above_one(String quicklink1, String quicklink2,
			String quicklink3, String quicklink4, String quicklink5) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quicklink1),
				"Quick link " + quicklink1 + " is not as expected");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quicklink2),
				"Quick link " + quicklink2 + " is not as expected");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quicklink3),
				"Quick link " + quicklink3 + " is not as expected");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quicklink4),
				"Quick link " + quicklink4 + " is not as expected");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quicklink5),
				"Quick link " + quicklink5 + " is not as expected");
	}

	@Then("^I see \"([^\"]*)\" flyout page with header as \"([^\"]*)\" and sub-header as  \"([^\"]*)\"$")
	public void i_see_flyout_page_with_header_as_and_sub_header_as(String flyout_name, String header, String sub_header)
			throws Throwable {
		// this.flyout_name = flyout_name;
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, sub_header),
				"Text for " + sub_header + " is not as expected.");
	}

	@Then("^I see mailing address header as \"([^\"]*)\" in the below section having address details as \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_see_mailing_address_header_as_in_the_below_section_having_address_details_as_and_and(String header,
			String address_line_one, String address_line_two, String address_line_three) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, address_line_one),
				"Text for " + address_line_one + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, address_line_two),
				"Text for " + address_line_two + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, address_line_three),
				"Text for " + address_line_three + " is not as expected.");

	}

	@Then("^I see quick link \"([^\"]*)\" in the section$")
	public void i_see_quick_link_in_the_section(String quick_link) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quick_link),
				"Quick link " + quick_link + " is not as expected");
	}

	@Then("^I see quick links of \"([^\"]*)\" and \"([^\"]*)\" in the section$")
	public void i_see_quick_links_of_and_in_the_section(String quick_link1, String quick_link2) throws Throwable {
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quick_link1),
				"Quick link " + quick_link1 + " is not as expected");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, quick_link2),
				"Quick link " + quick_link2 + "  is not as expected");
	}

	@Then("^I see texts as \"([^\"]*)\" and \"([^\"]*)\" below the above phone number$")
	public void i_see_texts_as_and_below_the_above_phone_number(String text1, String text2) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, text1),
				"Text for " + text1 + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, text2),
				"Text for " + text2 + " is not as expected.");
	}

	@Then("^I see texts as \"([^\"]*)\" and \"([^\"]*)\" below the fax number$")
	public void i_see_texts_as_and_below_the_fax_number(String text1, String text2) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, text1),
				"Text for " + text1 + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, text2),
				"Text for " + text2 + " is not as expected.");
	}

	@When("^the question is submitted  I get a confirmation with a header as \"([^\"]*)\" and message as \"([^\"]*)\"$")
	public void the_question_is_submitted_I_get_a_confirmation_with_a_header_as_and_message_as(String header,
			String message) throws Throwable {

		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, header),
				"Text for " + header + " is not as expected.");
		Assert.assertTrue(context.verifyTextForFlyoutElement(flyout_name, message),
				"Text for " + message + " is not as expected.");

	}

	@When("I click on Message Center Link from flyout")
	public void i_click_on_message_center_link_from_flyout() {
		Assert.assertTrue(context.clickElementForFlyouts(flyout_name, "Message_Center_Link_Text"));

	}

}
