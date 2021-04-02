package com.CareGiver.stepDefinitions;

import java.util.List;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.Customer;
import com.CareGiver.domains.DomainSetup;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class CustomerBeginSession_Steps extends TestUtil {

	
	private PageBucket pageBucket;
	private DomainSetup domain;

	public CustomerBeginSession_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Then("^I should see \"([^\"]*)\" start session button$")
	public void i_should_see_start_session_button(String btnLabel) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(btnLabel + " is not present",
				pageBucket.customerBeginSessionPage.isBeginSessionBtnPresent(btnLabel));
	}

	@Given("^I have \"([^\\\"]*)\" customer$")
	public void i_have_customers(String customerCount, List<Customer> customers) throws Throwable {
		domain.setCustomers(customers);
		domain.checkAndSetMultipleCustomerFlag();
	}

	@When("^I should see \"([^\"]*)\" button$")
	public void i_should_see_menu_button(String label) throws Throwable {
		Assert.assertTrue("Menu not present", pageBucket.customerBeginSessionPage.isMenuBtnPresent());
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@When("^I tap on \"([^\"]*)\" Begin Session button$")
	public void i_tap_on_Begin_Session_button(String label) throws Throwable {
		Assert.assertTrue("Unable to click " + label + " button",
				pageBucket.customerBeginSessionPage.startSession(label));
		pause(30000);
		domain.getSession().setSessionStarted(true);

	}

	@Then("^I should see \"([^\"]*)\" Customer Screen page$")
	public void i_should_see_Customer_Screen_page(String label) throws Throwable {
		TestUtil.pause(15000);
		Assert.assertTrue(label + " Not Found", pageBucket.customerBeginSessionPage.isBeginSessionBtnPresent(label));
		Util.takeSnapshot(Base.appDriver, currentScenario);
	}

	@And("^I should see Customer Full Name as page title$")
	public void i_should_see_Custmer_Full_Name() throws Throwable {
		System.err.println("Customer Name:"+domain.getCustomer().getFullName());
		Assert.assertTrue("Customer Name Not found",
				pageBucket.customerBeginSessionPage.isCustomerNameFound(domain.getCustomer().getFullName()));
	}

	@And("^I should see \"([^\"]*)\" button with \"([^\"]*)\" right alinged arrow$")
	public void i_should_see_Sessions_Btn(String btnLabel, String arrow) throws Throwable {
		Assert.assertTrue(btnLabel+" verification failed", pageBucket.customerBeginSessionPage.veriifySessionsBtn(btnLabel, arrow));
	}
	
	@And("^I should see \"([^\"]*)\" button at page bottom$")
	public void i_should_see_Start_Session_Btn(String label) throws Throwable {
		Assert.assertTrue(label + " Not Found", pageBucket.customerBeginSessionPage.isBeginSessionBtnPresent(label));
	}

	@When("^I tap on \"([^\\\"]*)\" All Session button$")
	public void i_click_All_Sessions_card(String label) throws Throwable {
		Assert.assertTrue(label+" Card not present", clickButtonByLabel(label, Base.singletap, 1));
	}
	
	@When("^I tap on \"([^\"]*)\" Manage Session button$")
	public void i_click_Manage_Sessions_card(String label) throws Throwable {
		Assert.assertTrue(label+" Card not present", clickButtonByLabel(label, Base.singletap, 1));
	}
	
	@And("^I skip the tour of the App$")
	public void i_skip_the_tour() throws Throwable {
		pause(3000);
		// waitForAppElement(pageBucket.customerBeginSessionPage.Tour_Skip_button);
		// Assert.assertTrue("Unable to click on " + buttonLabel + " button",
		// clickButtonByLabel(buttonLabel, "single", 1));
		//System.out.println(pageBucket.customerBeginSessionPage.TourPage_Title.getText().toString());

		Assert.assertTrue("Unable to Click button",
				clickButtonViaWebView(pageBucket.customerBeginSessionPage.Tour_Skip_button));

	}

}
