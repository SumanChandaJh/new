package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;

import io.appium.java_client.AppiumDriver;

public class HourlyRateSubmissionAcknowledgementPage extends Base {
	
	@FindBy(xpath="//*[contains(text(),'Submit a Past Care Session')]")
	public WebElement hrsap_text1;
	
	@FindBy(xpath="//*[contains(text(),'Yes, Submit a past care session now')]")
	public WebElement hrsap_submit_btn;
	
	@FindBy(xpath="//*[contains(text(),'Return to the home screen')]")
	public WebElement hrsap_homescreen_btn;
	
	@SuppressWarnings("static-access")
	public HourlyRateSubmissionAcknowledgementPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}
	
	public boolean text1_Validation(){
		if(hrsap_text1.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public ManageSessions click_On_Submit(){
		hrsap_submit_btn.click();
		return new ManageSessions(appDriver);
	}
	
	public HomeScreenPage click_On_Homescreen(){
		hrsap_homescreen_btn.click();
		return new HomeScreenPage(appDriver);
	}
}
