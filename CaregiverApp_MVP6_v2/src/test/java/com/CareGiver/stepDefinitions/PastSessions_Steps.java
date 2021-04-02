package com.CareGiver.stepDefinitions;



import java.util.List;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.pageObjects.PastSessionPage;
import com.CareGiver.pageObjects.TourPage;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import junit.framework.Assert;

public class PastSessions_Steps extends TestUtil {
	
	private PageBucket pageBucket;

	public PastSessions_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}
	@When("^I click on \"([^\"]*)\" Skip button$")
	public void i_click_on_skip_button(String label) throws Throwable {
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.Skip_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	
	
	@When("^I click on \"([^\"]*)\" Profile Setup page$")
	public void i_click_on_profile_setup_page(String label) throws Throwable {
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.SetUpProfile_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	
	@Then("^I should be able to set \"([^\"]*)\" Hourly Rate$")
	public void i_should_be_able_to_set_Hourly_Rate(String label) throws Throwable {
		/*Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.SetUpProfile_button));*/
		pageBucket.pastSessionPage.HourlyRate.click();
		pause(3000);
		//pageBucket.pastSessionPage.HourlyRate.sendKeys("200");
		PastSessionPage.setTextboxViaAppDriver(pageBucket.pastSessionPage.HourlyRate, "200");
		pause(3000);
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	@When("^I click on \"([^\"]*)\" Next button$")
	public void i_click_on_next_button(String label) throws Throwable {
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.Next_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	
	@And("I click on \"([^\"]*)\" Submit Past Session")
	public void i_click_on_submit_past_session(String label) throws Throwable{
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.Submit_Past_Session_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
		
	}
	@When("^I click on Start Date and enter \"([^\"]*)\" time$")
	public void i_click_on_start_time_and_enter_time(String label, DataTable dt) throws Throwable {
		List<List<String>> table = dt.raw();
		String Time = table.get(1).get(1);
		System.out.println("The time is " + Time + "hour");
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.Start_Time_input));
		PastSessionPage.setStartTime(Time);
		Util.takeSnapshot(Base.appDriver, currentScenario);
		
	}
	@When("^I enter \"([^\"]*)\" in End Time input$")
	public void i_enter_date_in_end_time_input(String label, DataTable dt) throws Throwable {
		List<List<String>> data = dt.raw();
		String date = data.get(1).get(0);
		
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.End_Time_input));
		System.out.println("The date is ::" + date);
		PastSessionPage.setUserDate(date);
		//pause(5000);
		//PastSessionPage.setEndTime();
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	@Then("^I validate the \"([^\"]*)\" for future date$")
	public void i_validate_the_error_message_for_future_date(String ErrorMsg) throws Throwable
	{
		Assert.assertTrue("Element" + ErrorMsg + "not found",
				TourPage.isElementPresent(pageBucket.pastSessionPage.Error_Msg_Future_Date));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I validate the Error Messages for future time$")
	public void i_validate_error_messages_for_future_time() throws Throwable
	{
		Assert.assertTrue("Element not found",
				TourPage.isElementPresent(pageBucket.pastSessionPage.Error_MsgOne_Future_Time));
		Assert.assertTrue("Element not found",
				TourPage.isElementPresent(pageBucket.pastSessionPage.Error_MsgTwo_Future_Time));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	
	@And("^I click on \"([^\"]*)\" Service$")
	public void i_click_on_service(String label) throws Throwable{
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.bathing));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	@When("^I click on \"([^\"]*)\" submit session button$")
	public void i_click_on_submit_session_button(String label) throws Throwable{
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.Submit_Session_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	@And("^I click on \"([^\"]*)\" Submit popup$")
	public void i_click_on_submit_popup(String label) throws Throwable{
		Assert.assertTrue("Clicking" + label + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.submit_button));
		pause(8000);
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
	@Then("^I click on \"([^\"]*)\" Home Screen button$")
	public void i_click_on_home_screen_button(String Button) throws Throwable{
		
		Assert.assertTrue("Clicking" + Button + "button is not working",
				clickButtonViaWebView(pageBucket.pastSessionPage.HomeScreen_button));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
}
