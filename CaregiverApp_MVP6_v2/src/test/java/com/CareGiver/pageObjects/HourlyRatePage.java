package com.CareGiver.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;

public class HourlyRatePage extends Base {

	@FindBy(xpath = "//H1[contains(text(),'Hourly Rate')]")
	public WebElement hourly_rate_page_text1;

	@FindBy(xpath = "//*[contains(text(),'Enter your Hourly Rate')]")
	public WebElement hourly_rate_page_text2;

	@FindBy(xpath = "//label[contains(text(),'Hourly Rate')]")
	public WebElement hourly_rate_page_input_value;

	@FindBy(xpath = "//input[@id='mat-input-1']")
	public WebElement hourly_rate_page_input_EditBox_android;
	//// ion-app//ion-nav/jh-billing-setup/ion-content/div[2]/form//ion-row//mat-form-field//input

	@FindBy(xpath = "//ion-app//ion-nav/jh-billing-setup/ion-content/div[2]/form//ion-row//mat-form-field//input")
	public WebElement hourly_rate_page_input_EditBox_ios;

	@FindBy(xpath = "//*[contains(text(),'Next')]")
	public WebElement hourly_rate_page_nxt_btn;

	@SuppressWarnings("static-access")
	public HourlyRatePage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}

	public WebElement getEditTextBox() {
		if (isIOS())
			return hourly_rate_page_input_EditBox_ios;
		else
			return hourly_rate_page_input_EditBox_android;
	}

	public boolean text1_Validation() {
		if (hourly_rate_page_text1.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean text2_Validation() {
		if (hourly_rate_page_text2.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @Description - Method to enter rate value into Hourly Rate Field
	 * 
	 * @param rateValue
	 * @return boolean - status
	 * 
	 * @author ghsouma
	 */
	public boolean submitHourlyRate(String rateValue) {
		System.out.println("Rate Value to Enter : " + rateValue);
		if (TestUtil.isElementPresent(hourly_rate_page_input_value)) {
			hourly_rate_page_input_value.click();
			TestUtil.pause(3000);
			if (TestUtil.isElementPresent(hourly_rate_page_input_EditBox_android)) {
				TestUtil.setTextboxViaAppDriver(hourly_rate_page_input_EditBox_android, rateValue);
				TestUtil.pause(20000);
				hourly_rate_page_nxt_btn.click();
				TestUtil.pause(20000);
				return true;
			}
		}
		return false;
	}

}
