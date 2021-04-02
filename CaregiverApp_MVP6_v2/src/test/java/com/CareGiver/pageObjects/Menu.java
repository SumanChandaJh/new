package com.CareGiver.pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.CareGiver.Base.Base;
import com.CareGiver.Base.TestUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Menu extends Base {
	
	@FindBy(xpath = ".//android.widget.Button[@text=\"Log Out\"]")
	public WebElement Logout_Btn_android;
	
	@FindBy(xpath = ".//XCUIElementTypeButton[@label=\"Log Out\"]")
	public WebElement Logout_Btn_ios;
	
	@SuppressWarnings("static-access")
	public Menu(AppiumDriver<WebElement> appDriver) {
		super.appDriver = appDriver;
		PageFactory.initElements(new AppiumFieldDecorator(appDriver, IMPLICIT_WAIT, TimeUnit.SECONDS), this);

    }
	

	public boolean checkMenuItems(List<String> menuItems) {
		List<Boolean> check = new ArrayList<Boolean>(Arrays.asList(new Boolean[1]));
		Collections.fill(check, Boolean.TRUE);
		
		for(String menuName : menuItems) {			
			check.add(TestUtil.objectCheckpointByText(menuName, "1"));
			TestUtil.pause(1000);

		}
		
		if(check.contains(false)) {
			return false;
		} else {
			return true;
		}
	}
	
	public WebElement getLogoutBtn() {
		if(isIOS()) return Logout_Btn_ios;
		else return Logout_Btn_android;
	}
	
	
	public boolean logout(String label) {
		if(isIOS()) {
			return TestUtil.clickButtonByLabel(label, singletap, 1);
		} else {
			return TestUtil.clickButtonByLabel(label, singletap, 1);
		}
	}

}
