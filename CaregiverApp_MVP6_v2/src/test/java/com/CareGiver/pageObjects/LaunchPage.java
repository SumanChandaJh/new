package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class LaunchPage extends Base {

	@FindBy(xpath = "//*[@id=\"logo_wrapper\"]//img")
	public WebElement JHLogo_android;

	@FindBy(xpath = "//XCUIElementTypeImage[contains(@label,\"Provider Portal\")]")
	public WebElement JHLogo_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Or log in using\")]")
	public WebElement PageText;

	@FindBy(xpath = "//*[@text=\"Username\"]")
	public WebElement Page;

	// @FindBy(xpath = ".//*[@resource-id=\"idp_section_buttons\"]//*")
	@FindBy(xpath = "//*[@id=\"idp_section_buttons\"]/button/span")
	public WebElement ISAMPageLink_android;

	@FindBy(xpath = "//*[@label=\"prJHLTCProd\"]")
	public WebElement ISAMPageLink_ios;

	@FindBy(xpath = ".//*[@resource-id=\"idp_section_buttons\"]//*")
	public WebElement sf_username_android;

	@FindBy(xpath = "//XCUIElementTypeOther[@label=\"Username\"]//parent::XCUIElementTypeOther//XCUIElementTypeTextField")
	public WebElement sf_username_ios;

	@FindBy(xpath = ".//*[@resource-id=\"idp_section_buttons\"]//*")
	public WebElement sf_password_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Password\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//child:XCUIElementTypeSecureTextField")
	public WebElement sf_password_ios;

	@FindBy(xpath = ".//*[@resource-id=\"idp_section_buttons\"]//*")
	public WebElement sf_login_android;

	@FindBy(xpath = "//XCUIElementTypeButton[@label=\"Log In to Sandbox\"]")
	public WebElement sf_login_ios;

	@SuppressWarnings("static-access")
	public LaunchPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	}

	public WebElement getJHLogo() {
		if (isIOS()) {
			return JHLogo_ios;
		} else {
			return JHLogo_android;
		}
	}

	public boolean isISAMLinkPresent() {
		if (isIOS()) {
			return TestUtil.waitForAppElement(ISAMPageLink_ios);
		} else {
			return TestUtil.waitForAppElement(ISAMPageLink_android);
		}
	}

	public boolean isLoginPage(String identifier) {
		return TestUtil.findObjectByPerfecto(identifier, "1");
	}

	public WebElement getTextboxElement(String fieldLabel) {

		if (fieldLabel.contains("Username")) {
			if (isIOS())
				return sf_username_ios;
			else
				return sf_username_android;
		} else if (fieldLabel.contains("Password")) {
			if (isIOS())
				return sf_password_ios;
			else
				return sf_password_android;
		} else {
			return null;
		}
	}

}
