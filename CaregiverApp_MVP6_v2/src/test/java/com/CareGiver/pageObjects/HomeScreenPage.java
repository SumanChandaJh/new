package com.CareGiver.pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;
import com.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import io.appium.java_client.AppiumDriver;

public class HomeScreenPage extends Base {

	@FindBy(xpath = "//body//ion-app//ng-component//ion-nav//ion-header/ion-navbar/div[2]")/* //body//ion-app//ng-component//ion-nav//jh-contacts/ion-header/ion-navbar/div[2] */
	public WebElement home_screen_logo;

	@FindBy(xpath = "//H1[contains(text(),'Customers')]")
	public WebElement home_screen_text;
	
	@FindBy(xpath = "//*[contains(text(),'All Sessions')]")
	public WebElement home_screen_text_single_user;

	@FindBy(xpath = "//label[contains(text(),'More')]//parent::span//parent::button")
	public WebElement home_screen_More_btn;

	@FindBy(xpath = "//label[contains(text(),'Profile')]")
	public WebElement home_screen_Profile_Btn;
	
	@FindBy(xpath="//label[contains(text(),'Customers')]")
	public WebElement home_screen_Customers_Btn;
	
	@FindBy(xpath="//label[contains(text(),'More')]")
	public WebElement home_screen_More_Btn;

	@FindBy(xpath = "//ion-app//jh-nav-menu/ion-footer//ion-row")
	public WebElement homeScreen_FooterMenu;
	
	@FindBy(xpath = "//label[contains(text(),'More')]//ancestor::ion-row//ancestor::ng-component//following-sibling::ion-popover//jh-nav-popover-menu//button[4]//*[contains(text(),'Log Out')]")
	public WebElement log_Out_Btn;

	@SuppressWarnings("static-access")
	public HomeScreenPage(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(Base.appDriver, this);
	}

	/*@SuppressWarnings("unused")
	public boolean home_Screen_Footer_Validation(DataTable values) {

		// boolean flag = false;
		// label[contains(text(),'Profile')]//ancestor::ion-row
		try {
			ArrayList<Boolean> resultList = new ArrayList<Boolean>();

			if (TestUtil.isElementPresent(homeScreen_FooterMenu)) {
				List<WebElement> list_menuItems = homeScreen_FooterMenu.findElements(By.tagName("ion-col"));
				System.out.println("List Menu Items Size :" + list_menuItems.size());
				if (list_menuItems != null) {
					int itemIndex = 0;
					for (int index = 0; index < list_menuItems.size(); index++) {
						// for (WebElement currentMenuItem : list_menuItems) {

						// WebElement currentMenuItem_label =
						// currentMenuItem.findElement(By.xpath("//label"));
						WebElement currentMenuItem = list_menuItems.get(index);
						WebElement currentMenuItem_label = currentMenuItem.findElement(By.xpath("//label"));

						String expectedLabel = values.raw().get(0).get(index);

						if (TestUtil.isElementPresent(currentMenuItem_label)) {
							System.out.println("Expected Label : " + expectedLabel);
							System.out.println("Actual Label : " + currentMenuItem_label.getText().toString());
							if (currentMenuItem_label.getText().toString().contentEquals(expectedLabel)) {
								Reporter.addStepLog("Label matched for Menu Item " + expectedLabel);
								resultList.add(true);
							} else {
								Reporter.addStepLog("Label  not matched for Menu Item " + expectedLabel);
								resultList.add(false);
							}
						} else {
							Reporter.addStepLog("Unable to find Footer Menu Item : " + expectedLabel);
							resultList.add(false);
						}
					}
					if (resultList.contains(false)) {
						return false;
					} else {
						return true;
					}
				}

			} else {
				Reporter.addStepLog("Unable to find the Footer Menu on Home Screen");
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception Occurred !!");
			return false;
		}
		return false;*/

		/*
		 * {
		 * 
		 * List<WebElement> elements =
		 * home_screen_Profile_Btn.findElements(By.tagName("ion-col"));//
		 * appDriver.findElements(By.xpath("//ion-app//ion-footer//ion-row"));
		 * 
		 * for (int i = 0; i < elements.size(); i++) { //
		 * System.out.println(elements.get(i).toString()+" //
		 * "+(values.raw().get(0).get(i))); if
		 * (elements.get(i).toString().equalsIgnoreCase(values.raw().get(0).get(
		 * i))) { System.out.println(elements.get(i).toString() +
		 * (values.raw().get(0).get(i))); flag = true; }
		 * 
		 * } }
		 * 
		 * if (flag) { return true; } return false;
		 */

	//}

	/*
	 * public boolean more_Btn_Click_Validation(){
	 * if(home_screen_More_btn.isDisplayed()){ TestUtil.pause(1000);
	 * home_screen_More_btn.click(); return true; } return false; }
	 */
	
	public WebElement getElement(String label){
		Base.appDriver.context("WEBVIEW");
		/*String xpathValue = "\""+"//label[contains(text(),'"+label+"')]"+"\"";
		System.out.println(xpathValue);*/
		WebElement element = appDriver.findElement(By.xpath("//label[contains(text(),'"+label+"')]"));
		return element;
	}
	
	public boolean matchLabel(WebElement element,String label){
		if (element!=null){
			if (element.getText().toString().equalsIgnoreCase(label))
			{
				System.out.println(label+" Element "+" Found!!");
				return true;
			}
			else 
				return false;
		}
		else 
			return false ;
	}

	//public void on_More_Btn_Click(DataTable morevalues) {

/*		boolean flag = false;
		List<WebElement> moreelements = appDriver
				.findElements(By.xpath("//label[contains(text(),'More')]//parent::span//parent::button"));

		for (int i = 0; i < moreelements.size(); i++) {
			if (moreelements.get(i).toString().equalsIgnoreCase(morevalues.raw().get(0).get(i))) {
				System.out.println(moreelements.get(i).toString() + (morevalues.raw().get(0).get(i)));
				flag = true;
			}
		}
		if (flag) {
			return true;
		}
		return false;*/
	//}
	
	public WebElement getMoreElement(String label,String value){
		Base.appDriver.context("WEBVIEW");
		//WebElement element = appDriver.findElement(By.xpath("//label[contains(text(),'More')]//ancestor::ion-row//ancestor::ng-component//following-sibling::ion-popover//jh-nav-popover-menu//button[1]//*[contains(text(),'Tips')]"));
		WebElement element = appDriver.findElement(By.xpath("//label[contains(text(),'More')]//ancestor::ion-row//ancestor::ng-component//following-sibling::ion-popover//jh-nav-popover-menu//button["+value+"]//*[contains(text(),'"+label+"')]"));
		return element;
	}
}
