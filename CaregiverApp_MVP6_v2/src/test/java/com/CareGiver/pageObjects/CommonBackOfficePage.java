package com.CareGiver.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.CareGiver.supportLibraries.WebDriverFactory;

import io.appium.java_client.AppiumDriver;


public class CommonBackOfficePage extends Base {

	
	@FindBy(xpath = ".//*[text()='Username']")
	public WebElement SFDCLOGIN_USERNAME ;
	
	@FindBy(xpath = ".//*[text()='Password']")
	public WebElement SFDCLOGIN_PASSWORD;
	
	@FindBy(xpath = ".//*[@class='standard_logo'][@alt='Salesforce']")
	public WebElement SFDCLOGO_LOGIN;
	
	@FindBy(xpath = ".//input[@name='username']")
	public WebElement SFDC_LOGIN_USERNAME_TEXTBOX;
	
	@FindBy(xpath = ".//input[@name='pw']")
	public WebElement SFDC_LOGIN_PASSWORD_TEXTBOX;
	
	@FindBy(xpath = ".//*[@value='Log In to Sandbox']")
	public WebElement SFDC_LOGIN_SIGNIN_BUTTON;
	
	@FindBy(xpath = ".//*[@class='slds-global-header__logo']")
	public WebElement SFDC_LIGHTNING_LOGO;
	
	@FindBy(xpath = ".//*[@class='switch-to-lightning'][text()='Switch to Lightning Experience']")
	public WebElement SFDC_CLASSIC_LOGO;
	
	@FindBy(xpath = ".//*[@id='oneHeader']/div[2]/span/ul/li[9]/button")
	public WebElement SFDC_PROFILE_ICON;
	
	@FindBy(xpath = ".//*[text()='Switch to Salesforce Classic']")
	public WebElement SFDC_SWITCHTO_CLASSIC_VIEW;
	
	@FindBy(xpath = ".//*[@class='pageTitleIcon']//following::select[1]")
	public WebElement ALL_ACCOUNTS_CLASSIC_DROPDOWN;
	
	@FindBy(xpath = ".//*[contains(@title,'Accounts')]")
	public WebElement ACCOUNTS_TAB_LIGHTNING;
	
	@FindBy(xpath = "//button[@class='slds-button']//child::div[@class='slds-icon-waffle']")
	public WebElement ALL_TABS_SFDCLIGHTNING;
	
	@FindBy(xpath = ".//*[text()='Claims']")
	public WebElement CLAIMS_SFDCLIGHTNING;
	
	@FindBy(xpath = ".//*[contains(@class,'label slds-truncate slds-text-link')][text()='Time Logs']")
	public WebElement TIMELOGS_LINK;
	
	@FindBy(xpath = ".//*[contains(@class,'triggerLinkTextAndIconWrapper')]//child::span[contains(@class,'selectedListView')]")
	public WebElement ALL_TIMELOGS_DROPDOWN;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[contains(@class,'uiOutputText')][text()='Time Logs']")
	public WebElement TIME_LOG_PAGE;
	
	@FindBy(xpath = ".//*[@class='slds-dropdown__list slds-show']//child::li//child::span")
	public WebElement TIMELOG_LIST;
	
	@FindBy(xpath = ".//*[contains(@class,'slds-dropdown__item')]//child::span[text()='All Time Logs']")
	public WebElement ALL_TIME_LOGS_VALUE;
	
	@FindBy(xpath = ".//*[contains(@class,'triggerLinkText selectedListView')]")
	public WebElement SELECTED_TIMELOG_DROPDOWN;
	
	@FindBy(xpath = ".//*[contains(@class,'slds-text-link--reset')]//child::span[text()='Time Log ID']")
	public WebElement TIMELOGCOLUMN_TIMELOGTABLE;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[contains(@class,'slds-assistive-text')][contains(text(),'Sorted')]")
	public WebElement SORT_COLUMN;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//tbody/tr[1]/th[1]//child::a")
	public WebElement FIRST_ROW_TABLE_SFDC;
	
	@FindBy(xpath = ".//*[text()='Created By']")
	public WebElement CREATED_BY_LABEL;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Time Log']")
	public WebElement TIMELOG_INFORMATION_PAGE;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Account Name']")
	public WebElement ACCOUNT_NAME;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Hourly Rate']")
	public WebElement HOURLY_RATE_LABEL;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Hourly Rate']//following::span[1]")
	public WebElement HOURLY_RATE_VALUE;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Record Type']")
	public WebElement RECORD_TYPE_LABEL;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Record Type']//following::span[1]")
	public WebElement RECORD_TYPE_VALUE;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Related Claim']")
	public WebElement RELATED_CLAIM_LABEL;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Related Claim']//following::span[1]")
	public WebElement RELATED_CLAIM_VALUE;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Local Check-in Date and Time']")
	public WebElement CHECK_IN_DATE_TIME;
	
	@FindBy(xpath = ".//*[contains(@class,'oneContent active')]//*[text()='Local Check-in Date and Time']//following::span[1]")
	public WebElement CHECK_IN_DATE_TIME_VALUE;
	
	public CommonBackOfficePage(WebDriver webDriver) {
		super.webDriver = webDriver;

		// initElements method will create all WebElements
		PageFactory.initElements(Base.webDriver, this);
	
	}
	
	public boolean isnavigated(String envURL) {
		boolean present = false;
		TestUtil.pause(5000);
		
		webDriver.get(envURL);
		webDriver.manage().window().maximize();
	     present=TestUtil.waitForAppElement(SFDCLOGIN_USERNAME);
		if(present)
		{
			System.out.println("I have successfully navgated to the URL");
		}
		else
		{
			System.out.println("I have not successfully navgated to the URL");
		}
		return present;
	}

	
	public boolean isloggedIn(String userID,String password) {
		boolean loginFlag=false;
		
		TestUtil.waitForAppElement(SFDC_LOGIN_USERNAME_TEXTBOX);
		TestUtil.waitForAppElement(SFDC_LOGIN_PASSWORD_TEXTBOX);
		TestUtil.waitForAppElement(SFDC_LOGIN_SIGNIN_BUTTON);
		
		SFDC_LOGIN_USERNAME_TEXTBOX.sendKeys(userID);
		SFDC_LOGIN_PASSWORD_TEXTBOX.sendKeys(password);
		SFDC_LOGIN_SIGNIN_BUTTON.click();
		TestUtil.pause(5000);
		loginFlag=TestUtil.waitForAppElement(ACCOUNTS_TAB_LIGHTNING);
		if(loginFlag)
		{
			System.out.println("Login is successful");
		}
			
		else
		{
			System.out.println("Login is not successful yet");
		}
		return loginFlag;
		
		
	}
}