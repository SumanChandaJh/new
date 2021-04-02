package com.CareGiver.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class CustomerBeginSessionPage extends Base {
	
	
	
	@FindBy(xpath = ".//*[@resource-id=\"com.android.packageinstaller:id/permission_message\"]")
	public WebElement PageTitle_ios;

	@FindBy(xpath = ".//*[@text=\"Check In\"]")
	public WebElement PageTitle_android;
	
	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"menu\"]")
	public WebElement menu_ios;
	
	@FindBy(xpath = "//android.widget.Button[@text=\"menu\"]")
	public WebElement menu_android;
	
	@FindBy(xpath = ".//*[@text=\"Start Session\"]")
	public WebElement BeginSession_android;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Start Session\"]")
	public WebElement BeginSession_ios;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[contains(@label,\"Manage Sessions\")]")
	public WebElement Manage_Session_Btn_ios;
	
	@FindBy(xpath = ".//android.widget.Button[contains(@text,\"Manage Sessions\")]")
	public WebElement Manage_Session_Btn_android;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[contains(@label,\"All Sessions\")]")
	public WebElement All_Session_Btn_ios;
	
	@FindBy(xpath = ".//android.widget.Button[contains(@text,\"All Sessions\")]")
	public WebElement All_Session_Btn_android;
	
	@FindBy(xpath=".//XCUIElementTypeButton[@label=\\\"End Session\\\"]")
	public WebElement EndSession_ios;
	
	@FindBy(xpath=".//*[@text=\"Submit\"]")
	public WebElement SubmitSessionFinal_android;
	
	@FindBy(xpath=".//*[@label=\\\"Submit\\\"]")
	public WebElement SubmitSessionFinal_ios;
	
	@FindBy(xpath = ".//*[@label=\\\"Submit\\\"]")
	public WebElement AllCustomer_Title;

	@FindBy(xpath = "//ion-app//jh-tutorial//h1")
	public WebElement TourPage_Title;

	@FindBy(xpath = "//*[contains(text(),'Skip')]") /* //ion-app//jh-tutorial/button/span  */
	public WebElement Tour_Skip_button;
	
	@SuppressWarnings("static-access")
	public CustomerBeginSessionPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	
	}
	
public boolean endSession(String label) {
		
		//System.err.println("End Session");
		if(isIOS()) return TestUtil.clickButton(EndSession_ios);
		else 
			return TestUtil.clickButtonByLabel(label, Base.singletap, 1);
		
		
	}

public boolean clickSubmitButton()
{
	if(isIOS())
	{
		return TestUtil.clickButton(SubmitSessionFinal_ios);
	}
	else {
		return TestUtil.clickButton(SubmitSessionFinal_android);
		
	}
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
	

	public boolean isMenuBtnPresent() {
		
		if(isIOS()) return TestUtil.waitForAppElement(menu_ios);
		else return TestUtil.waitForAppElement(menu_android);
	}
	
	public boolean clickMenuBtn() {
		if(isIOS()) return TestUtil.clickButton(menu_ios);
		else return TestUtil.clickButton(menu_android);
	}
	
	
	public boolean isBtnPresent(String buttonLabel) {
		boolean present = false;
		
		if(isIOS()) {
			present = TestUtil.findObjectByPerfecto(buttonLabel, "1");
		}
		
		return present;
	}
	
	public boolean isCustomerNameFound(String customerName) {
		return TestUtil.findObjectByPerfecto(customerName, "1");
		
	}
	
	public boolean veriifySessionsBtn(String btnLabel, String arrow) {
		boolean status = false;
		WebElement obj = null;
		
		if(btnLabel.contains("All")) {
			if(isIOS()) obj = All_Session_Btn_ios;
			else obj = All_Session_Btn_android;

		} else if(btnLabel.contains("Manage")) {
			if(isIOS()) obj = Manage_Session_Btn_ios;
			else obj = Manage_Session_Btn_android;
		} 
		
		if(obj != null) {
			if(obj.getText().trim().contains(btnLabel)) {
				if(isArrowPresent(obj.getText(), arrow)) {
					status = true;
				}
			}
		}
		
		return status;
	}
	

	
	public boolean isArrowPresent(String btnText, String arrow) {
		if(btnText.contains(arrow)) return true;
		else return false;
	}
	
	
	
}
