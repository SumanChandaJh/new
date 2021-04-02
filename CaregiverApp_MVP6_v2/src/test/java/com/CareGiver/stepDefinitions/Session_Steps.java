package com.CareGiver.stepDefinitions;



import java.util.List;

import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.domains.DomainSetup;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Session_Steps extends TestUtil {

	private PageBucket pageBucket;
	CommonUtil commonUtil = new CommonUtil();
	private DomainSetup domain;

	public Session_Steps(PageBucket pageBucket, DomainSetup domain) {
		this.pageBucket = pageBucket;
		this.domain = domain;
	}

	@Then("^I should see \"([^\"]*)\" Add Session page$")
	public void i_should_see_add_session_page_label(String pageTitle) throws Throwable {
		Assert.assertEquals(pageTitle, pageBucket.sessionPage.getPageTitle());
	}

	// Label comparison
	@And("^I tap on \"([^\"]*)\" add button$")
	public void i_tap_on_add_button(String btnLabel) throws Throwable {
		Assert.assertTrue("Unable to Click '" + btnLabel + "'",
				clickButton(pageBucket.allSessionsPage.getAddSessionBtn()));
	}
	
	//I should see default "Start Time" in "M/d/yy, h:mm a" format
	@And("I should see default \"([^\"]*)\" in \"([^\"]*)\" format")
	public void i_should_see_current_datetime(String startTimeLabel, String dateTimeFormat)
			throws Throwable {
		Assert.assertTrue("Start Time verification failed",
				pageBucket.sessionPage.verifyTime(startTimeLabel, dateTimeFormat));
		
		// Setting Session object
		pageBucket.sessionPage.parseDateTime(startTimeLabel, CommonUtil.getDateTimeFormat(dateTimeFormat), domain.getSession());
	}
	

	@And("I should see default \"([^\"]*)\" value should be \"([^\"]*)\" and in \"([^\"]*)\" format")
	public void i_should_see_rounded_off_times(String startTimeLabel, String roundOffProc, String startTimeFormat)
			throws Throwable {
		Assert.assertTrue("Start Time verification failed",
				pageBucket.sessionPage.verifyTime(startTimeLabel, startTimeFormat, roundOffProc));
	}
	
	//I should see my default Hourly Rate
	@And("^I should see my default Hourly Rate$")
	public void i_should_see_default_hourly_rate()
			throws Throwable {
		Assert.assertTrue("Total Charges is Empty", !pageBucket.sessionPage.fetchHourlyRate().isEmpty());
		domain.getSession().setHourlyRate(pageBucket.sessionPage.fetchHourlyRate());
	}
	
	//I should see Total Charges amount
	@And("^I should see Total Charges amount$")
	public void i_should_see_total_charges_amount()
			throws Throwable {
		Assert.assertEquals(pageBucket.sessionPage.deriveTotalCharges(domain.getSession(), "h:mm a"), pageBucket.sessionPage.fetchTotalCharges());
		
		// Setting Hourly Rate
		domain.getSession().setTotalCharges(pageBucket.sessionPage.fetchTotalCharges());
	}

	@And("^I should see ADL_labels:$")
	public void i_should_see_ADL_labels(List<String> ADLs) throws Throwable {
		Assert.assertTrue("ADL Label verification Failed", pageBucket.sessionPage.checkADLLabel(ADLs));
	}

	@When("^I tap \"([^\"]*)\" labelled ADL button$")
	public void i_see_Other_textbox(String textBoxLabel) throws Throwable {
		Assert.assertTrue(textBoxLabel + " Text Box Not Loaded",
				clickButton(pageBucket.sessionPage.getADLBtn(textBoxLabel)));
	}

	@Then("^I should see \"([^\"]*)\" textbox appears$")
	public void i_see_textbox(String textBoxLabel) throws Throwable {
		Assert.assertTrue("Text Box not found", findObjectByPerfecto(textBoxLabel, "1"));
	}

	@And("^I should see green colored \"([^\"]*)\" button$")
	public void i_see_green_button(String buttonLabel) throws Throwable {
		Assert.assertTrue(buttonLabel + " is Not Present", isVisible(pageBucket.sessionPage.getSubmitBtn()));
	}

	@And("^I shouldn't see \"([^\"]*)\" button$")
	public void i_dont_see_btton(String buttonLabel) throws Throwable {
		Assert.assertFalse(buttonLabel + " is visible", findObjectByPerfecto(buttonLabel, "1"));
	}

	@When("^I tap to select below ADL_options:$")
	public void i_tap_on_ADL_btn(List<String> selectADLs) throws Throwable {
		Assert.assertTrue("Unable to Select the ADL list", pageBucket.sessionPage.clickADLBtn(selectADLs));
	}

	@Then("^I should see the toast message \"([^\"]*)\"$")
	public void i_see_toast_msg(String toastMsg) throws Throwable {
		// Assert.assertFalse("Unable to verify the toast message",
		// objectCheckpointByText(toastMsg, "1"));
		Assert.assertTrue("Unable to verify the toast message '" + toastMsg + "'", findObjectByPerfecto(toastMsg, "1"));
	}
	
	
	@When("^I select \"([^\"]*)\" as \"([^\"]*)\" in date time \"([^\"]*)\" format$")
	public void i_select_dateTime(String dateTimeLabel, String inputDate, String dateTimeFormat) throws Throwable {
		//
	
	}
	
	@Then("^I should see \"([^\"]*)\" value in \"([^\"]*)\" format$")
	public void i_see_correct_datetimeformat(String dateTimeLabel, String dateTimeFormat) throws Throwable {
		//
	
	}
	

}
