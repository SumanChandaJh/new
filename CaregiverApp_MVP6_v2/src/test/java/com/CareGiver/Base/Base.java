package com.CareGiver.Base;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.CareGiver.supportLibraries.DriverManager;
import com.CareGiver.supportLibraries.MobileExecutionPlatform;
import com.CareGiver.supportLibraries.SeleniumTestParameters;
import com.CareGiver.supportLibraries.Settings;
import com.CareGiver.supportLibraries.Util;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;

public class Base {

	//
	static Logger log;
	static Properties properties;
	static SeleniumTestParameters testParams;
	static Scenario scenario;
	CommonUtil commonUtil;

	static {
		log = Logger.getLogger(Base.class);
	}

	public static String singletap = "single";
	public static String doubletap = "double";

	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;
	public static long EXPLICIT_WAIT = 10;
	public static AppiumDriver<WebElement> appDriver;
	public static WebDriver webDriver;
	//public static WebDriver webDriver = getChromeDriver();
	public static RemoteWebDriver remoteDriver;
	public static MobileExecutionPlatform mobileExecPlatform;
	public static String manufacturer = "";
	public static String platform = "";

	@SuppressWarnings("unchecked")
	public Base() {

		testParams = DriverManager.getTestParameters();
		appDriver = DriverManager.getAppiumDriver();
		platform = appDriver.getPlatformName();
		remoteDriver = DriverManager.getAppiumDriver();
		//webDriver  = getChromeDriver();
		properties = Settings.getInstance();
		commonUtil = new CommonUtil();
		mobileExecPlatform = testParams.getMobileExecutionPlatform();
		manufacturer = testParams.getManuFacturerName();

	}

	public static boolean isIOS() {
		if (platform.equalsIgnoreCase("ios"))
			return true;
		return false;
	}

	public static boolean isAnroid() {
		if (platform.equalsIgnoreCase("Anroid"))
			return true;
		return false;
	}

	
	
	public static WebDriver getChromeDriver() {
		//log.info("Starting 'Chrome' Browser");
		if (webDriver == null) {
			System.setProperty("webdriver.chrome.driver", Util.getChromeDriverPath());
			webDriver = new ChromeDriver();
		}
		
		return webDriver;
	}
	
	public static void closeWebDriver() {
		webDriver.quit();
		webDriver.close();
	}

	public static String getSystemInfo(String infoName) {
		String info = "";

		if (infoName.equalsIgnoreCase("MobileExecPlatform")) {
			info = testParams.getMobileExecutionPlatform().name();
		} else if (infoName.equalsIgnoreCase("CloudPlatform")) {
			info = testParams.getExecutionMode().toString();
		} else if (infoName.equalsIgnoreCase("MobileOSversion")) {
			info = testParams.getMobileOSVersion();
		} else if (infoName.equalsIgnoreCase("ModelName")) {
			info = testParams.getManuFacturerName();
		} else if (infoName.equalsIgnoreCase("DeviceId")) {
			info = testParams.getDeviceName();
		} else if (infoName.equalsIgnoreCase("AuthorName")) {
			info = testParams.getDeviceName();
		}

		return info;
	}

	public void captureExtentReport() {

		try {
			Util.takeSnapshot(webDriver, scenario);
			log.info("The screenshot has been taken");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception " + scenario.getName());

		}
	}

}
