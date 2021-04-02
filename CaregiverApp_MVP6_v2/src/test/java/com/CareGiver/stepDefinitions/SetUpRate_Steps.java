package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.supportLibraries.Util;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class SetUpRate_Steps extends TestUtil {

	private PageBucket pageBucket;

	public SetUpRate_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should be on the start page$")
	public void I_should_be_on_the_start_page() {
		//Assert.assertTrue(pageBucket.profilesetuppage.logo_Verification());
		//Assert.assertTrue(pageBucket.profilesetuppage.text_Verification());
		Assert.assertTrue("Unable to check logo",
				TestUtil.isElementPresent(pageBucket.profilesetuppage.profile_setup_page_logo));
		Assert.assertTrue("Unable to verify text",
				TestUtil.isElementPresent(pageBucket.profilesetuppage.profile_setup_page_text));
		//Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I click on the Set Up profile button$")
	public void I_click_on_the_Set_Up_profile_button() {
		Util.takeSnapshot(Base.appDriver, currentScenario);
		pageBucket.hourlyratepage = pageBucket.profilesetuppage.clickOnProfileSetUp();
	}

	@Then("^I would be on the hourly rate page$")
	public void I_would_be_on_the_hourly_rate_page() {
		//Assert.assertTrue(pageBucket.hourlyratepage.text1_Validation());
		Assert.assertTrue("Unable to verify text",
				TestUtil.isElementPresent(pageBucket.hourlyratepage.hourly_rate_page_text1));
		//Assert.assertTrue(pageBucket.hourlyratepage.text2_Validation());
		Assert.assertTrue("Unable to verify text",
				TestUtil.isElementPresent(pageBucket.hourlyratepage.hourly_rate_page_text2));
		//Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I enter the hourly rate and click on next button$")
	public void I_enter_the_hourly_rate_and_click_on_next_button(DataTable hourlyRateValues) {
		Assert.assertTrue("Unable to Enter value in Hourly Rate",
				pageBucket.hourlyratepage.submitHourlyRate(hourlyRateValues.raw().get(0).get(0)));
	}

	@Then("^I reach the acknowledgement page$")
	public void I_reach_the_acknowledgement_page() {
		Assert.assertTrue("Unable to Enter value in Hourly Rate",
				TestUtil.isElementPresent(pageBucket.hrratesubackpg.hrsap_text1));
	}
}
