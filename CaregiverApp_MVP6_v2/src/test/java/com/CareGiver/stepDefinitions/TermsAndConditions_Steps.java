package com.CareGiver.stepDefinitions;

import org.junit.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TermsAndConditions_Steps extends TestUtil {

	private PageBucket pageBucket;

	public TermsAndConditions_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see \"([^\"]*)\" Terms and Conditions page$")
	public void i_should_see_Terms_and_Conditions_page(String pageTitle) throws Throwable {
		if (!Base.isIOS()) {
			waitForAppElement(pageBucket.termsAndConditionsPage.PageTitle_android);
			Assert.assertTrue(pageTitle + " page Not found", objectCheckpointByText(pageTitle, "1"));
		} else {
			pageBucket.skipAtIOS();
		}
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@Then("^I should see \"([^\"]*)\" modal window$")
	public void i_should_see_modal_window(String modalName) throws Throwable {
		if (!Base.isIOS())
			Assert.assertTrue("Expected Modal Not found",
					pageBucket.termsAndConditionsPage.isLocationAccessModalPresent(modalName));
		else
			pageBucket.skipAtIOS();
		Util.takeSnapshot(Base.appDriver, currentScenario);

	}

	

	@When("^I tap on \"([^\"]*)\" button in location access modal$")
	public void i_tap_on_button_in_location_access_modal(String response) throws Throwable {
		if (!Base.isIOS())
			Assert.assertTrue("Clicking " + response + " button is not working",
					clickButton(pageBucket.termsAndConditionsPage.getLocationAccessMWButton(response)));
		else
			pageBucket.skipAtIOS();

		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I tap on \"([^\"]*)\" Accept button$")
	public void i_tap_on_Accept_button(String buttonLabel) throws Throwable {

		if (!Base.isIOS()) {
			Assert.assertTrue("Clicking " + buttonLabel + " button is not working",
					clickButton(pageBucket.termsAndConditionsPage.getTCButton(buttonLabel)));
			// wait for 7 secs
			pause(7000);
		} else {
			pageBucket.skipAtIOS();
		}
		Util.takeSnapshot(Base.appDriver, currentScenario);

	}
	@When("^I tap on Not Now Location Chekin modal window$")
	public void i_tap_on_not_now_location_chekin_modal_window() throws Throwable {
		Assert.assertTrue("Clicking Not Now button is not working",
				clickButtonViaWebView(pageBucket.termsAndConditionsPage.App_Access_Not_Now));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
}
