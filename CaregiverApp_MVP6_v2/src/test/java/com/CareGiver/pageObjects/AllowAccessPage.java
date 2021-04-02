package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;


import io.appium.java_client.AppiumDriver;

public class AllowAccessPage extends Base  {

	
	@FindBy(xpath = "//*[@id=\"header\"]")
	public WebElement AllowAccess_PageTitle_android;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@value=\"CareGiver\"]//preceding::XCUIElementTypeStaticText")
	public WebElement AllowAccess_PageTitle_ios;

	public AllowAccessPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);

	}
	
	public boolean isPageTitlePresent() {
		
		if(isIOS()) {
			return TestUtil.waitForAppElement(AllowAccess_PageTitle_ios);
		} else {
			return TestUtil.waitForAppElement(AllowAccess_PageTitle_android);
		}
	}
	
	public boolean isPageTitleMatched(String pageTitle) {
		boolean matched = false;
		
		if(isIOS()) {
			//System.err.println(AllowAccess_PageTitle_ios.getText().trim());
			matched = TestUtil.objectCheckpointByText(pageTitle, "2");
		} else {
			Base.appDriver.context("WEBVIEW");
			matched = pageTitle.equalsIgnoreCase(AllowAccess_PageTitle_android.getText().trim());
		}
		
		return matched;
	}
	
	
	public boolean isAllowBtnPresent(String pageText) {
		boolean buttonPresent = false;
		
		if(isIOS()) {
			buttonPresent = TestUtil.objectCheckpointByText(pageText, "1");
		} else {
			buttonPresent = TestUtil.objectCheckpointByText(pageText, "1");
		}
		
		return buttonPresent;
	}
}
