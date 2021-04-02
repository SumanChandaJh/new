package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.DomainSetup;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class ProviderPortalLogin_Steps extends TestUtil {

	private PageBucket pageBucket;
	private DomainSetup domain;

	public ProviderPortalLogin_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Then("^I should see \"([^\"]*)\" ISAM login page$")
	public void i_should_see_ISAM_login_page(String pageTitle) throws Throwable {
		pause(2000);
		Assert.assertTrue(pageTitle + " page title not matched",
				pageBucket.providerPortalLogin.isPageTitleMatched(pageTitle));
		Util.takeSnapshot(Base.appDriver, currentScenario);

	}

	@When("^I enter username in textbox$")
	public void i_enter_username() throws Throwable {
		Assert.assertTrue("Unable to enter value", pageBucket.providerPortalLogin.setTextBox(
				pageBucket.providerPortalLogin.getTextBoxElement("Username"), domain.getProvider().getUsername()));
		Util.takeSnapshot(Base.appDriver, currentScenario);

	}

	@When("^I enter password in textbox$")
	public void i_enter_password() throws Throwable {
		Assert.assertTrue("Unable to enter value", pageBucket.providerPortalLogin.setTextBox(
				pageBucket.providerPortalLogin.getTextBoxElement("Password"), domain.getProvider().getPassword()));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I tap on \"([^\"]*)\" button to Login$")
	public void i_tap_on_button_to_Login(String buttonLabel) throws Throwable {
		pause(3000);
		Assert.assertTrue("Unable to tap the button", pageBucket.providerPortalLogin.clickLoginButton(buttonLabel));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}
}
