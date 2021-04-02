package com.CareGiver.stepDefinitions;

import org.junit.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllowAccess_Steps extends TestUtil {

	private PageBucket pageBucket;

	public AllowAccess_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see \"([^\"]*)\" Allow Access page$")
	public void i_should_see_Allow_Access_page(String pageTitle) throws Throwable {
		TestUtil.pause(7000);
		Assert.assertTrue("Page Title " + pageTitle + " not found",
				pageBucket.allowAccessPage.isPageTitleMatched(pageTitle));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I tap on \"([^\"]*)\" Allow button$")
	public void i_tap_on_Allow_button(String buttonLabel) throws Throwable {
		Assert.assertTrue("Unable to click on " + buttonLabel + " button",
				clickButtonByLabel(buttonLabel, "single", 2));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
}
