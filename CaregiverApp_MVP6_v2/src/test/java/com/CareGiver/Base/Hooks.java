package com.CareGiver.Base;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;/*
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.CareGiver.supportLibraries.Util;
import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;*/

public class Hooks {

	/*
	 * @AfterStep public void commonSteps() {
	 * System.out.println("This is AfterStep"); }
	 */

	/*
	 * public void afterScenario(Scenario scenario) { if (scenario.isFailed()) {
	 * String screenshotName = scenario.getName().replaceAll(" ", "_"); try { //
	 * This takes a screenshot from the driver at save it to the // specified
	 * location File sourcePath = ((TakesScreenshot)
	 * Base.webDriver).getScreenshotAs(OutputType.FILE);
	 * 
	 * // Building up the destination path for the screenshot to save // Also make
	 * sure to create a folder 'screenshots' with in the // cucumber-report folder
	 * File destinationPath = new File( Util.getAbsolutePath() +
	 * "/target/extent-reports/screenshots/" + screenshotName + ".png");
	 * 
	 * // Copy taken screenshot from source location to destination // location
	 * FileUtils.copyFileToDirectory(sourcePath, destinationPath);
	 * 
	 * // This attach the specified screenshot to the test
	 * Reporter.addScreenCaptureFromPath(destinationPath.toString()); } catch
	 * (IOException e) { e.printStackTrace(); } } }
	 */
}
