package base;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import General.Settings;
import factory.dataobjects.PremiumPayment;
import factory.driver.DriverManager;
import support.businesslogic.Constants;

public class TestUtility {
	static Logger log;
	static Properties properties;
	private static String projectPath;

	static {
		log = Logger.getLogger(TestUtility.class);
		properties = Settings.getInstance();
		projectPath = new File(System.getProperty("user.dir")).getAbsolutePath();
	}

	public static String addUsernameSuffix(String party_full_name) {
		if (party_full_name.endsWith("s")) {
			return party_full_name + Constants.SUFFIX_WITHOUT_APPSOTROHE;
		}
		return party_full_name + Constants.SUFFIX_WITH_APPSOTROHE;
	}

	public static boolean compareDynamicText(WebElement element, String property_name, String dynamic_text,
			boolean isProperty) {

		log.info("Comparing texts for :" + property_name);
		String actual_page_title = formatString(element.getText().toString());
		String expected_page_title;
		if (isProperty) {
			expected_page_title = generateDynamicContent(getValueFromSettings(property_name), dynamic_text);
		} else {
			expected_page_title = generateDynamicContent(property_name, dynamic_text);
		}

		log.info("Expected Text : " + expected_page_title);
		log.info("Actual Text : " + actual_page_title);

		if (actual_page_title.contentEquals(expected_page_title)) {
			log.info("Text for " + property_name + " match.");
			return true;
		} else {
			log.error("Text for " + property_name + " do not match.");
			return false;
		}
	}

	public static boolean compareDynamicText(WebElement element, String property_name, String dynamic_text1,
			String dynamic_text2, boolean isProperty) {

		log.info("Comparing texts for :" + property_name);
		String actual_page_title = formatString(element.getText().toString());
		String expected_page_title;
		if (isProperty) {
			expected_page_title = generateDynamicContent(getValueFromSettings(property_name), dynamic_text1,
					dynamic_text2);
		} else {
			expected_page_title = generateDynamicContent(property_name, dynamic_text1, dynamic_text2);
		}

		log.info("Expected Text : " + expected_page_title);
		log.info("Actual Text : " + actual_page_title);

		if (actual_page_title.contentEquals(expected_page_title)) {

			log.info("Text for " + property_name + " match.");
			return true;
		} else {
			log.error("Text for " + property_name + " do not match.");
			return false;
		}
	}

	public static boolean compareText(WebElement page_title_element, String page_title_string, boolean isProperty) {

		log.info("Comparing texts for :" + page_title_string);
		String actual_page_title = formatString(page_title_element.getText().toString());
		String expected_page_title;
		if (isProperty) {
			expected_page_title = getValueFromSettings(page_title_string);
		} else {
			expected_page_title = page_title_string;
		}

		log.info("Expected Text : " + expected_page_title);
		log.info("Actual Text   : " + actual_page_title);

		if (actual_page_title.contentEquals(expected_page_title)) {
			log.info("Text for " + page_title_string + " match.");
			return true;
		} else {
			log.error("Text for " + page_title_string + " do not match.");
			return false;
		}
	}

	public static boolean compareTextContains(WebElement page_title_element, String page_title_string,
			boolean isProperty) {

		log.info("Comparing texts for :" + page_title_string);
		String actual_page_title = page_title_element.getText().toString();
		String expected_page_title;
		if (isProperty) {
			expected_page_title = getValueFromSettings(page_title_string);
		} else {
			expected_page_title = page_title_string;
		}

		log.info("Expected Text : " + expected_page_title);
		log.info("Actual Text : " + actual_page_title);

		if (actual_page_title.contains(expected_page_title)) {
			log.info("Text for " + page_title_string + " match.");
			return true;
		} else {
			log.error("Text for " + page_title_string + " do not match.");
			return false;
		}
	}

	/**
	 * Return formatted string after removing extra spaces and new lines from the
	 * string
	 * 
	 * @param inputStr
	 *            - String
	 * @return
	 */
	public static String formatString(String inputStr) {
		String formattedStr = null;

		if (inputStr != null) {
			formattedStr = inputStr.replaceAll("\n", " ").replaceAll("\\s+", " ").replaceAll("  ", " ").trim();
		} else {
			formattedStr = null;
		}

		System.out.println("Derived formattedStr:" + formattedStr);
		return formattedStr;
	}

	public static String generateDynamicContent(String fetched_string, String dynamic_text) {
		String dynamic_string = fetched_string.replaceAll("#1", dynamic_text);
		log.info("GENERATED DYNAMIC TEXT : " + dynamic_string);
		return dynamic_string;
	}

