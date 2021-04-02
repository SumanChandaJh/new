package factory.driver;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;

public class DriverManager {

	private static Logger log = Logger.getLogger(DriverManager.class);
	private static DriverManager driverManager;

	public static DriverManager getInstance() {
		if (driverManager == null) {
			driverManager = new DriverManager();
		}
		return driverManager;
	}

	private ThreadLocal<Driver> driver = new ThreadLocal<Driver>();

	private DriverManager() {
	}

	public void closeDriver() {
		driverManager.getWebDriver().close();
		log.info("Close Web Driver : Successful");
	}

	public Driver getWebDriver() {
		if (driver.get() == null) {
			log.info("No WebDriver Available ");
			setWebDriver(DriverFactory.getInstance(null));
		}
		return driver.get();
	}

	public void quitDriver() {
		driverManager.getWebDriver().quit();
		log.info("Quit Web Driver : Successful");
	}

	public void setWebDriver(Driver driver) {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driverManager.driver.set(driver);
	}

}
