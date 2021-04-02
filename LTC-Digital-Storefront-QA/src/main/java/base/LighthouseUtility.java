package base;

import org.apache.log4j.Logger;

import com.proHar.perfoMeasure.main.LightHouse;
import com.proHar.perfoMeasure.main.exceptions.ApplicationInactiveException;
import com.proHar.perfoMeasure.main.exceptions.AppplicationUserInactiveException;
import com.proHar.perfoMeasure.main.exceptions.NoApplicationAccessException;
import com.proHar.perfoMeasure.main.exceptions.NoExistingTestCaseOrApplicationNameFoundLightHouseException;

import factory.driver.Driver;
import support.businesslogic.AppVariables;

public class LighthouseUtility {

	private static Logger log = Logger.getLogger(LighthouseUtility.class);

	public static boolean invokeLighthouse(Driver driver) {
		boolean invokePerformance = true;
		log.info("Scenario Name : " + AppVariables.current_scenario.getName());
		if (invokePerformance) {
			// log.info("Scenario Name : " + AppVariables.current_scenario.getName());
			try {

				// Step 1 : Instantiate Performer class
				LightHouse ap = new LightHouse();
				// Step 2 : Set Domain(PRD/MLID) and provide API KEY
				ap.SetDomainName("MLID");
				// Step 3 : Set API KEY(User Specific)
				ap.SetApiKey("1927FTMZxNaTCfmSLUeFlp0P6236");

				// Step 4 : Unique test case name, Ex: mentioned here(please use the test
				// cases that are registered to the server)
				String testcase = AppVariables.current_scenario.getName();

				ap.Performer(driver.driver, testcase);
				return true;

			} catch (ClassNotFoundException | NoExistingTestCaseOrApplicationNameFoundLightHouseException
					| NoApplicationAccessException | InterruptedException | AppplicationUserInactiveException
					| ApplicationInactiveException e) {
				// e.printStackTrace();
				log.error("Exception Occured !!");
			}
		}
		return false;
	}
}
