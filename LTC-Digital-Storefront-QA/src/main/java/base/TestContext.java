package base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import General.Interaction;
import General.Settings;
import factory.driver.*;
import factory.pageobjects.*;
import io.cucumber.java.Scenario;
import support.businesslogic.Constants;

public class TestContext {

	// public Driver driver;
	public Interaction interaction;
	private static Logger log = Logger.getLogger(TestContext.class);
	// Pages
	public LoginPage loginPage;
	public DashboardLogin dashboardLogin;
	public HomePage homePage;
	public DashboardHome dashboardHome;
	public Scenario scenario;
	public SFDC_Login sfdc_Login;
	public GroupPasscodeRequest groupPasscodeRequest;

	public TestContext() {
		interaction = Interaction.getInstance();
		initializePageObjects();
	}

	public void initializePageObjects() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		dashboardLogin = new DashboardLogin(driver);
		dashboardHome = new DashboardHome(driver);
		sfdc_Login = new SFDC_Login(driver);
		groupPasscodeRequest = new GroupPasscodeRequest(driver);
	}

	public boolean checkHeaderTitle(String loginPageType, String expected_page_title) {
		switch (loginPageType) {
		case Constants.LOGIN_TYPE_DASHBOARD:
			return dashboardLogin.checkHeaderTitle(expected_page_title);

		case Constants.LOGIN_TYPE_LTC:
			return loginPage.checkHeaderTitle(expected_page_title);
		case "PRODUCTION_SF":
			return interaction.isElementVisible(sfdc_Login.page_title_logo);
		}
		return false;
	}

	public boolean checkHeaderLogo(String pageName, String expected_page_title) {
		Driver driver = DriverManager.getInstance().getWebDriver();
		switch (pageName) {
		case Constants.HOME_DASHBOARD:
			LighthouseUtility.invokeLighthouse(driver);
			if (interaction.isElementVisible(dashboardHome.header_item_logo)) {
				log.info("Logo for Dashboard is visible.");
				return true;
			}
		case Constants.HOME_LTC:
			WebElement element = homePage.header_item_logo;
			/*
			 * Waiting for flyout to load as it changes DOM of the page. If not done header
			 * logo will always throw Stale Element Exception
			 */if (interaction.waitForElement(homePage.flyout_menu_item_premiums)) {
				
				if (interaction.isElementVisible(element)) {
					interaction.highlightElement(element, true);
					log.info("Logo for Homepage is visible.");
					return true;
				}
			}

		}
		return false;

	}

	public boolean setUsername(String loginPageType, String textToSet) {
		WebElement element = null;
		switch (loginPageType) {
		case Constants.LOGIN_TYPE_DASHBOARD:
			element = dashboardLogin.username;
			break;
		case Constants.LOGIN_TYPE_LTC:
			element = loginPage.username;
			break;
		}
		return interaction.setTextElement(element, textToSet);
	}

	public boolean setPassword(String loginPageType, String textToSet) {
		WebElement element = null;
		switch (loginPageType) {
		case Constants.LOGIN_TYPE_DASHBOARD:
			element = dashboardLogin.password;
			break;
		case Constants.LOGIN_TYPE_LTC:
			element = loginPage.password;
			break;
		}

		textToSet = TestUtility.removeHTMLContent(textToSet);
		return interaction.setTextElement(element, textToSet);
	}

	public boolean clickLoginButton(String loginPageType) {
		WebElement element = null;
		switch (loginPageType) {
		case Constants.LOGIN_TYPE_DASHBOARD:
			element = dashboardLogin.login_button;
			break;
		case Constants.LOGIN_TYPE_LTC:
			element = loginPage.login_button;
			break;
		}

		return interaction.clickWebElement(element);
	}

	public boolean verifyLoggedInUsername(String pageName, String userFullName) {
		WebElement usernameObject = null;
		switch (pageName) {
		case Constants.HOME_DASHBOARD:
			usernameObject = dashboardHome.header_item_fullname;
			break;
		case Constants.HOME_LTC:
			usernameObject = homePage.header_item_fullname;
			break;

		}
		if (TestUtility.compareTextContains(usernameObject, userFullName, false)) {
			interaction.highlightElement(usernameObject, true);
			return true;
		}
		return false;
	}

}
