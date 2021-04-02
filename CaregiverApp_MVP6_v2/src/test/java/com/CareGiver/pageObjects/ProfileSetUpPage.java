package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;

import io.appium.java_client.AppiumDriver;

public class ProfileSetUpPage extends Base {
	
	@FindBy(xpath="//jh-setup-intro//ion-navbar//div//ion-title")
	public WebElement profile_setup_page_logo;
	
	@FindBy(xpath="//*[contains(text(),'Ready to start?')]")
	public WebElement profile_setup_page_text;
	
	@FindBy(xpath="//ion-content//button")
	public WebElement profile_setup_page_btn;
	
	@SuppressWarnings("static-access")
	public ProfileSetUpPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}
	
	public boolean logo_Verification(){
		if (profile_setup_page_logo.isDisplayed()){
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean text_Verification(){
		if(profile_setup_page_text.isDisplayed()){
			return true;
		}
		else{
			return false;
		}
	}
	
	public HourlyRatePage clickOnProfileSetUp(){
		profile_setup_page_btn.click();
		return new HourlyRatePage(appDriver);
	}
	
}
