package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.pageObjects.TourPage;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Tour_Steps extends TestUtil {
	private PageBucket pageBucket;

	public Tour_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@When("^I click on \"([^\"]*)\" Button for Tour$")
	public void i_click_on_start_button_for_tour(String label) throws Throwable {
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.tourPage.Start));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" All Sessions Tour Page$")
	public void i_should_see_all_sessions_tour_page(String label) throws Throwable {
		Assert.assertTrue("Element not found", TourPage.isElementPresent(pageBucket.tourPage.All_Sessions));
		System.out.println(pageBucket.tourPage.All_Sessions.getText().toString());
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I click on \"([^\"]*)\" in the screen$")
	public void i_click_on_anywhere_in_the_screen(String buttonLabel) throws Throwable {
		Assert.assertTrue("Unable to click on " + buttonLabel + " button",
				clickButtonByLabel(buttonLabel, "single", 1));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see Sessions Tour Tab$")
	public void i_should_see_Sessions_Tour_Tab() throws Throwable {
		Assert.assertTrue("Element not found", TourPage.isElementPresent(pageBucket.tourPage.Sessions_Tab));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Past Sessions for Tour$")
	public void i_should_see_past_Sessions_for_tour(String label) throws Throwable {
		Assert.assertTrue("Element not found", TourPage.isElementPresent(pageBucket.tourPage.Past_Sessions));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Recent Sessions for Tour$")
	public void i_should_see_recent_Sessions_for_tour(String label) throws Throwable {
		Assert.assertTrue("Element not found", TourPage.isElementPresent(pageBucket.tourPage.Recent_Sessions));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@And("^I click on \"([^\"]*)\" Start Session for Tour$")
	public void i_click_on_Start_Session_for_Tour(String label) throws Throwable {
		Assert.assertTrue("Unable to click on " + label + " button", clickButtonByLabel(label, "single", 1));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" End Session for Tour$")
	public void i_should_see_End_Session_for_Tour(String label) throws Throwable {
		Assert.assertTrue("Element" + label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.End_Session_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I click on \"([^\"]*)\" End Session for Tour$")
	public void i_click_on_End_Session_for_Tour(String label) throws Throwable {
		/*Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.tourPage.End_Session_button));*/
		pageBucket.tourPage.End_Session_button.click();
		pause(2000);
		/*
		 * Assert.assertTrue("Unable to click on " + label + " button",
		 * clickButtonByLabel(label, "single", 1));
		 */

		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Start Time and \"([^\"]*)\" End Time for Tour$")
	public void i_should_see_start_time_and_end_time_for_tour(String StartTime_label, String EndTime_label)
			throws Throwable {
		Assert.assertTrue("Element" + StartTime_label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.Start_Time_label));
		Assert.assertTrue("Element" + EndTime_label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.End_Time_label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Hourly Rate for Tour$")
	public void i_should_see_hourly_rate_for_tour(String HourlyRate_label) throws Throwable {
		Assert.assertTrue("Element" + HourlyRate_label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.Hourly_Rate_label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Total Cost for Tour$")
	public void i_should_see_total_cost_for_tour(String TotalCost_label) throws Throwable {
		Assert.assertTrue("Element" + TotalCost_label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.Total_Cost_label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Services for Tour$")
	public void i_should_see_services_provided_for_tour(String Services_label) throws Throwable {
		Assert.assertTrue("Element" + Services_label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.Services_label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Submit Session for Tour$")
	public void i_should_see_Submit_Session_for_Tour(String label) throws Throwable {
		Assert.assertTrue("Element" + label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.Submit_Session_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I click on \"([^\"]*)\" Submit Session for Tour$")
	public void i_click_on_Submit_Session_for_Tour(String label) throws Throwable {
		/*Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.tourPage.Submit_Session_button));
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.tourPage.submit_button));
		Thread.sleep(30000);*/
		pageBucket.tourPage.Submit_Session_button.click();
		//Assert.assertTrue("Unable to click on " + label + " button", clickButtonByLabel(label, "single", 1));
		pause (3000);
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" Profile Setup page after Tour$")
	public void i_should_see_Profile_setup_page_after_Tour(String label) throws Throwable {
		Assert.assertTrue("Element" + label + "not found",
				TourPage.isElementPresent(pageBucket.tourPage.SetUpProfile_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
}
