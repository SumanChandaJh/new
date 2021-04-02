package com.CareGiver.stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import junit.framework.Assert;

public class CheckOut_Steps extends TestUtil {

	private PageBucket pageBucket;

	public CheckOut_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}
	
	@Then("^I should tap on \"([^\"]*)\" button$")
	public void i_should_tap_on_button(String buttonLabel) throws Throwable {
		TestUtil.pause(13000);
		Assert.assertTrue("Unable to click "+buttonLabel+" button", pageBucket.customerBeginSessionPage.endSession(buttonLabel));
		System.out.println(buttonLabel+"-The button has been clicked");
   
	}
	
	@Then("^I should tap on \"([^\"]*)\" to submit the session$")
	public void i_should_tap_on_to_submit_the_session(String optionlabel)throws Throwable{
		Assert.assertTrue("Unable to click "+optionlabel+" button", pageBucket.customerBeginSessionPage.clickSubmitButton());
		TestUtil.pause(20000);
	}
	

	@Then("^I should see \"([^\"]*)\" Page$")
	public void i_should_see_Page(String pageTitle) throws Throwable {
		TestUtil.pause(10000);
		System.err.println("In the page Title verification function");
		Assert.assertTrue(pageTitle + " page title verification failed",
				pageBucket.checkOutPage.isPageTitleVerified(pageTitle));
	}
	@Then("^I should see the following items$")
	public void i_should_see_the_following_items(List<String> labelList) throws Throwable {
		Assert.assertTrue("Items are unexpected", pageBucket.sessionPage.checkItems(labelList, "Items"));

	}
	@And("^I should see \"([^\"]*)\" label present$")
	public void i_should_see_services_label_present(String label) throws Throwable
	{
		Assert.assertTrue ("Label" +label+ "not found", isElementPresent(pageBucket.sessionPage.Services_Provided_Label));
	}
	@And ("^I should see the following list of Services Available$")
	public void i_should_see_the_following_list_of_Services_Available(List<String> labelList) throws Throwable {
		Assert.assertTrue("Items are unexpected", pageBucket.sessionPage.checkItems(labelList, "ServiceItems"));

	}
	
	 @And("^I should select the following ADL$")
	 public void i_should_select_the_following_ADL(DataTable adlTable)
	 {
		 TestUtil.pause(10000);
		 
	 }
	@When ("^I tap to select below service options$")
	public void when_i_tap_to_select_below_service_options(DataTable datavalues) throws Throwable {
		//Assert.assertTrue("Items are unexpected", pageBucket.sessionPage.checkItems(labelList, "ServiceItems"));
		List<List<String>> data = datavalues.raw();
		Assert.assertTrue("Elements not found",pageBucket.sessionPage.checkServiceItems(datavalues, data.size()));
	}
	@When("^I see any session present delete the session$")
	public void I_see_any_session_present_delete_the_session()
	{
		TestUtil.pause(5000);
		Assert.assertTrue("Session has already ended",
				pageBucket.checkOutPage.isEndSessionBtnPresent());
		
	}
	
	
	@Then("^I should see \"([^\"]*)\" field is read only$")
	public void i_should_see_field_is_read_only (String fieldName)  {
		System.out.println("In the function");
		Assert.assertTrue("The field is not readonly",pageBucket.checkOutPage.readOnlyStartTime());
	    
	};

	@Then("^I should see \"([^\"]*)\" field is not read only$")
	public void i_should_see_field_is_not_read_only(String fieldName) {
		Assert.assertTrue("The field is readonly",pageBucket.checkOutPage.readOnlyEndTime());  
	   
	};

	@Then("^I should enter \"([^\"]*)\" into the \"([^\"]*)\" field$")
	public void i_should_enter_into_the_fields(String value, String fieldName)  {
	System.err.println("In the text function");
	 Assert.assertTrue(pageBucket.providerPortalLogin.setTextBox(pageBucket.checkOutPage.returnWebelement(), value));
	
	};
	

	@Then("^I should see the \"([^\"]*)\" error message$")
	public void  i_should_see_the_error_message(String errorIdentifier)  {
		 Assert.assertTrue("Error message mismatch",pageBucket.checkOutPage.errorMessageValidation(errorIdentifier));  
	};
	

	
}