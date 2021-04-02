package step_definitions;

import org.testng.Assert;

import base.FlyoutContext;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDef_Claims {

	private FlyoutContext context;

	public StepDef_Claims(FlyoutContext context) {
		this.context = context;
	}

	@Then("I see sections of all the policies with claims on which {string} has party role with Policy and Claim Details")
	public void i_see_sections_of_all_the_policies_with_claims_on_which_has_party_role_with_policy_and_claim_details(
			String user_full_name) {
		Assert.assertTrue(context.claimsFlyoutPage.verifyFlyoutContent(user_full_name),
				"All claims for user are not displayed as expected");
	}

	@When("I select claim {string} from available claims list for policy {string}")
	public void i_select_claim_from_available_claims_list_for_policy(String claimToSelect, String policyNumber) {
	
		Assert.assertTrue(context.claimsFlyoutPage.selectClaim(policyNumber, claimToSelect),
				"Unable to select claim : " + claimToSelect + " from available claim list.");
	}

}
