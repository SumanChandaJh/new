package com.CareGiver.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.CareGiver.Base.TestUtil;
import com.CareGiver.Base.WebVar;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.Customer;
import com.CareGiver.domains.Provider;
import com.CareGiver.domains.User;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import junit.framework.Assert;

public class CommonBackOffice_Steps extends TestUtil {

	private PageBucket pageBucket;

	public CommonBackOffice_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@When("^I navigate to the Salesforce Backoffice$")
	public void i_navigate_to_the_Salesforce_Backoffice_in_environment(List<User> users) throws Throwable {
		System.err.println("Table Row Count:" + users.size());
		pageBucket.setUser(users);

	}

	@When("^I log in to the SFDC application as a \"([^\"]*)\"$")
	public void i_log_in_to_the_SFDC_application_as_a(String expectedUserRole) throws Throwable {
		String envURL = pageBucket.user.getUrl();
		System.out.println(envURL);

	}

	@Then("^the Salesforce Homepage should be displayed in \"([^\"]*)\"$")
	public void the_Salesforce_Homepage_should_be_displayed_in(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^I click on \"([^\"]*)\" section in SFDC Backoffice$")
	public void i_click_on_section_in_SFDC_Backoffice(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^I select \"([^\"]*)\" from the All Items subsection$")
	public void i_select_from_the_All_Items_subsection(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the \"([^\"]*)\" page should be displayed$")
	public void the_page_should_be_displayed(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("^I select the \"([^\"]*)\" value$")
	public void i_select_the_value(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I should see \"([^\"]*)\" table$")
	public void i_should_see_table(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I sort the \"([^\"]*)\"  table in \"([^\"]*)\" order$")
	public void i_sort_the_table_in_order(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^I select the first value from the \"([^\"]*)\" table$")
	public void i_select_the_first_value_from_the_table(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the value of the field$")
	public void the_value_of_the_field() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^the browser should be closed$")
	public void the_browser_should_be_closed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

	}

}