package com.CareGiver.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends Base {

	@SuppressWarnings("static-access")
	public LoginPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(new AppiumFieldDecorator(appDriver, Base.IMPLICIT_WAIT, TimeUnit.SECONDS), this);
	}

	public void cleanAppBasedOnOS(String appName) {
		if (isIOS()) {
			TestUtil.cleanIOSApplication(remoteDriver);
			TestUtil.closeApp(appName);
		} else
			TestUtil.cleanApplication(appName);
	}

}
