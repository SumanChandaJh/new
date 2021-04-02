package base;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import General.Interaction;
import factory.driver.Driver;
import factory.driver.DriverManager;
import factory.pageobjects.SFDC_Accounts;
import factory.pageobjects.SFDC_Home;
import factory.pageobjects.SFDC_Login;
import support.businesslogic.AppVariables;
import support.businesslogic.Constants;

public class BackofficeContext /* extends TestContext */ {

	private static Logger log = Logger.getLogger(BackofficeContext.class);
	public SFDC_Login sfdc_Login;
	public SFDC_Home sfdc_Home;
	public SFDC_Accounts sfdc_Accounts;
	private Interaction interaction;

	public BackofficeContext() {
		interaction = Interaction.getInstance();
		initializePages();
	}

	private void initializePages() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		sfdc_Login = new SFDC_Login(driver);
		sfdc_Home = new SFDC_Home(driver);
		sfdc_Accounts = new SFDC_Accounts(driver);
	}

	public boolean login_to_portal_as_backoffice_user(String user_full_name) {

		log.info("--------------------------------------------------------------------------------------");
		if (login_to_sfdc_backoffice_as_system_admin()) {
			if (search_text_in_sfdc_backoffice(user_full_name)) {
				if (open_ltc_portal_for_account()) {
					log.info("Logged in successfully into LTC Portal as a System Administrator to user account : "
							+ user_full_name);
					log.info("--------------------------------------------------------------------------------------");
					interaction.waitForSeconds(5);

					return true;
				}
			}
		} else {
			log.error("Element not found for sfdc_home.tab_accounts");
		}

		return false;
	}

	private boolean login_to_sfdc_backoffice_as_system_admin() {
		String urlLink = TestUtility
				.getValueFromSettings(AppVariables.ENVIRONMENT + Constants.UNDERSCORE + "SFDC_BACKOFFICE_LOGIN_URL");
		String sfdc_username = TestUtility.getValueFromSettings(
				AppVariables.ENVIRONMENT + Constants.UNDERSCORE + "SFDC_BACKOFFICE_LOGIN_SYS_ADMIN_USERNAME");
		String sfdc_password = TestUtility.getValueFromSettings(
				AppVariables.ENVIRONMENT + Constants.UNDERSCORE + "SFDC_BACKOFFICE_LOGIN_SYS_ADMIN_PASSWORD");

		if (TestUtility.openEnvironmentURL(urlLink)) {
			if (interaction.waitForElement(sfdc_Login.page_title_logo)) {
				interaction.highlightElement(sfdc_Login.page_title_logo, true);
				interaction.setTextElement(sfdc_Login.username, sfdc_username);
				interaction.setTextElement(sfdc_Login.password, sfdc_password);
				interaction.clickWebElement(sfdc_Login.login_button);
			}

			if (interaction.waitForElement(sfdc_Home.page_title_logo)) {
				interaction.highlightElement(sfdc_Home.page_title_logo, true);
				log.info("Logged in successfully into SFDC Backoffice as a System Administrator");
				return true;
			} else {
				log.error("Unable to locate page_title_logo of SFDC Backoffice Homepage !! ");
			}
		} else
			log.error("Error occured in opening url.");
		return false;
	}

	public boolean search_text_in_sfdc_backoffice(String user_full_name /* ,tabName */) {
		boolean isTabVisible = false, resultStatus = false;
		Driver driver = DriverManager.getInstance().getWebDriver();

		// Verifying Tab visibility of Accounts Tab
		if (interaction.isElementVisible(interaction.waitForElementToBeClickable(sfdc_Home.tab_Home))) {
			interaction.highlightElement(sfdc_Home.tab_Home, true);

			if (interaction.isElementVisible(interaction.waitForElementToBeClickable(sfdc_Home.tab_accounts))) {
				interaction.highlightElement(sfdc_Home.tab_accounts, true);
				isTabVisible = true;
			} else {
				log.error("Unable to locate tab : Accounts");
			}
		} else {
			log.error("Unable to locate tab : Home");
		}

		if (isTabVisible) {
			interaction.clickWebElementByJS(sfdc_Home.tab_accounts);

			if (interaction.isElementVisible(interaction.waitForElementToBeClickable(sfdc_Home.searchbox))) {
				interaction.clickWebElement(sfdc_Home.searchbox);
				interaction.setTextElement(sfdc_Home.searchbox, user_full_name);

				WebElement searchList_item = driver.findElement(By.xpath("// *[contains(text(),'\"" + user_full_name
						+ "\" in " + sfdc_Home.tab_identifier_text.getText() + "')]//parent::a"));

				if (interaction.isElementVisible(searchList_item)) {
					log.info("Located the search result in result dropdown list");
					interaction.clickWebElement(searchList_item);

					if (interaction.isElementVisible(
							interaction.waitForElementToBeClickable(sfdc_Home.search_result_table_first_item))) {
						log.info("Located the search result in results page");
						interaction.clickWebElement(sfdc_Home.search_result_table_first_item);
						resultStatus = true;
					} else {
						log.error("Unable to locate search reults on results page.");
					}
				} else {
					log.error("Unable to locate search result in results dropdown.");
				}
			} else {
				log.error("Unable to locate searchox !!");
			}
		}
		return resultStatus;
	}

	public boolean open_ltc_portal_for_account() {
		if (interaction.waitForElement(sfdc_Accounts.tab_identifier_text)) {
			log.info("Accounts Layout is loaded.");
			if (interaction.clickWebElement(sfdc_Accounts.options_dropdown_link)) {
				interaction.clickWebElement(sfdc_Accounts.option_login_to_community_as_user);
				return true;
			} else
				log.error("Unable to locate dropdown link for options_dropdown_link.");
		}
		log.error("Accounts Layout is not loaded.");
		return false;
	}

}
