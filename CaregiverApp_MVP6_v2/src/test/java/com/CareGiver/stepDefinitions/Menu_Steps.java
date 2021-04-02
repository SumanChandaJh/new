package com.CareGiver.stepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Menu_Steps extends TestUtil {

	private PageBucket pageBucket;

	public Menu_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@Then("^I should see app menu$")
	public void i_should_see_app_menu() throws Throwable {
		waitForAppElement(pageBucket.menu.getLogoutBtn());
	}

	@Then("^I should see menu_items:$")
	public void i_should_see_menu_items(List<String> menuItems) throws Throwable {
		Assert.assertTrue("Menu is unexpected", pageBucket.menu.checkMenuItems(menuItems));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I tap on \"([^\"]*)\" Tips from menu$")
	public void i_tap_on_Tips_from_menu(String label) throws Throwable {
		Assert.assertTrue("Unable to  click " + label + " menu item", clickButtonByLabel(label, "single", 1));
	}

	@When("^I tap \"([^\"]*)\" Logout button$")
	public void i_tap_Logout_button(String label) throws Throwable {
		Assert.assertTrue(pageBucket.menu.logout(label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

}
