package com.CareGiver.pageObjects;

import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.domains.Customer;

import io.appium.java_client.AppiumDriver;

public class CustomerEndSessionPage extends Base {
	
	@FindBy(xpath = ".//*[@resource-id=\"com.android.packageinstaller:id/permission_message\"]")
	public WebElement PageTitle_ios;

	@FindBy(xpath = ".//*[@text=\"Check In\"]")
	public WebElement PageTitle_android;
	
	@FindBy(xpath = ".//*[@text=\"Start Session\"]")
	public WebElement BeginSession_android;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Start Session\"]")
	public WebElement BeginSession_ios;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Start Session\"]")
	public WebElement Manage_Session_Btn_ios;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Start Session\"]")
	public WebElement Manage_Session_Btn_android;
	
	@SuppressWarnings("static-access")
	public CustomerEndSessionPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	
	}
	
	public WebElement getPageTitleElement() {
		WebElement pageTitle = null;
		if(isIOS()) {
			pageTitle = PageTitle_ios;
		} else {
			pageTitle = PageTitle_android;
		}
		
		return pageTitle;	
	}
	
	public boolean isBeginSessionBtnPresent(String label) {
		boolean present = false;
		
		if(isIOS()) present = TestUtil.findObjectByPerfecto(label, "1");
		else present = TestUtil.waitForAppElement(BeginSession_android);
	
		return present;
	}
	
	public boolean startSession(String label) {
		
		System.err.println("Start Session");
		if(isIOS()) return TestUtil.clickButton(BeginSession_ios);
		else return TestUtil.clickButtonByLabel(label, Base.singletap, 1);
		
	}
	
	/*public Customer createCustomer(Map<String, String> entry) { 
	   // Customer customer = new Customer(entry.get("firstName"), entry.get("lastName"), entry.get("claimStatus")); 
	   // return customer;
	} */

}
