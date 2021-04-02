package com.CareGiver.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class PastSessionPage extends Base{
	
	@SuppressWarnings("static-access")
	public PastSessionPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}
	
	@FindBy(xpath = "//ion-app//jh-tutorial/button/span")
	public WebElement Skip_button;

	@FindBy(xpath = "//jh-setup-intro//ion-content//button")
	public WebElement SetUpProfile_button;
	
	@FindBy(xpath = "(//input[@id='mat-input-0'])[1]")
	public WebElement HourlyRate;
	
	@FindBy(xpath = "//*[contains(text(),'Next')]")
	public WebElement Next_button;
	
	@FindBy(xpath = "//*[contains(text(),'Yes')]")
	public WebElement Submit_Past_Session_button;
	
	@FindBy(xpath = "//h6[contains(text(),'End Time')]//following-sibling::div//span")
	public WebElement End_Time_input;
	
	@FindBy(xpath = "//h6[contains(text(),'Start Time')]//following-sibling::div//span")
	public WebElement Start_Time_input;
	
	@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[5]//span[contains(text(),'Bathing')]//preceding-sibling::div/input[1]")
	public WebElement bathing;
	
	@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[6]//span")
	public WebElement Submit_Session_button;
	
	@FindBy(xpath = "//ion-action-sheet//span[contains(text(),'Submit')]")
	public WebElement submit_button;
	
	@FindBy(xpath = "//*[contains(text(),'Start Time and End Time must be on the same day.')]")
	public WebElement Error_Msg_Future_Date;
	
	@FindBy(xpath = "//*[contains(text(),'Date and Time must be in the past.')]")
	public WebElement Error_MsgOne_Future_Time;
	
	@FindBy(xpath = "//*[contains(text(),'End Time must be after Start Time.')]")
	public WebElement Error_MsgTwo_Future_Time;
	
	@FindBy(xpath = "//*[@resource-id=\"android:id/button1\")")
	public static WebElement Okay_Button_Native;
	
	@FindBy(xpath = "//span[contains(text(),'Return to the home screen')]")
	public  WebElement HomeScreen_button;
	
	public static boolean setTextboxViaAppDriver(WebElement element, String value) {

		if (element != null) {
			element.click();
			Base.appDriver.getKeyboard().sendKeys(value);
			// element.sendKeys(value);
			//Util.takeSnapshot(Base.appDriver, currentScenario);
			return true;
		}
		return false;
	} 
	
	public static void setStartTime(String ActualTime) {
		Base.appDriver.context("NATIVE_APP");
		clickOkayButton();
		List <WebElement> allElements = appDriver.findElementsByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper");
		System.out.println("Size of all elements " + allElements.size());
		int ActualTimeInt = Integer.parseInt(ActualTime);
		allElements.get(ActualTimeInt-1).click();
		clickOkayButton();
	}
	public static void setUserDate(String date) {
		/*Base.appDriver.context("NATIVE_APP");
		WebElement Current_Date = appDriver.findElement(By.xpath("//*[@checked='true']"));
		Current_Date.click();*/
		setDate(date);
		clickOkayButton();
		clickOkayButton();
	}
	
	/*public static void setCurrentEndDate(String date) {
		
		setDate(date);
		clickOkayButton();
		clickOkayButton();
	}*/
	
	public static void setEndTime()
	{
		List <WebElement> allElements = appDriver.findElementsByXPath("//android.widget.RadialTimePickerView.RadialPickerTouchHelper");
		System.out.println("Size of all elements " + allElements.size());
		allElements.get(9).click();
		WebElement ok_button = appDriver.findElement(By.xpath("//*[@resource-id=\"android:id/button1\"]"));
		ok_button.click();
	}
	
	public static void setDate(String date) {
		//boolean flag = true;
		System.out.println("Inside Set End Time");  
		Base.appDriver.context("NATIVE_APP");
	/*do {   
		
		System.out.println("Inside Set End Time do loop.."); 
	    WebElement source = appDriver.findElement(By.xpath("//android.view.View[@content-desc='01 March 2020']"));    
	    WebElement destination = appDriver.findElement(By.xpath("//android.view.View[@content-desc='"+date+"']"));
	    System.out.println(source.getText());
	    System.out.println("//android.view.View[@content-desc='"+date+"']");
	    TouchAction action = new TouchAction((PerformsTouchActions)appDriver);    
	    System.out.println("Dragging item");    
	    action.longPress(source).moveTo(destination).release().perform();
	    action.press(source).moveTo(destination).release().perform();
	   // flag = appDriver.findElementsByXPath("//android.view.View").isEmpty();
	    flag = appDriver.findElementsByXPath("//android.view.View[@content-desc='"+date+"']").isEmpty();

	  } while(flag!=false);*/
		TouchAction action = new TouchAction((PerformsTouchActions)appDriver);
		WebElement destination = appDriver.findElement(By.xpath("//android.view.View[@content-desc='"+date+"']"));
		action.moveTo(destination);
		appDriver.findElementByAccessibilityId(date).click();
		
	}
	public static void clickOkayButton()
	{	Base.appDriver.context("NATIVE_APP");
		WebElement ok_button = appDriver.findElement(By.xpath("//*[@resource-id=\"android:id/button1\"]"));
		ok_button.click();
		TestUtil.pause(3000);
	}
}
