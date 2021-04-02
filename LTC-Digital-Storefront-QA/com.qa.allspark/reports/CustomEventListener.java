package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Given;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.cucumber.core.plugin.Options.Plugin;
import io.cucumber.plugin.EventListener;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCaseStarted;
import io.cucumber.plugin.event.TestRunFinished;
import io.cucumber.plugin.event.TestRunStarted;
import io.cucumber.plugin.event.TestSourceRead;
import io.cucumber.plugin.event.TestStepFinished;
import io.cucumber.plugin.event.TestStepStarted;
import io.cucumber.plugin.event.HookTestStep;
import java.util.HashMap;
import java.util.Map;

public class CustomEventListener implements EventListener, Plugin {
	private ExtentSparkReporter spark;
	private ExtentReports extentReport;
	Map<String, ExtentTest> feature = new HashMap<String, ExtentTest>();
	ExtentTest scenario;
	ExtentTest step;
	String path;

	public CustomEventListener() {
	}

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, this::runStarted);
		publisher.registerHandlerFor(TestRunFinished.class, this::runFinished);
		publisher.registerHandlerFor(TestSourceRead.class, this::featureRead);
		publisher.registerHandlerFor(TestCaseStarted.class, this::ScenarioStarted);
		publisher.registerHandlerFor(TestStepStarted.class, this::stepStarted);
		publisher.registerHandlerFor(TestStepFinished.class, this::stepFinished);
	};

	private void runStarted(TestRunStarted event) {
		spark = new ExtentSparkReporter("./ExtentReportResults.html");
		extentReport = new ExtentReports();

		spark.config().setDocumentTitle("New Report");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setReportName("HCD Digital Storefront Automation Report");

		// spark.start(null);

		extentReport = new ExtentReports();
		extentReport.attachReporter(spark);
		extentReport.setSystemInfo("Author", System.getProperty("user.name"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
	};

	private void runFinished(TestRunFinished event) {
		extentReport.flush();
	};

	private void featureRead(TestSourceRead event) {

		String featureSource = event.getUri().toString();
		String featureName = featureSource.split(".*/")[1];
		if (feature.get(featureSource) == null) {
			feature.putIfAbsent(featureSource, extentReport.createTest(featureName));
		}

	};

	private void ScenarioStarted(TestCaseStarted event) {
		String featureName = event.getTestCase().getUri().toString();
		scenario = feature.get(featureName).createNode(event.getTestCase().getName());
	}

	private void stepFinished(TestStepFinished event) {
		if (event.getResult().getStatus().toString() == "PASSED") {
			step.log(Status.PASS, "This passed");

		} else if (event.getResult().getStatus().toString() == "SKIPPED") {
			step.log(Status.SKIP, "This step was skipped ");
		} else {
			step.log(Status.FAIL, "This failed");
		}
	};

	// step started event
	// here we creates the test node
	private void stepStarted(TestStepStarted event) {
		String stepName = " ";
		String keyword = "Triggered the hook :";
		if (event.getTestStep() instanceof PickleStepTestStep) {
			PickleStepTestStep steps = (PickleStepTestStep) event.getTestStep();
			stepName = steps.getStep().getText();
			keyword = steps.getStep().getKeyword();
		} else {
			HookTestStep hoo = (HookTestStep) event.getTestStep();
			stepName = hoo.getHookType().name();
		}
		step = scenario.createNode(Given.class, keyword + " " + stepName);
	}

	@Override
	public String argument() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class<? extends io.cucumber.plugin.Plugin> pluginClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String pluginString() {
		// TODO Auto-generated method stub
		return null;
	};
}