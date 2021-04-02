package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.config.JsonUtil;

import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class ManageSessions_Steps extends TestUtil {

	private PageBucket pageBucket;
	JsonUtil json = new JsonUtil();

	public ManageSessions_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see \"([^\"]*)\" Manage Sessions page$")
	public void i_should_see_Manage_Session_page(String pageTitle) throws Throwable {
		Assert.assertTrue(pageTitle + " page Not found", clickButtonByLabel(pageTitle, Base.singletap, 1));
	}

}
