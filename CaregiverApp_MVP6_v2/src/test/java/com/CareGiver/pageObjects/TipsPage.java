package com.CareGiver.pageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TipsPage extends Base {

	@SuppressWarnings("static-access")
	public TipsPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(new AppiumFieldDecorator(appDriver, Base.IMPLICIT_WAIT, TimeUnit.SECONDS), this);
    }
	

}
