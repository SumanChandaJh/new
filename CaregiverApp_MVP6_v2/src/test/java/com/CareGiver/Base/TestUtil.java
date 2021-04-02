package com.CareGiver.Base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CareGiver.stepDefinitions.MasterStepDefs;
import com.CareGiver.supportLibraries.Util;
import com.google.common.base.Function;

import cucumber.api.DataTable;

public class TestUtil extends MasterStepDefs {

	// Skip the Step at IOS platform.
	// Note: This is a workaround until QA fix the Perfecto/IOS dependency
	public static boolean skipAtIOS() {
		System.err.println("Skipped the Step at IOS platform.");
		return true;
	}

	public static void cleanApplication(String appname) {

		Map<String, Object> params = new HashMap<>();
		params.put("name", appname);

		// executeScript-JavaScript Code
		System.err.println("Cleaning application");
		Base.remoteDriver.executeScript("mobile:application:clean", params);

	}
	
	public static boolean isElementPresent(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) Base.appDriver;
		Base.appDriver.context("WEBVIEW");
		if (Element.isDisplayed()) {
			js.executeScript("arguments[0].style.border='1px solid green'", Element);
			System.out.println("Element" + Element + "is found successfully!");
			Util.takeSnapshot(Base.appDriver, currentScenario);
			return true;
		} else
			return false;
	}

	public static boolean cleanIOSApplication(RemoteWebDriver driver) {
		// define visual driver and native driver:
		boolean status = false;

		try {
			openApp("Battery Saver");
			Base.appDriver.context("NATIVE_APP");
			System.out.println("Cleaning IOS app cache . . .");
			// switchToContext(driver, "NATIVE_APP");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElementByXPath("//*[@label=\"Disk\"]").click();
			// click on clean cache
			driver.findElementByXPath("//*[@label=\"btn jj off\"]").click();

			// handle pop up in case it s there
			try {
				driver.findElementByXPath("//*[@label=\"OK\"]").click();
				pause(15000);
			} catch (Exception e) {
				// no pop up, move on with script
				System.err.println("Exception while cleaning the IOS app");
			}

			// validate cache cleaned
			Map<String, Object> params2 = new HashMap<>();
			params2.put("content", "\"Junk Cleaned\"");
			params2.put("timeout", "10");
			if (driver.executeScript("mobile:checkpoint:text", params2) != null) {
				System.out.println("IOS app Cache cleaned successfully");
				status = true;
			}

			// Tap back btn
			driver.findElementByXPath("//*[@label=\"btn back\"]").click();

			// close battery doctor:
			return status;

		} catch (Exception e) {
			System.out.println("Failed to clean application cache");
			return false;
		}
	}

	/**
	 * 
	 * @param Appname
	 */
	public static void closeApp(String Appname) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("name", Appname);
			Base.remoteDriver.executeScript("mobile:application:close", params);
			System.out.println("Application " + Appname + " is closed successfully");

		} catch (Exception e) {
			System.out.println("Unable to close Application " + Appname);
		}

	}

	public static boolean openApp(String appName) {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("name", appName);
			if (Base.remoteDriver.executeScript("mobile:application:open", params) != null) {
				System.out.println(appName + " app is opened successfully");
				Util.takeSnapshot(Base.appDriver, currentScenario);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Unable to open application " + appName);
			return false;
		}

	}

	public static boolean hidePerfectoMobileKeyboard() {
		Map<String, Object> param = new HashMap<>();
		param.put("keySequence", "HIDE_KEYBOARD ");
		if (Base.appDriver.executeScript("mobile:presskey", param) != null) {
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param rawText
	 * @return
	 */
	public static String formatText(String rawText) {
		return rawText.trim();
	}

	public static boolean clickButtonByJS(WebElement button) {

		boolean clicked = false;
		JavascriptExecutor js = (JavascriptExecutor) Base.appDriver;

		if (button != null) {
			if (button.isEnabled() && button.isDisplayed()) {
				js.executeScript("arguments[0].click();", button);
				System.out.println("Clicked Element" + button);
				clicked = true;
			}

		} else {
			System.out.println("Click action can not be executed");
			clicked = false;
		}

		return clicked;
	}

	/*
	 * Function Name : takeScreenshot Parameter : None Function Description : Stores
	 * the screenshot in the results folder of the project featurewise and also
	 * separately
	 */

	public static void takeScreenshot() {
		currentScenario.embed(Util.takeScreenshot(Base.appDriver), "image/png");
		System.out.println("Screenshot taken successfully");

	}

	public static void pause(long milisecs) {
		try {
			Thread.sleep(milisecs);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public static boolean clickButton(WebElement button) {
		boolean clicked = false;
		Base.appDriver.context("NATIVE_APP");

		if (button != null) {
			Base.appDriver.context("NATIVE_APP");
			System.err.println(button.toString());
			button.click();

			clicked = true;
		}

		return clicked;
	}

	public static boolean clickButtonByAction(WebElement button) {
		boolean clicked = false;
		Actions actions = new Actions(Base.appDriver);

		try {

			if (button != null) {

				System.err.println("Not Null");
				if (button.isEnabled()) {
					actions.moveToElement(button);
					actions.click().build().perform();
					System.out.println("Clicked button" + button);

				}

			} else {
				System.out.println("Click action can not be executed");
			}

		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}

		return clicked;
	}

	/*
	 * FunctionName : clickElement Parameters : @objLabel : The label of the element
	 * (eg : Login,register)
	 * 
	 * @operation: single/double ( for operations like single tap,double tap)
	 * 
	 * @index : The index from perfecto (eg,1,2,3 as defined in Perfecto object
	 * identification)
	 */
	public static boolean clickButtonByLabel(String objLabel, String operation, int index) {

		Map<String, Object> clickbutton = new HashMap<>();
		clickbutton.put("label", objLabel);
		clickbutton.put("operation", operation);
		clickbutton.put("index", index);

		try {
			Base.appDriver.executeScript("mobile:button-text:click", clickbutton);
			System.out.println(objLabel + " button clicked successfully");

			return true;

		} catch (Exception e) {
			System.out.println("Button is not clickable");
			return false;
		}
	}

	/**
	 * 
	 * @param element
	 * @return
	 */
	public boolean clickElement(WebElement element) {
		boolean clicked = false;

		try {
			if (element != null) {
				Base.appDriver.context("NATIVE_APP");
				element.click();
				clicked = true;
			}
		} catch (Exception e) {
			clicked = false;
		}

		return clicked;
	}

	public static boolean isVisible(WebElement element) {
		boolean visible = false;
		Base.appDriver.context("NATIVE_APP");

		if (element != null) {
			if (Base.isIOS()) {
				System.err.println("visible:" + element.getAttribute("visible"));
				visible = element.getAttribute("visible").equalsIgnoreCase("true");
			} else {
				visible = element.isDisplayed();
			}
		}

		return visible;
	}

	/**
	 * u
	 * 
	 * @param labelElement
	 * @param table
	 * @return
	 */
	public static boolean isLabelMatched(WebElement labelElement, List<Map<String, String>> table) {
		boolean matched = false;

		if (labelElement.isDisplayed()) {
			if (formatText(labelElement.getText()).equalsIgnoreCase(getFieldLabelFromTable(table))) {
				matched = true;
			}
		}

		return matched;
	}

	/**
	 * Wait
	 * 
	 * @param element
	 * @throws Error
	 * 
	 * @author rajansa
	 */
	public static boolean waitForAppElement(WebElement element) throws Error {

		boolean objectAvailablityFlag = false;
		try {

			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(Base.appDriver);
			wait.pollingEvery(500, TimeUnit.MILLISECONDS);
			wait.withTimeout(10, TimeUnit.SECONDS);
			// wait.ignoring(NoSuchElementException.class,
			// StaleElementReferenceException.class);

			objectAvailablityFlag = wait.until(new Function<WebDriver, Boolean>() {
				int iterationCount = 0;
				WebElement webObj = null;

				public Boolean apply(WebDriver driver) {
					iterationCount++;
					if (TestUtil.isVisible(element)) {
						System.out.println("Element found in " + (iterationCount / 2) + " seconds !!");
						if (webObj.isDisplayed()) {
							System.out.println("Element is visible on app.");
							return true;
						} else {
							System.out.println("Element is visible on app.");
							return true;
						}
					}
					System.out.println("Element not found in " + (iterationCount / 2)
							+ "Checking for element again in 0.5 seconds....");
					return false;
				}
			});

		} catch (NullPointerException e) {
			System.err.println("Null Pointer exception");
		} catch (TimeoutException e) {
			System.err.println("Element is not present after waiting for :" + 10 + " seconds.");
		}
		return objectAvailablityFlag;

		/*
		 * Base.appDriver.context("NATIVE_APP"); boolean present = false; int wait = 1;
		 * int globalWait = 12; if (element != null) {
		 * 
		 * present = TestUtil.isVisible(element); System.err.println(present);
		 * 
		 * while (!present && wait <= globalWait) { present =
		 * TestUtil.isVisible(element);
		 * 
		 * if (present) { System.out.println("Found element in " + wait + " seconds");
		 * break;
		 * 
		 * } else { pause(1000); System.out.println("Wait for -" + wait + "- second");
		 * wait++; } }
		 * 
		 * } else { System.err.println(element + "Element not found"); }
		 * 
		 * System.err.println("wait-For-Element:" + present); return present;
		 */
	}

	public static void waitForWebElement(WebElement element) throws Error {

		// appDriver.context("NATIVE_APP");
		WebDriverWait wait = new WebDriverWait(Base.webDriver, Base.EXPLICIT_WAIT);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getFieldLabelFromTable(List<Map<String, String>> table) {
		String label = "";

		for (Map<String, String> row : table) {
			label = row.get("Label");
		}

		System.out.println("Label:" + label);
		return label;
	}

	public static String getFieldValueFromTable(List<Map<String, String>> table) {
		String value = "";

		for (Map<String, String> row : table) {
			value = row.get("Value");
		}

		System.out.println("Value:" + value);
		return value;
	}

	/*
	 * FunctionName : findObjectbyText Function Description : finds the object by
	 * text
	 * 
	 * @parameters : text(the text to find) : index(the instance of text if more
	 * than one instances are present)
	 */

	public static boolean findObjectByPerfecto(String text, String index) {
		Map<String, Object> findObject = new HashMap<>();
		findObject.put("content", text);
		findObject.put("index", index);

		if (Base.appDriver.executeScript("mobile:text:find", findObject) != null) {
			System.out.println(" Element is found by :" + text);
			return true;
		} else {
			System.out.println("Element is not found by :" + text);
			return false;
		}

	}

	/*
	 * Function : objectCheckpointbyText Function Description : Finds and check
	 * whether the object is present and returns true/false
	 * 
	 * @parameters : expectedText(The Text to find) index(position of the object ie
	 * 1,2 etc)
	 */
	public static boolean objectCheckpointByText(String expectedText, String index) {
		Map<String, Object> params = new HashMap<>();
		params.put("content", expectedText);
		params.put("index", index);

		System.out.println("expectedText::" + expectedText);

		if (Base.appDriver.executeScript("mobile:checkpoint:text", params) != null) {
			System.out.println("Element " + expectedText + " found successfully");
			return true;

		} else {

			System.out.println("Element " + expectedText + " not found");
			return false;

		}
	}

	/*
	 * Function Name : setDatatoEditBox Parameters : @elementIdentifier (eg
	 * :label,text) The identifier using which it will search
	 * 
	 * @elementText(eg : Username,Password) The value of the identifier
	 * 
	 * @ text : The data to be entered in the editbox Function Description : This
	 * function will enter the text into the editbox
	 */
	public static boolean setEditBoxByLabel(String fieldLabel, String value) {
		boolean result = false;
		Map<String, Object> params = new HashMap<>();
		params.put("label", fieldLabel);
		params.put("text", value);

		if (Base.appDriver.executeScript("mobile:edit-text:set", params) != null) {
			result = true;
			System.out.println(value + " is set to the field " + fieldLabel);
		}

		return result;
	}

	public static boolean setTextbox(WebElement element, String value) {

		if (element != null) {
			element.sendKeys(value);
			return true;
		}

		return false;
	}
	
	public static boolean setTextboxViaAppDriver(WebElement element, String value) {

		if (element != null) {
			element.click();
			System.out.println("Inside setTEXT box via app driver");
			element.clear();
			Base.appDriver.getKeyboard().sendKeys(value);
			//element.sendKeys(value);
			Util.takeSnapshot(Base.appDriver, currentScenario);
			return true;
		}
		return false;
	}

	public static String getDataTableColumnValue(DataTable table, String columnName) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		return data.get(0).get(columnName);
	}

	public static boolean pressGoBtn() {
		try {

			Map<String, Object> params = new HashMap<>();
			params.put("keySequence", "GO");
			if (Base.appDriver.executeScript("mobile:presskey", params) != null)
				;

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean pressNextBtn() {
		try {

			Map<String, Object> params = new HashMap<>();
			params.put("keySequence", "NEXT");
			if (Base.appDriver.executeScript("mobile:presskey", params) != null)
				;

			return true;

		} catch (Exception e) {
			return false;
		}
	}

	// iOS
	public static String getElementLabel(WebElement element) {

		String label = "";
		Base.appDriver.context("NATIVE_APP");

		if (element != null) {
			label = element.getAttribute("label");
		}

		return label;
	}

	//
	public static String getElementText(WebElement element) {

		String text = "";
		Base.appDriver.context("NATIVE_APP");

		if (Base.isIOS())
			text = element.getAttribute("label");
		else
			text = element.getAttribute("text");

		System.err.println("getElementText:: " + text);
		return text;
	}

	public static boolean checkStatusList(List<Boolean> statusList) {

		System.err.println(statusList.toString());
		if (statusList.contains(false))
			return false;
		else
			return true;

	}

	public static List<String> getWebElementTexts(List<WebElement> elements) {
		List<String> elementTexts = new ArrayList<String>();

		if (elements.size() > 0) {
			for (WebElement element : elements) {
				elementTexts.add(getElementText(element));
			}
		}
		return elementTexts;
	}

	public static boolean compareListsContains(List<String> expected, List<String> actual) {
		List<Boolean> result = new ArrayList<Boolean>();

		System.out.println(expected.toString());
		System.out.println(actual.toString());

		for (String actualText : actual) {
			for (String expectedText : expected) {
				if (actualText.contains(expectedText)) {
					result.add(true);
					break;
				}
			}
		}

		System.err.println(result.toString());
		return checkStatusList(result);
	}

	public boolean swipeDatePicker(WebElement element, String swipemode) {
		boolean status = false;

		Map<String, Object> params = new HashMap<>();
		params.put("order", swipemode);
		params.put("offset", 0.15);
		params.put("element", ((RemoteWebElement) element).getId());

		if (Base.appDriver.executeScript("mobile:selectPickerWheelValue", params) != null) {
			status = true;
		}

		return status;
	}

	public static boolean readOnlyCheck(WebElement element) {
		boolean readOnlyFlag = false;
		Base.appDriver.context("NATIVE_APP");

		if (element != null) {
			if (Base.isIOS()) {
				System.err.println("read only attribute" + element.getAttribute("hittable"));
				readOnlyFlag = element.getAttribute("hittable").equalsIgnoreCase("false");
			} else {
				readOnlyFlag = element.getAttribute("clickable").equalsIgnoreCase("false");
			}
		}

		return readOnlyFlag;

	}

	public static boolean isEnabled(WebElement element) {
		boolean enable = false;
		Base.appDriver.context("NATIVE_APP");

		if (element != null) {
			if (Base.platform.equalsIgnoreCase("ios")) {
				System.err.println("enabled:" + element.getAttribute("enabled"));
				enable = element.getAttribute("enabled").equalsIgnoreCase("true");
			} else {
				enable = element.isDisplayed();
			}
		}

		return enable;
	}

	public static boolean clickButtonViaWebView(WebElement button) {
		boolean clicked = false;
		Base.appDriver.context("WEBVIEW");
		if (button != null) {
			System.err.println(button.toString());
			button.click();
			clicked = true;
		}
		return clicked;
	}
}
