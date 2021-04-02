package com.CareGiver.pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.Base.Var;

import io.appium.java_client.AppiumDriver;

public class CheckOutPage extends Base {

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Session\"]")
	public WebElement PageTitle_ios;

	@FindBy(xpath = ".//*[@text=\"New Session\"]")
	public WebElement PageTitle_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"Start Time\"]")
	public WebElement Start_Time_ios;

	@FindBy(xpath = ".//*[@text=\"Start Time:\"]")
	public WebElement Start_Time_android;

	@FindBy(xpath = "//XCUIElementTypeStaticText[@label=\"End Time\"]")
	public WebElement End_Time_ios;

	@FindBy(xpath = ".//*[@text=\"End Time:\"]")
	public WebElement End_Time_android;

	@FindBy(xpath = ".//*[contains(@label,\"Hourly Rate\")]")
	public WebElement Hourly_Rate_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Hourly Rate\")]")
	public WebElement Hourly_Rate_android;

	@FindBy(xpath = ".//*[contains(@label,\"Total Charges\")]")
	public WebElement Total_Charges_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Total\")]")
	public WebElement Total_Charges_android;

	@FindBy(xpath = ".//*[contains(@label,\"Submit Session\")]")
	public WebElement Submit_Session_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Submit Session\")]")
	public WebElement Submit_Session_android;

	@FindBy(xpath = ".//*[contains(@label,\"End Session\")]")
	public WebElement End_Session_ios;

	@FindBy(xpath = ".//*[contains(@text,\"End Session\")]")
	public WebElement End_Session_android;

	@FindBy(xpath = ".//*[contains(@label,\"Bathing\")]")
	public WebElement Bathing_ADL_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Bathing\")]")
	public WebElement Bathing_ADL_android;

	@FindBy(xpath = ".//*[contains(@text,\"Start Date\")]//preceding::android.view.View[1]")
	public WebElement CustomerName_android;

	@FindBy(xpath = ".//*[contains(@text,\"Start Time\")]/parent::*//android.widget.Button")
	public WebElement StartTime_Value_android;

	@FindBy(xpath = ".//*[contains(@label,\"Start Time\")]/parent::*/parent::*/XCUIElementTypeButton")
	public WebElement StartTime_Value_ios;

	@FindBy(xpath = ".//*[contains(@text,\"End Time\")]/parent::*//android.widget.Button")
	public WebElement EndTime_Value_android;

	@FindBy(xpath = ".//*[contains(@label,\"Start Time\")]//following::XCUIElementTypeButton[2]")
	public WebElement EndTime_Value_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Hourly Rate\")]/parent::*//android.widget.EditText")
	public WebElement HourlyRate_Value_android;

	@FindBy(xpath = ".//*[contains(@label,\"Hourly Rate\")]//following::XCUIElementTypeTextField")
	public WebElement HourlyRate_Value_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Total Charges\")]//following::android.view.View[1]")
	public WebElement totalCharges_Value_android;

	@FindBy(xpath = ".//*[contains(@label,\"Total Charges\")]//following::XCUIElementTypeStaticText[1]")
	public WebElement totalCharges_Value_ios;

	@FindBy(xpath = ".//*[contains(@text,\"zero\")]")
	public WebElement zero_hourlyRate_android;

	@FindBy(xpath = ".//*[contains(@label,\"zero\")]")
	public WebElement zero_hourlyRate_ios;

	@FindBy(xpath = ".//*[contains(@label,\"Invalid\")]")
	public WebElement invalid_hourlyRate_ios;

	@FindBy(xpath = ".//*[contains(@text,\"Invalid\")]")
	public WebElement invalid_hourlyRate_android;

	@FindBy(xpath = ".//*[contains(@text,\"enter a value\")]")
	public WebElement other_error_android;

	@FindBy(xpath = ".//*[contains(@label,\"enter a value\")]")
	public WebElement other_error_ios;

	@FindBy(xpath = ".//*[@text=\"End Time\"]//following::android.view.View[1]")
	public WebElement endTime_errormessage_android;

	@FindBy()
	public WebElement endTime_errormessage_ios;

	@FindBy(xpath = ".//*[contains(@label,\"maximum\")]")
	public WebElement maxValue_errormessage_ios;

	@FindBy(xpath = ".//*[contains(@text,\"maximum\")]")
	public WebElement maxValue_errormessage_android;

	@FindBy(xpath=".//android.view.View[@text=\"Time\"]//preceding::android.view.View")
	public WebElement AllFields_android;
	
	@FindBy(xpath="")
	public WebElement AllFields_ios;
	
	@SuppressWarnings("static-access")
	public CheckOutPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.appDriver, this);
		// PageFactory.initElements(new AppiumFieldDecorator(appDriver,
		// Base.IMPLICIT_WAIT, TimeUnit.SECONDS), this);
	}

	public boolean isSubmitSessionBtnPresent() {
		boolean present = false;
		TestUtil.pause(5000);

		if (isIOS())
			present = TestUtil.waitForAppElement(Submit_Session_ios);
		else
			present = TestUtil.waitForAppElement(Submit_Session_android);
		return present;
	}

	public boolean isEndSessionBtnPresent() {
		boolean present = false;
		TestUtil.pause(5000);

		if (isIOS())
			present = TestUtil.waitForAppElement(End_Session_ios);
		else
			present = TestUtil.waitForAppElement(End_Session_android);
		return present;
	}

	public boolean isSessionDeleted() {
		boolean sessionExist = false;
		TestUtil.pause(5000);
		boolean deleteSession = isEndSessionBtnPresent();
		if (deleteSession) {

		} else {

		}
		return deleteSession;
	}

	public boolean selectADL() {
		boolean clickableADLFlag = false;
		boolean selectADLflag = false;
		TestUtil.pause(5000);
		if (isIOS())
			clickableADLFlag = TestUtil.isEnabled(Bathing_ADL_ios);
		else
			clickableADLFlag = TestUtil.isEnabled(Bathing_ADL_android);

		if (clickableADLFlag) {
			if (Var.MOBILE_OS.equalsIgnoreCase("IOS")) {
				Bathing_ADL_ios.click();
				System.out.println("Element has been clicked successfully");
				selectADLflag = true;
			} else {
				Bathing_ADL_android.click();
				System.out.println("Element has been clicked successfully");
				selectADLflag = true;
			}
		}
		return selectADLflag;

	}

	public boolean readOnlyStartTime() {
		boolean readOnlyFlag = false;

		TestUtil.pause(5000);

		if (isIOS())
			readOnlyFlag = TestUtil.isEnabled(StartTime_Value_ios);
		else
			readOnlyFlag = TestUtil.isEnabled(StartTime_Value_android);

		if (readOnlyFlag)
			System.out.println("It is readOnly");

		return readOnlyFlag;

	}

	public boolean readOnlyEndTime() {
		boolean readOnlyFlag_endTime = false;
		if (isIOS())
			readOnlyFlag_endTime = TestUtil.isEnabled(EndTime_Value_ios);
		else
			readOnlyFlag_endTime = TestUtil.isEnabled(EndTime_Value_android);

		return readOnlyFlag_endTime;
	}

	public WebElement returnWebelement() {
		WebElement isEntered;
		if (isIOS())
			isEntered = HourlyRate_Value_ios;
		else
			isEntered = HourlyRate_Value_android;
		return isEntered;
	}

	public boolean errorMessageValidation(String errorIdentifier) {
		String errorMessage = "";
		String errorMessageScreen = "";
		boolean matchFlag = false;
		if (isIOS()) {
			if (errorIdentifier.equalsIgnoreCase("Zero Hourly Rate")) {
				errorMessage = Var.INVALID_HOURLY_RATE_ERROR_MESSAGE;
				errorMessageScreen = zero_hourlyRate_ios.getText();

			}

			if (errorIdentifier.equalsIgnoreCase("Invalid Hourly Rate")) {
				errorMessage = Var.INVALID_HOURLY_RATE_ERROR_MESSAGE;
				errorMessageScreen = invalid_hourlyRate_ios.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("End Time Error Message")) {
				errorMessage = Var.ENDTIME_MORE_ERRORMSG;
				errorMessageScreen = endTime_errormessage_ios.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("Other Error Message")) {
				errorMessage = Var.OTHER_VALUE_ERRORMSG;
				errorMessageScreen = other_error_ios.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("Maximum Value Exceeded")) {
				errorMessage = Var.MYHOURLYRATE__VALUEMORE_ERRMSG;
				errorMessageScreen = maxValue_errormessage_ios.getText();
			}
			if (errorMessage.contentEquals(errorMessageScreen)) {
				System.out.println("Errormessage matched");
				matchFlag = true;
			}

		} else {
			if (errorIdentifier.equalsIgnoreCase("Zero Hourly Rate")) {
				errorMessage = Var.INVALID_HOURLY_RATE_ERROR_MESSAGE;
				errorMessageScreen = zero_hourlyRate_android.getText();

			}

			if (errorIdentifier.equalsIgnoreCase("Invalid Hourly Rate")) {
				errorMessage = Var.INVALID_HOURLY_RATE_ERROR_MESSAGE;
				errorMessageScreen = invalid_hourlyRate_android.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("End Time Error Message")) {
				errorMessage = Var.ENDTIME_MORE_ERRORMSG;
				errorMessageScreen = endTime_errormessage_android.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("Other Error Message")) {
				errorMessage = Var.OTHER_VALUE_ERRORMSG;
				errorMessageScreen = other_error_android.getText();
			}

			if (errorIdentifier.equalsIgnoreCase("Maximum Value Exceeded")) {
				errorMessage = Var.MYHOURLYRATE__VALUEMORE_ERRMSG;
				errorMessageScreen = maxValue_errormessage_android.getText();
			}
			if (errorMessage.contentEquals(errorMessageScreen)) {
				System.out.println("Errormessage matched");
				matchFlag = true;
			}
		}

		return matchFlag;
	}

	public boolean isPageTitleVerified(String pageTitle) {
		boolean pageTitleMatchFlag = false;
		String pageTitleScreen = "";
		System.out.println(pageTitle);
		System.out.println("In the isPagetitleVerified function");

		if (isIOS()) {

			pageTitleScreen = PageTitle_ios.getText();
		}

		else

			pageTitleScreen = PageTitle_android.getText();
		System.out.println("Screen Text is" + pageTitleScreen);

		if (pageTitleScreen.equals(pageTitle)) {
			pageTitleMatchFlag = true;
			System.out.println("PageTitle Matched");
		}
		return pageTitleMatchFlag;

	}

	public boolean totalChargeVerified() {
		boolean isMatched = false;
		String startTimeText = "";
		String endTimeText = "";
		String StartDate = "";
		String EndDate = "";
		String startTime = "";
		String endTime = "";
		String hourlyRateText = "";
		String totalChargesText = "";
		SimpleDateFormat sdf = new SimpleDateFormat();
		if (isIOS()) {
			startTimeText = StartTime_Value_ios.getAttribute("text");
			endTimeText = EndTime_Value_ios.getAttribute("text");
			hourlyRateText = HourlyRate_Value_ios.getAttribute("text");
			totalChargesText = totalCharges_Value_ios.getAttribute("text");
		} else {
			startTimeText = StartTime_Value_android.getAttribute("text");
			endTimeText = EndTime_Value_android.getAttribute("text");
			hourlyRateText = HourlyRate_Value_android.getAttribute("text");
			totalChargesText = totalCharges_Value_android.getAttribute("text");
			System.err.println("Total Charges On Screen"+totalChargesText);
		}
		double totalHours = 0;
		double totalCharges = 0;
		SimpleDateFormat format = new SimpleDateFormat("m/dd/yy h:mm a");
		long second = 1000l;
		long minute = 60l * second;
		long hour = 60l * minute;

		Date date1;
		Date date2;

		try {
			startTimeText = startTimeText.replaceAll(",", "");
			endTimeText = endTimeText.replaceAll(",", "");
			date1 = format.parse(startTimeText);
			date2 = format.parse(endTimeText);
			long diff = date2.getTime() - date1.getTime();
			double hourComponent = Double.parseDouble(String.format("%02d", diff / hour));
			double minuteComponent = Double.parseDouble(String.format("%02d", (diff % hour) / minute));
			double secondComponent = Double.parseDouble(String.format("%02d", (diff % minute) / second));

			totalHours = hourComponent + (minuteComponent / 60) + (secondComponent / 3600);
			//System.err.println("Hi Total Hours" + totalHours);

			double totalCharge = (Double.parseDouble(hourlyRateText)) * (totalHours);
			System.err.println(String.format("%.2f", totalCharge));
			
			if ((Double.toString(totalCharge)).equals(totalChargesText)) {
				System.err.println("matched");
				isMatched = true;
			}else
			{
				System.err.println("total charges present"+totalChargesText);
				System.err.println("total charges calculated"+totalCharge);
			}

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return isMatched;

	}

	public boolean checkReadOnly(List<String> fieldItems) {
		List<Boolean> check = new ArrayList<Boolean>(Arrays.asList(new Boolean[1]));
		Collections.fill(check, Boolean.TRUE);
		
		for(String fieldName : fieldItems) {			
			check.add(TestUtil.objectCheckpointByText(fieldName, "1"));
			TestUtil.pause(1000);

		}
		
		if(check.contains(false)) {
			return false;
		} else {
			return true;
		}
	}
	
}