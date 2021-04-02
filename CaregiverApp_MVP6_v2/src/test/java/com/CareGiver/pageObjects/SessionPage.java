package com.CareGiver.pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.CommonUtil;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.domains.Session;

import cucumber.api.DataTable;
import io.appium.java_client.AppiumDriver;

public class SessionPage extends Base {

	@FindBy(xpath = ".//android.view.View[@text=\"Session\"]")
	public WebElement PageTitle_android;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Session\"]")
	public WebElement PageTitle_ios;

	@FindBy(xpath = ".//android.view.View[@text=\\\"Services Provided\\\"]//parent::android.view.View[1]")
	
	//ion-app[1]//jh-check-out//ion-grid/form/ion-row[3]//h4
	public WebElement ADL_LabelList_android;
	
	@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid//ion-row[3]/ion-col[1]//h4")
	public WebElement Services_Provided_Label;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Activities of Daily Living\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeOther[2]")
	public WebElement ADL_LabelList_FL_ios;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Activities of Daily Living\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeOther[3]")
	public WebElement ADL_LabelList_SL_ios;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Activities of Daily Living\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeOther")
	public WebElement ADL_LabelList_ios;

	@FindBy(xpath = ".//android.view.View[@text=\"Start Time\"]//parent::android.view.View//android.widget.Button")
	public WebElement StartTime_android;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Start Time\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeButton")
	public WebElement StartTime_ios;

	@FindBy(xpath = ".//android.view.View[@text=\"End Time\"]//parent::android.view.View//android.widget.Button")
	public WebElement EndTime_android;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[@label=\"Start Time\"]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeButton")
	public WebElement EndTime_ios;

	@FindBy(xpath = ".//android.widget.EditText[@resource-id=\"mat-input-5\")]")
	public WebElement ADL_Other_TextBox_android;

	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Session\"]")
	public WebElement ADL_Other_TextBox_ios;

	@FindBy(xpath = ".//android.widget.Button[@text=\"Submit Session\"]")
	public WebElement Submit_Session_Btn_android;

	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Submit Session\"]")
	public WebElement Submit_Session_Btn_ios;

	@FindBy(xpath = ".//android.view.View[contains(@text,\"Hourly Rate\")]//parent::android.view.View//android.widget.EditText")
	public WebElement Hourly_Rate_android;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[contains(@label,\"Hourly Rate\")]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//XCUIElementTypeTextField")
	public WebElement Hourly_Rate_ios;

	@FindBy(xpath = ".//android.view.View[contains(@text,\"Total Charges\")]//parent::android.view.View//android.view.View[2]")
	public WebElement Total_Charges_android;

	@FindBy(xpath = ".//XCUIElementTypeStaticText[contains(@label,\"Total Charges\")]//parent::XCUIElementTypeOther/parent::XCUIElementTypeOther//following::XCUIElementTypeOther[2]//XCUIElementTypeStaticText")
	public WebElement Total_Charges_ios;
	
	@FindBy(xpath = ".//*[@resource-id=\\\"android:id/month_view\\\"]//child::android.view.View")
	public WebElement AllDates_android;

	@FindBy(xpath = ".//*[@resource-id=\\\"android:id/radial_picker\\\"]//child::android.widget.RadialTimePickerView.RadialPickerTouchHelper")
	public WebElement AllTime_android;
	
	@FindBy(xpath = "//*[@resource-id=\\\"android:id/month_view\\\"]//child::android.view.View[@checked=\"true\"]")
	public WebElement DatePicker_android;

	@FindBy(xpath=".//android.view.View[@text=\"Time\"]//parent::*")
	public WebElement AllFields_android;
	
	@FindBy(xpath=".//*[@name=\"Session\"]//following::XCUIElementTypeOther[1]")
	public WebElement AllFields_ios;
	
	@FindBy(xpath=".//*[contains(@text,\"add\")]//following::android.widget.Button[1]")
	public WebElement FirstSession_android;
	
	@FindBy(xpath=".//*[contains(@label,\"add\")]//following::XCUIElementTypeButton[1]")
	public WebElement FirstSession_ios;
	
	@SuppressWarnings("static-access")
	public SessionPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}

	public String getPageTitle() {
		if (isIOS())
			return TestUtil.getElementText(PageTitle_ios);
		else
			return TestUtil.getElementText(PageTitle_android);
	}

	public boolean checkADLLabel(List<String> expectedADLs) {
		List<String> actual = TestUtil.getWebElementTexts(getADLs());
		System.err.println("Size Actual:" + actual.size());
		return TestUtil.compareListsContains(expectedADLs, actual);
	}

	public List<WebElement> getADLs() {
		Base.appDriver.context("NATIVE_APP");
		List<WebElement> elements = new ArrayList<WebElement>();

		if (isIOS()) {
			elements.addAll(ADL_LabelList_FL_ios.findElements(By.xpath("//XCUIElementTypeOther//XCUIElementTypeButton")));
			elements.addAll(ADL_LabelList_SL_ios.findElements(By.xpath("//XCUIElementTypeOther//XCUIElementTypeButton")));
			// elements.addAll(ADL_LabelList_ios.findElements(By.xpath("//XCUIElementTypeButton")));

		} else {
			elements.addAll(ADL_LabelList_android.findElements(
					By.xpath("//android.view.View//android.widget.Button")));
		}

		return elements;
	}

	public boolean verifyTime(String timeType, String dateTimeFormat, String roundOffProc) {
		boolean status = false;
		String actualTime = "";
		String expectedRoundOffTime = "";
		WebElement time = null;

		if (timeType.contains("Start") && roundOffProc.contains("previous")) {
			expectedRoundOffTime = CommonUtil.roundOffMin("previous", dateTimeFormat);
			if (isIOS())
				time = StartTime_ios;
			else
				time = StartTime_android;
		} else if (timeType.contains("End") && roundOffProc.contains("next")) {
			expectedRoundOffTime = CommonUtil.roundOffMin("next", dateTimeFormat);
			if (isIOS())
				time = EndTime_ios;
			else
				time = EndTime_android;
		} else {
			System.err.println("Unexpected Input : veriyTime");
		}

		if (time != null) {
			actualTime = TestUtil.getElementText(time);
			System.err.println("Expected Time: " + expectedRoundOffTime);
			System.err.println("actual Time: " + actualTime);
			if (CommonUtil.isValidFormat(dateTimeFormat, actualTime)
					&& expectedRoundOffTime.equalsIgnoreCase(actualTime))

				status = true;

		}
		return status;
	}

	public boolean verifyTime(String timeType, String dateTimeFormat) {
		boolean status = false;
		String actual = "";
		String expected = "";
		WebElement time = null;

		if (timeType.contains("Start")) {
			expected = CommonUtil.getDateTimeFormat(dateTimeFormat);
			if (isIOS())
				time = StartTime_ios;
			else
				time = StartTime_android;

		} else if (timeType.contains("End")) {
			expected = CommonUtil.getDateTimeFormat(dateTimeFormat);
			if (isIOS())
				time = EndTime_ios;
			else
				time = EndTime_android;
		} else {
			System.err.println("Unexpected Input : verifyTime");
		}

		if (time != null) {
			actual = TestUtil.getElementText(time);
			System.err.println("Expected Time: " + expected);
			System.err.println("actual Time: " + actual);
			if (CommonUtil.isValidFormat(dateTimeFormat, actual) && expected.equalsIgnoreCase(actual))
				status = true;

		}

		return status;
	}

	public WebElement getADLBtn(String buttonLabel) {
		WebElement ADLButton = null;

		for (WebElement button : getADLs()) {
			if (TestUtil.getElementText(button).contains(buttonLabel)) {
				ADLButton = button;
				break;
			}
		}

		return ADLButton;
	}

	public WebElement getOtherEditTextBox(String label) {
		if (isIOS())
			return ADL_Other_TextBox_ios;
		else
			return ADL_Other_TextBox_android;
	}

	/**
	 * 
	 * @return Submit
	 */
	public WebElement getSubmitBtn() {
		if (isIOS())
			return Submit_Session_Btn_ios;
		else
			return Submit_Session_Btn_android;
	}

	public boolean clickADLBtn(List<String> ADLs) {
		List<Boolean> result = new ArrayList<Boolean>();

		for (String ADL : ADLs) {
			result.add(TestUtil.clickButton(getADLBtn(ADL)));
		}

		return TestUtil.checkStatusList(result);
	}

	public String fetchHourlyRate() {
		if (isIOS())
			return TestUtil.getElementLabel(Hourly_Rate_ios);
		else
			return TestUtil.getElementText(Hourly_Rate_android);
	}

	public String fetchTotalCharges() {
		if (isIOS())
			return TestUtil.getElementLabel(Total_Charges_ios);
		else
			return TestUtil.getElementText(Total_Charges_android);
	}

	public void parseDateTime(String dateTimeLabel, String rawDateTime, Session session) {

		if (!rawDateTime.isEmpty()) {
			if (dateTimeLabel.contains("Start Time")) {
				session.setCheckinDate(rawDateTime.split(",")[0].trim());
				session.setStartTime(rawDateTime.split(",")[1].trim());

			} else if (dateTimeLabel.contains("End Time")) {
				session.setCheckinDate(rawDateTime.split(",")[0].trim());
				session.setEndTime(rawDateTime.split(",")[1].trim());
			}
		}
	}

	public String deriveTotalCharges(Session session, String dateTimeFormat) throws ParseException {

		double totalHours = 0;
		double totalCharges = 0;
		long second = 1000l;
		long minute = 60l * second;
		long hour = 60l * minute;

		long diff = CommonUtil.getDateTimeDifference(session.getStartTime(), session.getEndTime(), dateTimeFormat);
		
		double hourComponent = Double.parseDouble(String.format("%02d", diff / hour));
		double minuteComponent = Double.parseDouble(String.format("%02d", (diff % hour) / minute));
		double secondComponent = Double.parseDouble(String.format("%02d", (diff % minute) / second));

		totalHours = hourComponent + (minuteComponent / 60) + (secondComponent / 3600);
		totalCharges = (Double.parseDouble(session.getHourlyRate())) * (totalHours);
		
		session.setTotalCharges(String.format("%.2f", totalCharges));
		
		System.err.println("Expected Total Charges:"+session.getTotalCharges());
		return session.getTotalCharges();

	}
	
	public void setCalenderDateTime(String dateTimeLabel, String inputDate, String dateTimeFormat) throws ParseException {
		
		
		String actual = getDisplayDateTime(dateTimeLabel);
		long diff = CommonUtil.getDateTimeDifference(actual, inputDate, dateTimeFormat);
		
		if(diff > 0) {
			
		}
	}
	
	public String getDisplayDateTime(String dateTimeLabel) {
		String actual = "";
		
		if(dateTimeLabel.contains("Start")) {
			if(isIOS()) actual = TestUtil.getElementText(StartTime_ios);
			else actual = TestUtil.getElementText(StartTime_android);
		} else if(dateTimeLabel.contains("End")) {
			if(isIOS()) actual = TestUtil.getElementText(EndTime_ios);
			else actual = TestUtil.getElementText(EndTime_android);
		} else {
			System.out.println("Unexpected DateTime Label");
		}
		
		return actual;
	}
	
	public boolean isReadOnly()
	{
		boolean readOnly=false;
		if (isIOS())
		{
			readOnly=TestUtil.readOnlyCheck(AllFields_ios);
		System.err.println(readOnly);
		}
		else
			System.err.println("In the readonly function");
			readOnly=TestUtil.readOnlyCheck(AllFields_android); 
	
		return readOnly;
		
	}
	
	public boolean isClickable()
			 {
		boolean isClicked=false;
		if (isIOS())
			isClicked=TestUtil.clickButton(FirstSession_ios);
		else
			isClicked=TestUtil.clickButton(FirstSession_android); 
	
		return isClicked;
			 }
	
	public String xpathOfItems(String items,int i, int j)
	{
		if (items == "Items") 
		{
			String ItemXpath = appDriver.findElementByXPath("//ion-app[1]//jh-check-out//ion-grid//ion-row["+i+"]/ion-col["+j+"]//h6").getText().trim();
			return ItemXpath;}
		else if (items== "ServiceItems")
		{
			String ItemXpath = appDriver.findElementByXPath("//ion-app[1]//jh-check-out//ion-grid//ion-row[5]//ion-row["+i+"]/ion-col["+j+"]//label/span").getText().trim();
			
			return ItemXpath;}
		
		return "Xpath not found";
		}
	
	public boolean checkItems(List<String> Items, String items)
	{
		Base.appDriver.context("WEBVIEW");
		
		int i,j = 0;
		boolean flag = false;
		
		for (i=1;i<=Items.size()/2;i++) 
			for (j=1;j<=2;j++)
			{
				 String ItemXpath = xpathOfItems(items,i,j);
				System.out.println(ItemXpath);
				if (Items.contains(ItemXpath)) {
					
					System.out.println("Element "+ ItemXpath + " found successfully!");
					flag = true;
					}
				else
					{
					System.out.println("Element "+ ItemXpath + " not found!");
					
					flag = false;
					}
					
			}
		return flag;
		}
	
	
	@SuppressWarnings("unused")
	public boolean checkServiceItems(DataTable values, int n){
		String label = null;
		boolean flag = false;
		for(int i = 0 ; i< n ; i++) {
			 label = values.raw().get(i).get(0).toString();
			WebElement checkItem = appDriver.findElement(By.xpath("//*[contains(text(),'"+label+"')]//preceding-sibling::div/input[1]"));   //*[contains(text(),'Continence')]//preceding-sibling::div/input[1]
			if (TestUtil.isElementPresent(checkItem)) {
				checkItem.click();
				System.out.println(checkItem + "found and clicked successfully");
				TestUtil.pause(2000);
				label = null;
				flag = true;
			}
			else {
				System.out.println("Element couldn't be found!!");
				flag = false;
			}
		}
		
		return flag;
	}


}
