package General;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Singleton class that encapsulates the user settings specified in the
 * properties file of the framework
 * 
 * @author Cognizant
 */
public class Settings {

	private static Properties properties = loadFromPropertiesFile();
	static Logger log = Logger.getLogger(Settings.class);

	public static Properties getInstance() {
		return properties;
	}

	private static Properties loadFromPropertiesFile() {
		Properties properties = new Properties();
		String relativePath = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ "/resources/data-properties/global-settings.properties";
		try {
			properties.load(new FileInputStream(relativePath));
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		return properties;
	}

	// To prevent external instantiation of this class
	private Settings() {
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}