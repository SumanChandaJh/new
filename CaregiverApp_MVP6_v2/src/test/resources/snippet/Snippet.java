package snippet;

public class Snippet {
	
	
	@AfterTest
	private void test() {
		generateCustomReports();
		copyReportsFolder();
	}
	
	private void generateCustomReports() {
	
		CucumberResultsOverview results1 = new CucumberResultsOverview();
		results1.setOutputDirectory("target");
		results1.setOutputName("cucumber-results");
		results1.setSourceFile("target/cucumber-report/Regresssion/cucumber.json");
		try {
			results1.executeFeaturesOverviewReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		CucumberDetailedResults detailedResults = new CucumberDetailedResults();
		detailedResults.setOutputDirectory("target");
		detailedResults.setOutputName("cucumber-results");
		detailedResults.setSourceFile("target/cucumber-report/Regresssion/cucumber.json");
		detailedResults.setScreenShotLocation("./screenshot");
		try {
			detailedResults.executeDetailedResultsReport(false, true);
		} catch (Exception e) {
	
			e.printStackTrace();
		}
	
	}
	
	private void copyReportsFolder() {
	
		String timeStampResultPath = TimeStamp.getInstance();
	
		File sourceCucumber = new File(Util.getTargetPath());
	
		File destCucumber = new File(timeStampResultPath);
	
		try {
			FileUtils.copyDirectory(sourceCucumber, destCucumber);
			try {
				FileUtils.cleanDirectory(sourceCucumber);
			} catch (Exception e) {
	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		TimeStamp.reportPathWithTimeStamp = null;
	
	}
	
	@AfterSuite
	private void copyStoredReports() {
		// Any customizations after execution can be added here
	}
	
	
}

