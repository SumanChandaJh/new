package step_definitions;

import org.testng.Assert;

import base.FlyoutContext;
import io.cucumber.java.en.Then;

public class StepDefinition_Policies {

	private FlyoutContext testContext;

	public StepDefinition_Policies(FlyoutContext testContext) {
		this.testContext = testContext;
	}

	@Then("^I see sections of all the Policies on which \"([^\"]*)\" has party roles with Policy Number, Status and View Details Link$")
	public void i_see_sections_of_all_the_Policies_on_which_has_party_roles_with_Policy_Number_Status_and_View_Details_Link(
			String user_full_name) throws Throwable {
		Assert.assertTrue(testContext.policyFlyoutPage.verifyFlyoutContent(user_full_name),
				"All policies for user are notdisplayed as expected");
	}

}
