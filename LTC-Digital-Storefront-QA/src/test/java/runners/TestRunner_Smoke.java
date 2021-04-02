package runners;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = {
		"step_definitions" }, monochrome = true, dryRun = false, plugin = { "pretty", "summary",
				"html:target/cucumber-reports/cucumber-pretty", "json:target/cucumber-reports/CucumberTestReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },

		tags =
		// "@Registration and @Insured"
		"Digital_Payments"
// tags = "@PROD and @MyDashboardViaDashboardURL"
// tags = "@STAGE and @MyDashboardViaLTC and @UserWithOnlyLTCPolicy"
// tags = "@STAGE and @MyDashboardViaLTC and @UserWithLifeAndLTCPolicies"
// tags = "@STAGE and @MyDashboardViaDashboardURL and @UserWithOnlyLTCPolicy"
// tags = "@STAGE and @MyDashboardViaDashboardURL and
// @UserWithLifeAndLTCPolicies"

// tags = "@GROUP_PASSCODE"
)

public class TestRunner_Smoke extends AbstractTestNGCucumberTests {

	@Override
	@DataProvider(parallel = false)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}
