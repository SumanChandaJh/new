package com.CareGiver.TestNGrunners;

import java.io.File;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.CareGiver.Base.Base;
import com.CareGiver.supportLibraries.Util;
import com.cucumber.listener.Reporter;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@ExtendedCucumberOptions(

		jsonReport = "target/cucumber-report/Smoke/cucumber.json", jsonUsageReport = "target/cucumber-report/Smoke/cucumber-usage.json", outputFolder = "target/cucumber-report/Smoke", detailedReport = true, detailedAggregatedReport = true, overviewReport = true, usageReport = true)

/**
 * Please notice that com.CucumberCraft.stepDefinations.CukeHooks class is in
 * the same package as the steps definitions. It has two methods that are
 * executed before or after scenario. I'm using it to delete cookies and take a
 * screenshot if scenario fails.
 */
@CucumberOptions(

		features = "src/test/java/com/CareGiver/features", glue = { "src/test/java/com/CareGiver/StepDemo" }, tags = {
				"@Demo" }, monochrome = true, dryRun = false, plugin = { "pretty",
						"pretty:target/cucumber-report/Smoke/pretty.txt", "html:target/cucumber-report/Smoke",
						"json:target/cucumber-report/Smoke/cucumber.json",
						"junit:target/cucumber-report/Smoke/cucumber-junitreport.xml",
						// "ru.yandex.qatools.allure.cucumberjvm.AllureReporter",
						"com.cucumber.listener.ExtentCucumberFormatter:target/extent-report/report.html" })
public class RunCucumberTests_DEMO extends AbstractTestNGCucumberTests {

	@AfterTest
	private void test() {
		System.out.println("============= After Test ============");
		System.out.println("In DEMO");
	}

	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(Util.getExtentConfigPath()));
		Reporter.assignAuthor("Cognizant");
		// System.err.println("manufacturer:"+Base.manufacturer);
		// Reporter.setSystemInfo("Cloud Platform",
		// Base.getSystemInfo("CloudPlatform"));
		Reporter.setSystemInfo("Mobile OS Version", Base.getSystemInfo("MobileOSversion"));
		Reporter.setSystemInfo("Model Name", Base.getSystemInfo("ModelName"));
		Reporter.setSystemInfo("Device Id", Base.getSystemInfo("DeviceId"));
		Reporter.setSystemInfo("OS", Base.platform.toUpperCase());

	}

	@AfterSuite
	private void copyStoredReports() {

		// Any customizations after execution can be added here
	}

}
