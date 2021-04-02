package step_definitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import General.Settings;
import factory.driver.*;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import support.businesslogic.AppVariables;

public class CukeHooks {

	private static Logger log = Logger.getLogger(CukeHooks.class);
	public Scenario scenario;
	Driver newDriver;
	static Properties properties;

	@Before
	public void setup(Scenario scenario) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("current.date.time", dateFormat.format(new Date()));

		try {
			this.scenario = scenario;
			AppVariables.current_scenario = scenario;

			// Setting Environment
			properties = Settings.getInstance();
			AppVariables.ENVIRONMENT = properties.getProperty("ENVIRONMENT");

			// getting browser value from runtime
			String browserName = System.getProperty("browser");
			System.out.println("Browser Name :" + browserName);

			// instantiating browser instance based on run-time browser value and execution
			// mode
			newDriver = DriverFactory.getInstance(browserName);

			// assigning browser instance to ThreaLocal value to support multi-threading
			DriverManager.getInstance().setWebDriver(newDriver);

		} catch (NullPointerException e) {
			log.error("NullPointerException Occured at @Before :\n" + e.getMessage());
		} catch (Exception e) {
			log.error("Execption Occured at @Before:\n" + e.getMessage());
		}
	}

	@After
	public void teardown() {
		if (DriverManager.getInstance().getWebDriver() != null) {
			DriverManager.getInstance().quitDriver();
		}
	}

	@AfterStep
	public void takeScreenshot() {
		// if (scenario.isFailed()) {
		byte[] src = ((TakesScreenshot) newDriver.driver).getScreenshotAs(OutputType.BYTES);
		// scenario.log(scenario.getName() + "is failed");
		scenario.attach(src, "image/png", "");
		// }
	}
}
