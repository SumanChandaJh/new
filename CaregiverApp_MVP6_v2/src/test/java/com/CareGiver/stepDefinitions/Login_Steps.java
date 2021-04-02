package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_Steps extends TestUtil {

	private PageBucket pageBucket;

	public Login_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;

	}

	@When("^I open \"([^\"]*)\" app$")
	public void i_open_CareGiver_app(String appName) throws Throwable {
		System.out.println("Start Test....");

		// open CareGiver app
		openApp(appName);
	}

	@When("^I clean and open \"([^\"]*)\" app$")
	public void i_clean_and_open_CareGiver_app(String appName) throws Throwable {
		System.out.println("Start Test....");
		pageBucket.loginPage.cleanAppBasedOnOS(appName);
		// open CareGiver app
		openApp(appName);
	}

	@Then("^I close \"([^\"]*)\" app$")
	public void i_close_CareGiver_app(String appName) throws Throwable {

		System.out.println("Close Test.");

		// close CareGiver app
		closeApp(appName);
	}

}
