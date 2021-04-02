package step_definitions;

import org.testng.Assert;
import base.TestContext;
import base.TestUtility;
//import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import support.businesslogic.AppVariables;
import support.businesslogic.Constants;

public class StepDefinition_LoginPage {

	private TestContext testContext;
	private String loginPageType;
	private String pageName;

	// cucumber dependency injection
	public StepDefinition_LoginPage(TestContext testContext) {
		this.testContext = testContext;
	}

	@Given("^I am a registered Portal user$")
	public void i_am_a_registered_Portal_user() throws Throwable {
		testContext.interaction.waitForSeconds(4);
	}

	@When("^I open \"([^\"]*)\" for Digital Storefront Portal$")
	public void i_open_for_Digital_Storefront_Portal(String url) throws Throwable {
		if (url.contains("DASHBOARD")) {
			loginPageType = Constants.LOGIN_TYPE_DASHBOARD;
		} else if (url.contains("LTC")) {
			loginPageType = Constants.LOGIN_TYPE_LTC;
		} else {
			loginPageType = Constants.LOGIN_TYPE_DASHBOARD;
		}
		String urlLink = TestUtility.getValueFromSettings(AppVariables.ENVIRONMENT + Constants.UNDERSCORE + url);
		Assert.assertTrue(TestUtility.openEnvironmentURL(urlLink), "Failed to launch url for " + url);

	}

	@Then("I see {string} as title of the page")
	public void i_see_as_title_of_the_page(String expected_page_title) throws Throwable {
		Assert.assertTrue(testContext.checkHeaderTitle(loginPageType, expected_page_title),
				"Page Title for Login Page is not as expected.");

	}

	@When("^I enter \"([^\"]*)\" in the username field$")
	public void i_enter_in_the_username_field(String textToSet) throws Throwable {
		Assert.assertTrue(testContext.setUsername(loginPageType, textToSet),
				"Failed to set username field to - " + textToSet);
	}

	@When("^I enter \"([^\"]*)\" in password field$")
	public void i_enter_in_password_field(String textToSet) throws Throwable {
		Assert.assertTrue(testContext.setPassword(loginPageType, textToSet),
				"Failed to set password field to - " + textToSet);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void i_click_on_button(String arg1) throws Throwable {
		Assert.assertTrue(testContext.clickLoginButton(loginPageType), "Failed to click button for login.");
	}

	@Then("^I see \"([^\"]*)\" on the page$")
	public void i_see_on_the_page(String page_title_string) throws Throwable {
		
		if (page_title_string.contentEquals("My_Dashboard_Home_Icon")) {
			this.pageName = Constants.HOME_DASHBOARD;
		} else if (page_title_string.contentEquals("LTC_Digital_Storefront_Home_icon")) {
			this.pageName = Constants.HOME_LTC;
		}
		testContext.interaction.waitForSeconds(15);
		Assert.assertTrue(testContext.checkHeaderLogo(pageName, page_title_string),
				"Page Title for Home Page is not visible.");

	}

	@Then("^I see my fullname as \"([^\"]*)\" in the header of the page$")
	public void i_see_my_fullname_as_in_the_header_of_the_page(String fullname) throws Throwable {
		Assert.assertTrue(testContext.verifyLoggedInUsername(pageName, fullname),
				"Profile loaded is different from the peron who logged in.");
	}

	@Then("I see card to manage my policies for my {string} policies")
	public void i_see_card_to_manage_my_policies_for_my_policies(String policyType) {

		Assert.assertTrue(testContext.dashboardHome.verifyDashboardCardVisibility(policyType));
	}

	@When("I enter SF username {string} in username field")
	public void i_enter_sf_username_in_username_field(String username) {
		this.pageName = Constants.HOME_DASHBOARD;
		Assert.assertTrue(testContext.interaction.setTextElement(testContext.sfdc_Login.username, username));
	}

	@When("I enter SF password {string} in password field")
	public void i_enter_sf_password_in_password_field(String password) {
		Assert.assertTrue(testContext.interaction.setTextElement(testContext.sfdc_Login.password, password));
	}

	@When("I click on SF Login button")
	public void i_click_on_sf_login_button() {
		Assert.assertTrue(testContext.interaction.clickWebElement(testContext.sfdc_Login.login_button));
	}

	@When("I select My Dashboard tab")
	public void i_select_my_dashboard_tab() {
		this.pageName = Constants.HOME_DASHBOARD;
		Assert.assertTrue(testContext.interaction.clickWebElement(testContext.homePage.myDashboardTab));
	}
}