	public static String generateDynamicContent(String fetched_string, String dynamic_text1, String dynamic_text2) {
		String temp_dynamic_string = fetched_string.replaceAll("#1", dynamic_text1);
		String dynamic_string = temp_dynamic_string.replaceAll("#2", dynamic_text2);
		log.info("GENERATED DYNAMIC TEXT : " + dynamic_string);
		return dynamic_string;
	}

	public static String getCurrentDateAndTimeStamp() {
		String timestamp = "";
		DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
		Date date = new Date();
		timestamp = format.format(date);
		timestamp = timestamp.replaceAll(" ", "").replaceAll("/", "").replaceAll(":", "");
		return timestamp;
	}

	/**
	 * Function to get the separator string to be used for directories and files
	 * based on the current OS
	 * 
	 * @return The file separator string
	 */
	public static String getFileSeparator() {
		return System.getProperty("file.separator");
	}

	@SuppressWarnings("unused")
	public static String getReportConfigPath() {
		String reportConfigPath = projectPath + properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public static String getValueFromSettings(String urlString) {
		if (isNotNullAndEmpty(urlString)) {
			log.info("Fetching property value for : " + urlString);
			return properties.getProperty(urlString);
		}
		return new String();
	}

	public static boolean isNotNullAndEmpty(String string) {
		if (string != null) {
			if (!string.isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean openEnvironmentURL(String urlFromProperties/* , Driver driver */) {
		if (TestUtility.isNotNullAndEmpty(urlFromProperties)) {
			log.info("Opening URL : " + urlFromProperties);
			DriverManager.getInstance().getWebDriver().get(urlFromProperties);
			log.info("Opened URL successfully");
			return true;
		} else {
			log.info("Empty url to open.");
			return false;
		}
	}

	private TestUtility() {
		// to avoid instantiation
	}

	/**
	 * Replace row number in the Xpath string and return the replaced string
	 * 
	 * @param Xpath
	 * @param rowNum
	 * @return String
	 */
	public static String getDynamicCellXpath(String Xpath, String rowNum) {
		String finalXpath = null;

		Pattern r = Pattern.compile(Constants.XPATH_PATTERN3);
		Matcher m = r.matcher(Xpath);
		StringBuffer sb = new StringBuffer();

		while (m.find()) {
			m.appendReplacement(sb, m.group(0).replaceAll(Pattern.quote(m.group(1)), rowNum));
		}

		m.appendTail(sb);
		finalXpath = sb.toString();

		return finalXpath;
	}

	public static ArrayList<PremiumPayment> getFilteredPaymentList(List<PremiumPayment> list_payments,
			String payment_Year) {

		ArrayList<PremiumPayment> list_filteredPayments = new ArrayList<PremiumPayment>();
		// Date currentDate = Reusable.convertStringToDate(Reusable.getCurrentDate());

		for (int index = 0; index < list_payments.size(); index++) {
			PremiumPayment currentPayment = list_payments.get(index);
			String currentPaymentDate = currentPayment.getPaymentDate();
			Date Date_currentPayment = null;

			if (!(currentPaymentDate.isEmpty())) {
				Date_currentPayment = convertStringToDate(currentPaymentDate);
				// if (Date_currentPayment != null) {
				Calendar calendar = new GregorianCalendar();
				calendar.setTime(Date_currentPayment);
				String currentDateYear = String.valueOf(calendar.get(Calendar.YEAR));
				if (currentDateYear.equalsIgnoreCase(payment_Year)) {
					list_filteredPayments.add(currentPayment);
				}
				/*
				 * if (Date_currentPayment.compareTo(currentDate) >= 0) {
				 * list_filteredPayments.add(currentPayment); }
				 */
			}
		}
		System.out.println("Filtered Payment List Size : " + list_filteredPayments.size());
		return list_filteredPayments;
	}

	public static Date convertStringToDate(String dateString) {

		String format = "MM/dd/yyyy";

		try {
			if (!dateString.isEmpty()) {

				SimpleDateFormat dateFormat = new SimpleDateFormat(format);
				Date date = dateFormat.parse(dateString);

				return date;
			} else {
				return null;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to Convert the date -" + dateString + ". Format should be '" + format + "'");
		}

		return null;
	}

	public static String removeHTMLContent(String textToSet) {
		String password = "";
		password = textToSet.replaceAll("&hash;", "#");
		return password;
	}

	public static ArrayList<String> convertToArrayList(String property) {
		String[] fieldArray = property.split(";");
		ArrayList<String> fieldList = new ArrayList<>();

		for (String currentListItem : fieldArray) {
			fieldList.add(currentListItem);
		}
		return fieldList;
	}
}
