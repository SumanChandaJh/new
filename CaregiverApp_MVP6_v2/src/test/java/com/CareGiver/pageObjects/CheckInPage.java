package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class CheckInPage extends Base {

	@FindBy(xpath = "//android.view.View[@text=\"Check In\"]")
	public WebElement PageTitle_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Check In\"]")
	public WebElement PageTitle_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Start Date\"]")
	public WebElement StartDate_Label_ios;

	@FindBy(xpath = "//android.view.View[contains(@text,\"Start Date\")]")
	public WebElement StartDate_Label_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Start Date\"]//peceding::XCUIElementTypeStaticText")
	public WebElement StartDate_ios;

	@FindBy(xpath = "//android.view.View[contains(@text,\"Start Date\")]")
	public WebElement StartDate_android;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Start Time\"]")
	public WebElement StartTime_Label_ios;

	@FindBy(xpath = "//android.view.View[contains(@text,\"Start Time\")]")
	public WebElement StartTime_Label_android;
	
	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Start Time\"]//peceding::XCUIElementTypeStaticText")
	public WebElement StartTime_ios;

	@FindBy(xpath = "//android.view.View[contains(@text,\"Start Time\")]")
	public WebElement StartTime_android;

	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"End Session\"]")
	public WebElement EndSession_Button_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"End Session\"]")
	public WebElement EndSession_Button_android;

	@SuppressWarnings("static-access")
	public CheckInPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	}
	
	public WebElement getPageTitleElement() {
		WebElement element = null;

		if (isIOS()) element = PageTitle_ios;
		else element = PageTitle_android;
		
		return element;
	}

	public boolean verifyPageTitle(String expected) {
		boolean status = false;

		if (TestUtil.findObjectByPerfecto(expected, "1")) {
			status = true;
		}

		return status;
	}
	
	public boolean isEndSessionBtnPresent() {
		boolean present = false;
		TestUtil.pause(5000);
		
		if(isIOS()) present = TestUtil.waitForAppElement(EndSession_Button_ios);
		else present = TestUtil.waitForAppElement(EndSession_Button_android);
		return present;
	}

	public String getSessionEndBtnText() {
		String btnText = "";

		if (isIOS()) {
			btnText = TestUtil.getElementLabel(EndSession_Button_ios);
		} else {
			btnText = TestUtil.getElementText(EndSession_Button_android);
		}

		return btnText;
	}

	
	public boolean verifyCardLabel(String label) {
		boolean status = false;
		
		if(label.equalsIgnoreCase("Start Date")) {		
			if(isIOS()) {
				status = TestUtil.getElementLabel(StartDate_Label_ios).equalsIgnoreCase(label);
			} else {
				status = TestUtil.findObjectByPerfecto(label, "1");
			}
			return status;
		
		} else if(label.equalsIgnoreCase("Start Time")) {
			if(isIOS()) {
				status = TestUtil.getElementLabel(StartTime_Label_ios).equalsIgnoreCase(label);
			} else {
				status = TestUtil.findObjectByPerfecto(label, "1");
			}
			return status;
		
		} else {
			return false;
		}	
	}
	
	public String getCheckInDate() {
		String date = "";
				
		if(isIOS()) {
			date = TestUtil.getElementLabel(StartDate_ios);
		} else {
			date = TestUtil.getElementText(StartDate_android).split("Start")[0];
		}
		
		return date.trim();
	}
	
	public String getCheckIntime() {
		String time = "";
				
		if(isIOS()) {
			time = TestUtil.getElementLabel(StartTime_ios);
		} else {
			time = TestUtil.getElementText(StartTime_android).split("Start")[0];
		
		}
		
		return time.trim();
	}

}
