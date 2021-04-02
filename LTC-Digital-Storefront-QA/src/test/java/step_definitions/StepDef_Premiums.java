package step_definitions;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import base.FlyoutContext;
import base.TabPageContext;

public class StepDef_Premiums {

	private FlyoutContext testContext;
	private TabPageContext tabPageContext;

	public StepDef_Premiums(FlyoutContext testContext, TabPageContext tabPageContext) {
		this.testContext = testContext;
		this.tabPageContext = tabPageContext;

	}

	@And("I click on View Premiums link for the given \"([^\"]*)\" to navigate to Premiums page$")
	public void i_click_on_View_Premiums_Link_for_policy(String polNumber) {
		Assert.assertTrue(testContext.premiumsFlyoutPage.clickPremiumLink(polNumber), "Policy Number not found!!!");
	}

	@Then("I validate Premiums table for \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_validate_premiums_table(String policyNumber, String paymentYear) {
		Assert.assertTrue(
				tabPageContext.premiumPaymentHistory.verifyPremiumPaymentHistoryTableContent(policyNumber, paymentYear),
				"Premiums not matching!");

	}

}
