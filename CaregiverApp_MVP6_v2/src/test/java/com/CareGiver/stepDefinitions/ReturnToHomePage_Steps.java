package com.CareGiver.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.bucket.PageBucket;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ReturnToHomePage_Steps extends TestUtil {
		
	private PageBucket pageBucket;

	public ReturnToHomePage_Steps(PageBucket pageBucket) {
		this.pageBucket = pageBucket;
	}
	
	@When("^I click on Return To The Home Screen button$")
	public void I_click_on_Return_To_The_Home_Screen_button(){
		
			pageBucket.homescreenpage = pageBucket.hrratesubackpg.click_On_Homescreen();
			Util.takeSnapshot(Base.appDriver,currentScenario);
			TestUtil.pause(2000);
			Util.takeSnapshot(Base.appDriver,currentScenario);
	}
	
	@Then("^I should be on the Home Screen page$")
	public void I_should_be_on_the_Home_Screen (DataTable homepagevalues) {
		Assert.assertTrue(
				TestUtil.isElementPresent(pageBucket.homescreenpage.home_screen_logo),"Unable to check logo");
		TestUtil.pause(2000);
/*		Assert.assertTrue(
				TestUtil.isElementPresent(pageBucket.homescreenpage.home_screen_text),"Unable to verify text");*/
			Assert.assertTrue(
				TestUtil.isElementPresent(pageBucket.homescreenpage.home_screen_text_single_user),"Unable to verify text");
		TestUtil.pause(2000);
		/*Assert.assertTrue(
				pageBucket.homescreenpage.home_Screen_Footer_Validation(homepagevalues),"Unable to see all the items");*/
		for(int i=0; i<3;i++ ){
		//System.out.println("Menu Element is :"+homepagevalues.raw().get(1).get(0).toString());
		WebElement element = pageBucket.homescreenpage.getElement(homepagevalues.raw().get(i).get(0).toString());
		Assert.assertTrue(pageBucket.homescreenpage.matchLabel(element, homepagevalues.raw().get(i).get(0).toString()),"Unable to find element");
		Util.takeSnapshot(Base.appDriver, currentScenario);
		}
	}

	@When("^I click on More option$")
	public void I_click_on_More_option()
	{
		Assert.assertTrue(
				TestUtil.isElementPresent(pageBucket.homescreenpage.home_screen_More_btn),"Unable to click button");
		//pageBucket.homescreenpage.more_Btn_Click_Validation();
	}

	@Then("^I should see all items$") 
	public void I_should_see_all_items (DataTable homepagemorevalues)
	{
		int x = 1;
		//Assert.assertTrue(
				//pageBucket.homescreenpage.home_Screen_Footer_Validation(homepagemorevalues),"Unable to see all the more button items");
		pageBucket.homescreenpage.home_screen_More_btn.click();
		for(int i=0;i<4;i++ ){
			//System.out.println("Menu Element is :"+homepagevalues.raw().get(1).get(0).toString());
			//String value = homepagemorevalues.raw().get(i).get(0).toString();
			WebElement element = pageBucket.homescreenpage.getMoreElement(homepagemorevalues.raw().get(i).get(0).toString(),String.valueOf(x++));
			Assert.assertTrue(pageBucket.homescreenpage.matchLabel(element,homepagemorevalues.raw().get(i).get(0).toString()),"Unable to find element");
			Util.takeSnapshot(Base.appDriver, currentScenario);
			}
		
	}
	
	@Then("^I Log Out$") 
	public void I_Log_Out(){
			//pageBucket.homescreenpage.home_screen_More_Btn.click();
			TestUtil.clickButtonViaWebView(pageBucket.homescreenpage.home_screen_More_Btn);
			TestUtil.clickButtonViaWebView(pageBucket.homescreenpage.log_Out_Btn);
	    	//pageBucket.homescreenpage.log_Out_Btn.click();
	    	//Util.takeSnapshot(Base.appDriver, currentScenario);
	};
	
}
