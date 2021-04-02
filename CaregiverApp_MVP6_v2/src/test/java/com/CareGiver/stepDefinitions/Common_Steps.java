package com.CareGiver.stepDefinitions;

import java.util.List;
import java.util.Map;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Common_Steps extends TestUtil {

	private PageBucket pageBucket;
	// Base base = new Base();

	public Common_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}

	@When("^I enter below detail in textbox$")
	public void i_enter_below_detail_in_textbox(List<Map<String, String>> rawTable) throws Throwable {
		pageBucket.providerPortalLogin.setTextBox(
				pageBucket.providerPortalLogin.getTextBoxElement(TestUtil.getFieldLabelFromTable(rawTable)), rawTable);
	}

	@Then("^I should see \"([^\"]*)\" page$")
	public void i_should_see_page(String pageTitle) throws Throwable {
		// check page title
		waitForWebElement(pageBucket.providerPortalLogin.getPageTitleElement());
		Assert.assertEquals(pageTitle, pageBucket.providerPortalLogin.getPageTitleElement().getText());
	}

	// Clicking 'back arrow' button
	// Handled for Android / IOS application
	@When("^I tap on \"([^\"]*)\" back button$")
	public void i_tap_on_back_button(String buttonLabel) throws Throwable {
		Assert.assertTrue("Unable to click 'Back' button", pageBucket.common.clickBackBtn(buttonLabel));
	}

	// Section Label verification
	@And("^I should see \"([^\"]*)\" section label$")
	public void i_should_see_section_label(String sectionLabel) throws Throwable {
		Assert.assertTrue(sectionLabel + " Section Label verification failed", findObjectByPerfecto(sectionLabel, "1"));
	}

	// Label comparison
	@And("^I should see \"([^\"]*)\" label$")
	public void i_should_see_label(String label) throws Throwable {
		Assert.assertTrue(label + " Label verification failed", findObjectByPerfecto(label, "1"));
	}

	// Customer Name text 
	@And("^I should see Customer Full Name as \"([^\"]*)\"$")
	public void i_should_see_Customer_Name(String customerName) throws Throwable {
		Assert.assertTrue(customerName + " Not found", findObjectByPerfecto(customerName, "1"));
	}

	// Label comparison
	@When("^I tap on \"([^\"]*)\" button$")
	public void i_tap_on_button(String btnLabel) throws Throwable {
		Assert.assertTrue(" Unable to Click " + btnLabel, clickButtonByLabel(btnLabel, Base.singletap, 1));
	}

	// Edit Text box
	@And("^I enter \"([^\"]*)\" in the \"([^\"]*)\" textbox$")
	public void i_enter_value_in_textEditBox(String fieldLabel, String valueToSet) throws Throwable {
		clickElement(pageBucket.sessionPage.getOtherEditTextBox(fieldLabel));
		Assert.assertTrue("Unable to Set the EditTextBox " + fieldLabel, setEditBoxByLabel(fieldLabel, valueToSet));
		pause(50000);
	}
	


}
