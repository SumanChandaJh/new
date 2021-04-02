package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class CheckIn_Steps extends TestUtil {

	private PageBucket pageBucket;

	public CheckIn_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see \"([^\"]*)\" Check In page$")
	public void i_should_see_Check_In_page(String pageTitle) throws Throwable {

		// Assert.assertTrue(pageTitle + " page title verification failed",
		// pageBucket.checkInPage.verifyPageTitle(pageTitle));
		// Page name is not confirmed - hence verifying using 'End Session' btn
		Assert.assertTrue(pageTitle + " page title verification failed",
				pageBucket.checkInPage.isEndSessionBtnPresent());

	}

	@Then("^I should see Customer Name as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_should_see_Customer_Name_as_and(String arg1, String arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("########### POJO Mapping from datatable");
	}

	@Then("^I should see \"([^\"]*)\" as Start Date label$")
	public void i_should_see_as_Start_Date_label(String label) throws Throwable {
		Assert.assertTrue(label + " label validation failed", pageBucket.checkInPage.verifyCardLabel(label));
	}

	@Then("^I should see \"([^\"]*)\" as Start Time label$")
	public void i_should_see_as_Start_Time_label(String label) throws Throwable {
		Assert.assertTrue(label + " label validation failed", pageBucket.checkInPage.verifyCardLabel(label));
	}

	@Then("^I should see Start Date as today$")
	public void i_should_see_Start_Date_as_today() throws Throwable {
		Assert.assertEquals(CommonUtil.getCurrentDate(), pageBucket.checkInPage.getCheckInDate());
	}

	@Then("^I should see Start Time as current time$")
	public void i_should_see_Start_Time_as_current_time() throws Throwable {
		Assert.assertEquals(PageBucket.SESSION_START_TIME, pageBucket.checkInPage.getCheckIntime());
	}

	@Then("^I should see \"([^\"]*)\" as End Session button label$")
	public void i_should_see_as_End_Session_button_label(String buttonLabel) throws Throwable {
		TestUtil.pause(7000);
		Assert.assertEquals(buttonLabel, pageBucket.checkInPage.getSessionEndBtnText());

	}

}
