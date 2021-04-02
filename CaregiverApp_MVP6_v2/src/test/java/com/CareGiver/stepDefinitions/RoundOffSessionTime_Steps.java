package com.CareGiver.stepDefinitions;

import org.junit.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RoundOffSessionTime_Steps extends TestUtil {
	
	private PageBucket pageBucket;
	
	public RoundOffSessionTime_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see total charges$")
	public void I_should_see_total_charges() throws Throwable{
		Assert.assertTrue("total charges not matched",pageBucket.checkOutPage.totalChargeVerified());
	}
	
	@And("^I should see all fields are read only$")
	public void i_should_see_all_fields_are_read_only()throws Throwable
	{
		Assert.assertTrue("All the fields are not read only",pageBucket.sessionPage.isReadOnly());
	}
	
	@When("^I tap on first session of All session page$")
	public void i_tap_on_first_session_of_All_session_page()throws Throwable
	{
		Assert.assertTrue("I am not able to tap on the session",pageBucket.sessionPage.isClickable());
	}
}