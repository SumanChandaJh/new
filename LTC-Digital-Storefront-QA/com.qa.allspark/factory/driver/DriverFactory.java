package factory.driver;

import org.apache.log4j.Logger;

public class DriverFactory {

	private static Logger log = Logger.getLogger(DriverFactory.class);

	public static Driver getInstance(String browserName) {

		Driver driver = null;
		ExecutionMode executionMode = ExecutionMode.valueOf(System.getProperty("MODE", "LOCAL"));

		log.info("Starting Test in Execution Mode : " + executionMode);

		switch (executionMode) {
		case LOCAL:
			driver = new Driver(browserName);
			break;

		case REMOTE:
			log.info("Logic yet to be written.");
			break;
		default:
			break;
		}

		return driver;

	}

	private DriverFactory() {
	}

}
