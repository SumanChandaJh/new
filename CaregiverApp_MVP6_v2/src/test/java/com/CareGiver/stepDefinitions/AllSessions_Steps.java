package com.CareGiver.stepDefinitions;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.config.JsonUtil;
import com.CareGiver.domains.DomainSetup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import junit.framework.Assert;

public class AllSessions_Steps extends TestUtil {

	
	private PageBucket pageBucket;
	private DomainSetup domain;
	JsonUtil json = new JsonUtil();

	public AllSessions_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Then("^I should see \"([^\"]*)\" All Sessions page$")
	public void i_should_see_All_Session_page(String pageTitle) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(pageTitle + " page Not found", clickButtonByLabel(pageTitle, Base.singletap, 1));
	}

	@Then("^I should see the \"([^\"]*)\" add sign in the header$")
	public void i_should_see_add_sign_in_page_header(String addSignText) throws Throwable {
		Assert.assertTrue(addSignText + " sign Not found", findObjectByPerfecto(addSignText, "1"));
	}

	@Given("^I have atleast one session$")
	public void i_have_atleast_one_session() throws Throwable {
		// set Session object
		domain.setSessions(pageBucket.allSessionsPage.parseSessionText());
		json.createSessionJsonOutput(domain.getSessions());
	}

	@And("^I should see Check In Date as header in \"([^\"]*)\" format$")
	public void i_should_see_checkin_date(String dateFormat) throws Throwable {
		Assert.assertTrue(dateFormat + " date format matching failed",
				pageBucket.allSessionsPage.verifyCheckInDate(dateFormat, domain.getSessions()));
	}

	@And("^I should see Check In Time and Check Out Time in \"([^\"]*)\" format$")
	public void i_should_see_checkin_checkout_time(String format) throws Throwable {
		Assert.assertTrue("Start & End Date verification Failed", pageBucket.allSessionsPage.verifyStartEndTime(format, domain.getSessions()));
	}

	@And("^I should see Total Charges with \"([^\"]*)\" sign$")
	public void i_should_see_totalcharges(String dollar) throws Throwable {
		Assert.assertTrue(dollar+" sign Not found in 'Total Charges'", pageBucket.allSessionsPage.verifyTotalCharges(dollar, domain.getSessions()));
	}
	
	@Then("^I should see the message \"([^\"]*)\"$")
	public void i_should_see_no_sessions_message(String msg) throws Throwable {
		pause(1000);
		Assert.assertTrue(msg + " text not matched", pageBucket.allSessionsPage.verifyNoSessionsMessage(msg));
	}

}
