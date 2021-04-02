package step_definitions;

import org.testng.Assert;

import base.BackofficeContext;
import io.cucumber.java.en.When;

public class StepDef_Backoffice {

	private BackofficeContext context;

	public StepDef_Backoffice(BackofficeContext context) {
		this.context = context;
	}

	@When("I login to LTC DIgital Sorefront via Backoffice with user {string}")
	public void i_login_to_ltc_d_igital_sorefront_via_backoffice_with_user(String user_full_name) {
		Assert.assertTrue(context.login_to_portal_as_backoffice_user(user_full_name),
				"All claims for user are not displayed as expected");
		
	}
	
}
