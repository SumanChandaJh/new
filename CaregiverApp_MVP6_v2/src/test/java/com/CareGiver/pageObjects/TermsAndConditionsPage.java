package com.CareGiver.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;

public class TermsAndConditionsPage extends Base {

	@FindBy(xpath = ".//*[@resource-id=\"com.android.packageinstaller:id/permission_message\"]")
	public WebElement LocationAccess_Modal_android;

	@FindBy(xpath = ".//*[@text=\"jh-blue\"]")
	public WebElement JHLogo_android;

	@FindBy(xpath = ".//*[@text=\"jh-blue\"]")
	public WebElement JHLogo_ios;

	@FindBy(xpath = ".//*[@resource-id=\"com.android.packageinstaller:id/permission_allow_button\"]")
	public WebElement Location_Access_Allow;

	@FindBy(xpath = ".//*[@resource-id=\"com.android.packageinstaller:id/permission_deny_button\"]")
	public WebElement Location_Access_Deny;


	@FindBy(xpath = "..")
	public WebElement PageTitle_ios;

	@FindBy(xpath = "//*[@text=\"Accept\"]")
	public WebElement TC_Accept_button;

	@FindBy(xpath = "//*[@text=\"Decline\"]")
	public WebElement TC_Deny_button;

	@FindBy(xpath = "//location-checkin/h1")
	public WebElement App_Access_Modal_android;

	@FindBy(xpath = "//*[@class=\"mat-dialog-actions\"]/button[1]")
	public WebElement App_Access_Not_Now;

	@FindBy(xpath = "//*[@text='John Hancock Long Term Care Provider Mobile Application Terms and Conditions of Use']")
	public WebElement PageTitle_android;

	@SuppressWarnings("static-access")
	public TermsAndConditionsPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);

	}

	public boolean isLocationAccessModalPresent(String modal) {
		boolean present = false;
		if (!isIOS()) {
			present = TestUtil.findObjectByPerfecto(modal, "1");
		}

		return present;
	}

	public boolean isJHLogoPresent() {
		if (!isIOS()) {
			return TestUtil.waitForAppElement(JHLogo_android);
		} else {
			return TestUtil.waitForAppElement(JHLogo_ios);
		}
	}

	public WebElement getPageTitleElement() {
		if (isIOS()) {
			return PageTitle_ios;
		} else {
			return PageTitle_android;
		}
	}

	// Accept & Deny button in Terms and Conditions page
	public WebElement getTCButton(String buttonName) {
		WebElement button = null;

		if (buttonName.contains("Accept")) {
			button = TC_Accept_button;
		} else if (buttonName.contains("Decline")) {
			button = TC_Deny_button;
		}

		return button;
	}

	// Location access button "ALLOW/DENY"
	public WebElement getLocationAccessMWButton(String buttonName) {
		WebElement button = null;

		if (buttonName.contains("ALLOW")) {
			button = Location_Access_Allow;
		} else if (buttonName.contains("DENY")) {
			button = Location_Access_Deny;
		}

		return button;
	}
	public void clickButton(String label) {
		if (isIOS()) {
			// return TestUtil.clickButton(Login_Button_ios);
			// return TestUtil.clickButtonByAction(Login_Button_ios);
			// return TestUtil.clickButtonByLabel("ICP Login", singletap, 1);
			App_Access_Not_Now.click();

		} else {
			// hide the keyboard by clicking on non-editable webelement
			Base.appDriver.context("WEBVIEW");
			//appDriver.context("NATIVE_APP");
			//getPageTitleElement().click();
			System.out.println("Inside Click Not Now functionality");
			TestUtil.pause(2000);
			App_Access_Not_Now.click();

		}
	}
	
	
}
