package factory.driver;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import General.Settings;

public class Driver implements WebDriver {

	private enum browsers {
		FIREFOX, firefox, CHROME, chrome, EDGE, edge
	}

	static Logger log;
	static String projectPath;
	static Properties properties;

	static {
		log = Logger.getLogger(Driver.class);
	}

	public WebDriver driver;

	// private Driver() {}

	public Driver(String browserName) {
		projectPath = new File(System.getProperty("user.dir")).getAbsolutePath();
		properties = Settings.getInstance();

		// String browserName = System.getProperty("browser", "chrome");
		log.info("Browser name captured as runtime variable - " + browserName);

		browsers browser = browsers.valueOf(browserName);

		if ((browser.equals(browsers.FIREFOX)) || (browser.equals(browsers.firefox))) {
			System.setProperty("webdriver.gecko.driver", (projectPath + properties.getProperty("GECKO_DRIVER_PATH")));
			log.info("Instatiating Driver - Firefox");
			driver = new FirefoxDriver();
		} else if ((browser.equals(browsers.CHROME)) || (browser.equals(browsers.chrome))) {
			System.setProperty("webdriver.chrome.driver", projectPath + properties.getProperty("CHROME_DRIVER_PATH"));
			log.info("Instatiating Driver - CHROME");
			driver = new ChromeDriver();

		} else if ((browser.equals(browsers.EDGE)) || (browser.equals(browsers.edge))) {
			System.setProperty("webdriver.edge.driver", projectPath + properties.getProperty("EDGE_DRIVER_PATH"));
			log.info("Instatiating Driver - EDGE");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

	}

	/*
	 * public Driver() { System.setProperty("webdriver.chrome.driver", projectPath +
	 * Base.properties.getProperty("CHROME_DRIVER_PATH"));
	 * log.info("Instatiating Driver - CHROME"); driver = new ChromeDriver(); }
	 */

	@Override
	public void close() {
		this.driver.close();

	}

	@Override
	public WebElement findElement(By by) {
		return this.driver.findElement(by);
	}

	@Override
	public List<WebElement> findElements(By by) {
		return this.driver.findElements(by);
	}

	@Override
	public void get(String url) {
		this.driver.get(url);

	}

	@Override
	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}

	@Override
	public String getPageSource() {
		return this.driver.getPageSource();
	}

	@Override
	public String getTitle() {
		return this.driver.getTitle();
	}

	@Override
	public String getWindowHandle() {
		return this.driver.getWindowHandle();
	}

	@Override
	public Set<String> getWindowHandles() {
		return this.driver.getWindowHandles();
	}

	@Override
	public Options manage() {
		return this.driver.manage();
	}

	@Override
	public Navigation navigate() {
		return this.driver.navigate();
	}

	@Override
	public void quit() {
		this.driver.quit();
	}

	@Override
	public TargetLocator switchTo() {
		return this.driver.switchTo();
	}

}
