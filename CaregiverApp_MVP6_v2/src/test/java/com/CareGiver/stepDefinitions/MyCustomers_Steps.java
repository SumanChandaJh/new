package com.CareGiver.stepDefinitions;

import org.junit.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.DomainSetup;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyCustomers_Steps extends TestUtil {

	private PageBucket pageBucket;
	private DomainSetup domain;

	public MyCustomers_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Then("^I should see \"([^\"]*)\" My Customers page$")
	public void i_should_see_My_Customers_page(String pageTitle) throws Throwable {
		if (domain.getHasMultipleCustomerFlag())
			Assert.assertTrue("My Customer page not found", objectCheckpointByText(pageTitle, "2"));

	}

	@When("^I click \"([^\"]*)\" menu button$")
	public void i_click_menu_button(String label) throws Throwable {
		// System.err.println(label);
		Assert.assertTrue("Main menu button not clicked", pageBucket.customerBeginSessionPage.clickMenuBtn());
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I click on the Customer Card \"([^\"]*)\"$")
	public void i_click_the_Customer_Card(String customerName) throws Throwable {
		domain.setCustomerByCustomerName(customerName);
		Assert.assertTrue("Unable to Click on Customer Card", clickButtonByLabel(customerName, Base.singletap, 1));

	}
}
