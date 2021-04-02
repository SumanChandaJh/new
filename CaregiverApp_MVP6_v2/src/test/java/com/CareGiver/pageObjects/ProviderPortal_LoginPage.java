package com.CareGiver.pageObjects;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class ProviderPortal_LoginPage extends Base {

	@FindBy(xpath = "//*[@id=\"bannerDiv\"]//h1")
	public WebElement PageTitle_android;

	@FindBy(xpath = "//XCUIElementTypeOther[@name=\"Independent care provider login\"]//XCUIElementTypeStaticText")
	public WebElement PageTitle_ios;

	@FindBy(xpath = "//*[@resource-id=\"lblUsername\"]")
	public WebElement Username_Label;

	@FindBy(xpath = "//*[@resource-id=\"userName\"]")
	public WebElement Username_TextBox_android;

	@FindBy(xpath = "//*[@value=\"Enter username\"]")
	public WebElement Username_TextBox_ios;

	@FindBy(xpath = ".//*[@resource-id=\"lblPassword\"]")
	public WebElement Password_Label;

	@FindBy(xpath = "//*[@resource-id=\"passwordField\"]")
	public WebElement Password_TextBox_android;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField")
	public WebElement Password_TextBox_ios;

	@FindBy(xpath = "//android.widget.Button[@resource-id=\"btnLogin\"]")
	public WebElement Login_Button_android;

	@FindBy(xpath = "//XCUIElementTypeSecureTextField/following-sibling::XCUIElementTypeOther[3]/XCUIElementTypeButton")
	public WebElement Login_Button_ios;

	@SuppressWarnings("static-access")
	public ProviderPortal_LoginPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
	}

	public boolean isPageTitleMatched(String pageTitle) {
		boolean matched = false;

		if (isIOS()) {
			// not working
			// title = PageTitle_ios;
			matched = TestUtil.objectCheckpointByText(pageTitle, "1");
		} else {
			Base.appDriver.context("WEBVIEW");
			matched = PageTitle_android.getText().trim().equalsIgnoreCase(pageTitle);
		}

		return matched;
	}

	public boolean clickLoginButton(String label) {
		if (isIOS()) {
			// return TestUtil.clickButton(Login_Button_ios);
			// return TestUtil.clickButtonByAction(Login_Button_ios);
			// return TestUtil.clickButtonByLabel("ICP Login", singletap, 1);
			return TestUtil.pressGoBtn();

		} else {
			// hide the keyboard by clicking on non-editable webelement
			Base.appDriver.context("WEBVIEW");
			getPageTitleElement().click();
			TestUtil.pause(2000);
			return TestUtil.clickButton(Login_Button_android);

		}
	}

	public boolean setTextBox(WebElement element, List<Map<String, String>> dataTable) {
		appDriver.context("NATIVE_APP");
		boolean set = false;
		String value = TestUtil.getFieldValueFromTable(dataTable);
		System.err.println(value);

		if (element != null) {
			element.click();
			TestUtil.pause(1000);
			element.sendKeys(value);

			set = true;

		}

		System.err.println(set);
		return set;
	}

	public boolean setTextBox(WebElement element, String value) {
		appDriver.context("NATIVE_APP");
		boolean set = false;
		// System.err.println(value);

		if (element != null) {
			// element.click();
			TestUtil.pause(1000);
			element.sendKeys(value);

			set = true;

		}

		System.err.println(set);
		return set;
	}

	public WebElement getTextBoxElement(String testBoxName) {
		WebElement element = null;

		if (testBoxName.equalsIgnoreCase("Username")) {
			if (isIOS())
				element = Username_TextBox_ios;
			else
				element = Username_TextBox_android;
		} else if (testBoxName.equalsIgnoreCase("Password")) {
			if (isIOS())
				element = Password_TextBox_ios;
			else
				element = Password_TextBox_android;
		}

		return element;
	}

	public WebElement getLoginBtnElement() {
		WebElement loginBtn = null;

		if (isIOS()) {
			loginBtn = Login_Button_ios;
		} else {
			loginBtn = Login_Button_android;
		}

		return loginBtn;
	}

	public WebElement getPageTitleElement() {
		WebElement loginBtn = null;

		if (isIOS()) {
			loginBtn = PageTitle_ios;
		} else {
			loginBtn = PageTitle_android;
		}

		return loginBtn;
	}
}
