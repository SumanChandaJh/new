package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class TipsPage_Steps extends TestUtil {

	private PageBucket pageBucket;
	
	public TipsPage_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}
	
	@Then("^I should see \"([^\"]*)\" Tips page$")
	public void i_should_see_Tips_page(String pageTitle) throws Throwable {
		Assert.assertTrue("Tips page is not found", objectCheckpointByText(pageTitle, "1"));
	}
	
	@Then("^I should see Tips Article Title is present$")
	public void i_should_see_Tips_Article_Title_is_present() throws Throwable {
		Assert.assertTrue("Not defined", false);
	}

	@Then("^I should see Tips Article content is present$")
	public void i_should_see_Tips_Article_content_is_present() throws Throwable {
		Assert.assertTrue("Not defined", false);
	}
	
	@Then("^I should see \"([^\"]*)\" back button is present$")
	public void i_should_see_back_button_is_present(String buttonLabel) throws Throwable {
	    Assert.assertTrue("'Back' arrow button is not present", objectCheckpointByText(buttonLabel, "1"));
	}
	
}
