package base;

import org.apache.log4j.Logger;

import General.Interaction;
import factory.driver.Driver;
import factory.driver.DriverManager;
import factory.pageobjects.CustomerRegistrationPage;
import support.businesslogic.AppVariables;

public class RegistrationContext {
	private static Logger log = Logger.getLogger(RegistrationContext.class);
	public CustomerRegistrationPage customerRegistrationPage;
	public Interaction interaction;

	public RegistrationContext() {
		interaction = Interaction.getInstance();
		initializePages();
	}

	private void initializePages() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		customerRegistrationPage = new CustomerRegistrationPage(driver);
	}

	public boolean checkBlueRibbonTitle(String page_title_string) {
		return TestUtility.compareText(customerRegistrationPage.BlueRibbon_Title, page_title_string, true);
	}

	public boolean selectRegistrationRole(String role) {
		interaction.selectValueFromDropdown(customerRegistrationPage.Registrant_Role_dropdown, role);
		return true;
	}

	public boolean verifySuccessfulRegistrationMessage() {
		try {
			interaction.waitForSeconds(10);

			if (interaction.waitForElement(customerRegistrationPage.Error_Message_Text)) {
				interaction.highlightElement(customerRegistrationPage.Error_Message_Text, false);

				return false;
			} else {
				if (interaction.waitForElement(customerRegistrationPage.Success_Message_Text)) {
					interaction.highlightElement(customerRegistrationPage.Success_Message_Text, true);
					return true;
				}
			}

		} catch (Exception e) {
			if (interaction.waitForElement(customerRegistrationPage.Error_Message_Text)) {
				interaction.highlightElement(customerRegistrationPage.Error_Message_Text, false);
				return false;
			}
		}
		return false;
	}
}
