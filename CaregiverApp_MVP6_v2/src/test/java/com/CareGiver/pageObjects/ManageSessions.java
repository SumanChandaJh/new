package com.CareGiver.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.domains.Session;

import io.appium.java_client.AppiumDriver;

public class ManageSessions extends Base {
	
	List<Session> sessions = new ArrayList<Session>();

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value=\"CareGiver\"]//preceding::XCUIElementTypeStaticText")
	public WebElement PageTitle_ios;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@value=\"CareGiver\"]//preceding::XCUIElementTypeStaticText")
	public WebElement PageTitle_android;

	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"add\"]")
	public WebElement AddBtn_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"add\"]")
	public WebElement AddBtn_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"All Sessions\"]//parent::XCUIElementTypeOther/following::XCUIElementTypeOther")
	public WebElement SessionList_ios;

	@FindBy(xpath = "//android.widget.Button[@text=\"arrow back\"]//parent::android.view.View[1]/parent::android.view.View[1]/following::android.view.View//android.view.View[2]/android.view.View[2]")
	public WebElement SessionList_android;

	@FindBy(xpath = "//android.widget.Button[@text=\"arrow back\"]//parent::android.view.View[1]/parent::android.view.View[1]/following::android.view.View//android.view.View[2]/android.view.View[contains(@text,\"No sessions\")]")
	public WebElement NoSession_android;

	@FindBy(xpath = "No done")
	public WebElement NoSession_ios;
	
	
	@SuppressWarnings("static-access")
	public ManageSessions(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		PageFactory.initElements(Base.appDriver, this);

	}

	public List<WebElement> getSessionElementList() {
		Base.appDriver.context("NATIVE_APP");
		if (isIOS())
			return SessionList_ios
					.findElements(By.xpath("//XCUIElementTypeButton[contains(@label,\"arrow forward\")]"));
		else
			return SessionList_android
					.findElements(By.xpath("//android.widget.Button[contains(@text,\"arrow forward\")]"));
	}

}
