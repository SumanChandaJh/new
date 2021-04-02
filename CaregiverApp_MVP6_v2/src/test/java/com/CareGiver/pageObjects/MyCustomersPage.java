package com.CareGiver.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MyCustomersPage extends Base {

	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"menu\"]")
	public WebElement menu_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"menu\"]")
	public WebElement menu_android;

	@SuppressWarnings("static-access")
	public MyCustomersPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(new AppiumFieldDecorator(appDriver, Base.IMPLICIT_WAIT, TimeUnit.SECONDS), this);
	}

}
