package com.CareGiver.stepDefinitions;

import java.util.List;

import org.junit.Assert;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.DomainSetup;
import com.CareGiver.domains.Provider;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LaunchPage_Steps extends TestUtil {

	private PageBucket pageBucket;
	private DomainSetup domain;

	public LaunchPage_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Given("^I am registered ICP user$")
	public void i_am_registered_ICP_user(List<Provider> providers) throws Throwable {
		domain.setProvider(providers);
		System.out.println("Full Name : " + domain.getProvider().getFullName());
	}

	@Then("^I should see John Hancock Logo in Launch page$")
	public void i_should_see_John_Hancock_Logo_in_Launch_page() throws Throwable {
		waitForAppElement(pageBucket.launchPage.getJHLogo());
		Assert.assertTrue("John Hancock Logo is not present", pageBucket.launchPage.getJHLogo().isDisplayed());
	}

	@When("^I tap on \"([^\"]*)\" button ICP Portal$")
	public void i_tap_on_ISAM_login_link(String buttonLabel) throws Throwable {
		pause(5000);
		pageBucket.launchPage.ISAMPageLink_android.click();
		/*Assert.assertTrue("Unable to find ICP Portal ISAM Link button", pageBucket.launchPage.isISAMLinkPresent());
		Assert.assertTrue("Unable to tap ICP Portal ISAM Link button",
				clickButton(pageBucket.launchPage.ISAMPageLink_android));*/
		// clickButtonByLabel(buttonLabel, "single", 1));
	}

	/*
	 * @When("^I should see Salesforce BackOffice Login page$") public void
	 * i_see_on_Login_page() throws Throwable { Assert.assertTrue(
	 * "Login page Not Found", pageBucket.launchPage.isLoginPage()); }
	 */

	@When("^I should see \"([^\"]*)\" LogIn button$")
	public void i_should_see_menu_button(String identifier) throws Throwable {
		Assert.assertTrue("Login Button is not present", pageBucket.launchPage.isLoginPage(identifier));
	}

	@When("^I enter my Username in \"([^\"]*)\" textbox$")
	public void i_enter_username(String fieldLabel) throws Throwable {
		Assert.assertTrue("Unable to Set " + fieldLabel,
				setTextbox(pageBucket.launchPage.getTextboxElement(fieldLabel), domain.getProvider().getUsername()));
	}

	@When("^I enter my Password in \"([^\"]*)\" textbox$")
	public void i_enter_password(String fieldLabel) throws Throwable {
		Assert.assertTrue("Unable to Set " + fieldLabel,
				setTextbox(pageBucket.launchPage.getTextboxElement(fieldLabel), domain.getProvider().getPassword()));
	}
}
