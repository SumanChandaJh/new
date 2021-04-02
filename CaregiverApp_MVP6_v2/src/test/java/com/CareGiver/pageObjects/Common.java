package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class Common extends Base {
	
	@FindBy(xpath = ".//android.widget.Button[@text=\"arrow back\"]")
	public WebElement Back_Btn_android;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"arrow back\"]")
	public WebElement Back_Btn_ios;
	
	@SuppressWarnings("static-access")
	public Common(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	}
	
	public boolean clickBackBtn(String btnLabel) {
		if(isIOS()) return TestUtil.clickButton(Back_Btn_ios);
		else return TestUtil.clickButton(Back_Btn_android);
	}
}
