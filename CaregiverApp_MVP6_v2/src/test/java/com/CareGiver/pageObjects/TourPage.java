package com.CareGiver.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class TourPage extends Base {

	@FindBy(xpath = "//jh-tutorial//ion-content/div[2]//button[1]")
	public WebElement Start;

	@FindBy(xpath = "//ion-content//h1[text()='All Sessions']")
	public WebElement All_Sessions;

	@FindBy(xpath = "//jh-contact-details//ion-navbar//ion-title")
	public WebElement Header;

	@FindBy(xpath = "//jh-nav-menu//ion-col[1]")
	public WebElement Sessions_Tab;

	@FindBy(xpath = "//mat-list//button//span//div[1]//span")
	public WebElement Past_Sessions;

	@FindBy(xpath = "//jh-session-summary/div[1]/h5[1]")
	public WebElement Recent_Sessions;

	/*
	 * @FindBy(xpath =
	 * "//ion-app[1]//jh-contact-details[1]/ion-content[1]/div[2]//div[2]/button[1]/span[1]")
	 * public WebElement Start_Session_button;
	 */

	// @FindBy(xpath =
	// "//ion-app[1]//jh-contact-details[1]/ion-content[1]/div[2]//ion-grid[1]/ion-row[4]//button")

	@FindBy(xpath = "//*[@class=\"tour__backdrop--targetmask\"]")
	public WebElement End_Session_button;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/ion-row[2]/ion-col[1]/h6")
	@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid/ion-row[2]/ion-col[1]/h6")
	public WebElement Start_Time_label;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/ion-row[2]/ion-col[2]/h6")
	@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid/ion-row[2]/ion-col[2]/h6")
	public WebElement End_Time_label;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[1]/ion-col[1]/h6")
	@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid//form/ion-row[1]/ion-col[1]/h6")
	public WebElement Hourly_Rate_label;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[1]/ion-col[2]//strong")
	@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid//form/ion-row[1]/ion-col[2]//h6/strong")
	public WebElement Total_Cost_label;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[3]//h4")
	@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid//form/ion-row[3]/ion-col[1]/h4")
	public WebElement Services_label;

	//@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[6]/ion-col[2]/button")
	//@FindBy(xpath = "//ion-app[1]//jh-check-out-tour//ion-grid//form/ion-row[6]/ion-col[2]//span")
	@FindBy(xpath = "//jh-check-out-tour//*[@class=\"tour__backdrop--targetmask\"]")
	public WebElement Submit_Session_button;

	/*@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[1]//mat-form-field//input")
	public WebElement hourly_rate;

	@FindBy(xpath = "//ion-app[1]//jh-check-out//ion-grid/form/ion-row[5]//span[contains(text(),'Bathing')]//preceding-sibling::div/input[1]")
	public WebElement bathing;

	@FindBy(xpath = "//ion-action-sheet//span[contains(text(),'Submit')]")
	public WebElement submit_button;
*/
	@FindBy(xpath = "//jh-setup-intro//ion-content//button")
	public WebElement SetUpProfile_button;

	@SuppressWarnings("static-access")
	public TourPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}

	public static boolean isElementPresent(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) appDriver;
		if (Element.isDisplayed()) {
			js.executeScript("arguments[0].style.border='3px solid green'", Element);
			System.out.println("Element is found successfully!");
			return true;
		} else
			return false;
	}

	public static boolean clickElementbyTap(WebElement Element) {
		TouchAction action = new TouchAction(appDriver);
		action.tap(Element);
		action.perform();
		System.out.println("Clicking by tap..");
		return true;
	}
}
