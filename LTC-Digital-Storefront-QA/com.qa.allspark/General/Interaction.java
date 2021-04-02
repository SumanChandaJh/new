package General;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestUtility;
import factory.driver.Driver;
import factory.driver.DriverManager;
import io.cucumber.java.Scenario;

public class Interaction {

	private static final Logger log = Logger.getLogger(Interaction.class);
	private static Interaction interaction;

	public static Interaction getInstance() {
		if (interaction == null) {
			interaction = new Interaction();
		}
		return interaction;
	}

	public static String getScreenshotName(Scenario scenario) {
		return scenario.getName().replaceAll(" ", "_");
	}

	public static void takeSnapshot(Driver driver, Scenario scenario) {

		String screenshotPath = TestUtility.getReportConfigPath() + TestUtility.getFileSeparator() + "screenshots"
				+ TestUtility.getFileSeparator() + getScreenshotName(scenario)
				+ TestUtility.getCurrentDateAndTimeStamp() + ".png";
		try {
			File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File destinationPath = new File(TestUtility.getFileSeparator() + screenshotPath);
			FileUtils.copyFile(sourcePath, destinationPath);
			// Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (Exception e) {
			e.getMessage();
			System.err.println("Exception while Taking snapshot");
		}
	}

	private Driver driver;

	// Encapsulation
	private Interaction() {
		driver = DriverManager.getInstance().getWebDriver();
	}

	/*
	 * public Interaction(Driver driver) { this.driver = driver; }
	 */

	public boolean clickWebElement(WebElement element) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		Actions actions = new Actions(driver.driver);
		if (element != null) {
			if (element.isEnabled()) {
				// element.click();
				actions.moveToElement(element);
				actions.perform();
				actions.moveToElement(element);
				actions.click().perform();

				log.info("Clicked Element" + element.toString());
				return true;
			}
		}
		return false;
	}

	public boolean hoverElement(WebElement element) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		Actions actions = new Actions(driver.driver);
		if (element != null) {
			if (element.isEnabled()) {
				actions.moveToElement(element);
				actions.perform();
				log.info("Hovered over Element" + element.toString());
				return true;
			}
		}
		return false;
	}

	public boolean isElementVisible(WebElement element) {

		if (element != null) {
			if (element.isEnabled()) {
				if (element.isDisplayed()) {
					return true;
				} else
					log.info("Element is not displayed !!");
			} else
				log.info("Element is not enabled !!");
		} else
			log.info("Element is null !!");
		return false;
	}

	public boolean selectDropDownValue(WebElement dropdownElement, String text) {
		if (dropdownElement != null) {
			List<WebElement> options = dropdownElement.findElements(By.tagName("li"));
			for (WebElement option : options) {
				if (option.getText().contains(text)) {
					this.clickWebElement(option);
					log.info("Selected Element" + option.getText().toString());
					return true;
				}
			}
		}
		return false;
	}

	public boolean setTextElement(WebElement element, String textToSet) {
		if (this.waitForElement(element)) {
			element.sendKeys(textToSet);
			log.info("Set " + element + " with text : " + textToSet);
			return true;
		}
		log.error("Unable to Set " + element + " with text : " + textToSet);
		return false;
	}

	public boolean verifyElementText(WebElement element, String page_title_string) {
		if (waitForElement(element)) {
			return TestUtility.compareText(element, page_title_string, false);
		}
		return false;
	}

	public boolean verifyElementTextFromProperties(WebElement element, String page_title_string) {
		if (waitForElement(element)) {
			return TestUtility.compareText(element, page_title_string, true);
		}
		return false;
	}

	public boolean waitForElement(final WebElement element) {

		try {
			Driver driver = DriverManager.getInstance().getWebDriver();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver.driver);
			wait.pollingEvery(Duration.ofSeconds(1));
			wait.withTimeout(Duration.ofSeconds(20));
			wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);

			return wait.until(new Function<WebDriver, Boolean>() {
				double iterationCount = 0;

				public Boolean apply(WebDriver driver) {
					iterationCount++;
					if (element != null) {
						log.info("Element found in " + (iterationCount) + " seconds !!");
						if (element.isDisplayed()) {
							log.info("Element is visible on webpage.");
							return true;
						}
					}
					log.error(
							"Element not found in " + (iterationCount) + " seconds. Checking again in 0.5 seconds....");
					return false;
				}
			});
		} catch (NullPointerException e) {
			System.out.println("Null Pointer exception");
		} catch (TimeoutException e) {
			log.error("\nElement is not present after waiting for :" + 20 + " seconds.");
		}
		return false;
	}

	public void waitForSeconds(int number_of_seconds) {
		try {
			Thread.sleep(number_of_seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void highlightElement(WebElement element, boolean status) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver.driver;
		if (status) {
			js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid blue;');", element);
		} else {
			js.executeScript("arguments[0].setAttribute('style', ' border: 2px solid red;');", element);
		}

	}

	public void selectValueFromDropdown(WebElement element, String Value) {
		Select selectedElement = new Select(element);
		try {
			selectedElement.selectByVisibleText(Value);
		} catch (NoSuchElementException e) {
			System.out.println("Unable to select the required value");
		}
	}

	public void selectElement(List<WebElement> list, String paymentYear) {
		System.out.println("Payment Year list size is" + list.size());
		Driver driver = DriverManager.getInstance().getWebDriver();
		for (int i = 0; i <= list.size(); i++) {
			WebElement element = driver.findElement(By.xpath("//c-ltc-select//ul/li[" + (i + 1) + "]/label"));
			System.out.println("The required year text is" + element.getText());
			if (element.getText().equals(paymentYear)) {

				clickWebElement(element);
				break;
			}
		}

		log.info("Required element for selection is not found!!");
	}

	public void scrollToElement(WebElement element) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		JavascriptExecutor je = (JavascriptExecutor) driver.driver;
		je.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public WebElement waitForElementToBeClickable(WebElement element) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		WebDriverWait driverWait = new WebDriverWait(driver, 15);
		return driverWait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void clickWebElementByJS(WebElement element) {
		try {
			Driver driver = DriverManager.getInstance().getWebDriver();
			JavascriptExecutor executor = (JavascriptExecutor) driver.driver;
			executor.executeScript("arguments[0].click();", element);
			log.info("Clicked " + element + " by clickWebElementByJS()");
		} catch (Exception e) {
			log.error("Exception occured in clickWebElementByJS()");
		}

	}

	public boolean setElementTextByJS(WebElement element, String valueToSet) {
		try {
			Driver driver = DriverManager.getInstance().getWebDriver();
			JavascriptExecutor executor = (JavascriptExecutor) driver.driver;
			executor.executeScript("arguments[0]." + "value='" + valueToSet + "';", element);
			log.info("Set Element Text : " + element + "set to value : " + valueToSet + " using setElementTextByJS()");
			return true;
		} catch (Exception e) {
			log.error("Exception occured in setElementTextByJS()");
			return false;
		}

	}
}
