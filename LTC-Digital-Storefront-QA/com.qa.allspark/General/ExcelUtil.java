package General;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import factory.pageobjects.Invoice_Nursing_Home;

public class ExcelUtil {

	private static Properties excelQuery;
	private static Properties settings;

	public ExcelUtil() {
		excelQuery = ExcelQuery.getInstance();
		settings = Settings.getInstance();
	}

	public Invoice_Nursing_Home getNursingHomeInvoiceTestData(String scenarioName) {

		Invoice_Nursing_Home invoice_Nursing_Home = new Invoice_Nursing_Home();
		try {
			ArrayList<String> invoiceFields = new ArrayList<String>();

			String filepath = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ settings.getProperty("INVOICE_DATA");
			Recordset recordset = runQueryInExcel(
					frameQuery(excelQuery.getProperty("GET_NURSING_HOME_INVOICE_TEST_DATA"), scenarioName), filepath);

			invoiceFields = recordset.getFieldNames();

			for (String currentField : invoiceFields) {
				System.out.println(currentField + " = " + recordset.getField(currentField));
				// invoice_Nursing_Home.setAttribute(currentField,
				// recordset.getField(currentField));
			}
		} catch (FilloException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return invoice_Nursing_Home;

	}

	public static String getValueFromExcel(String invoiceType, String scenarioName) {
		String propertyValue = "";

		/*
		 * String filepath = "";
		 * 
		 * 
		 * String query = excelQuery.getProperty(invoiceType); if
		 * (invoiceType.contains("NURSING_HOME")) {
		 * 
		 * } propertyValue = runQueryInExcel(frameQuery(query, tableName, propertyName),
		 * filepath, "Property_Value"); // }
		 */ return propertyValue;

	}

	@SuppressWarnings("unused")
	private static String frameQuery(String query, String fieldName) {
		String finalQuery = query.replaceAll("#1", fieldName);
		System.out.println("final Query::" + finalQuery);
		return finalQuery;
	}

	private static String frameQuery(String query, String tablename, String fieldName) {
		String finalQuery = query.replace("$1", tablename);
		finalQuery = finalQuery.replace("$2", fieldName);
		System.out.println("final Query::" + finalQuery);
		return finalQuery;
	}

	private static String runQueryInExcel(String query, String excelpath, String fieldName) {
		Fillo fillo = new Fillo();
		Connection connection;
		try {
			connection = fillo.getConnection(excelpath);
			Recordset recordset = connection.executeQuery(query);
			while (recordset.next()) {
				return (recordset.getField(fieldName));
			}
			recordset.close();
			connection.close();
		} catch (FilloException e) {
			e.printStackTrace();
		}
		return "";
	}

	private static Recordset runQueryInExcel(String query, String excelpath) {
		Fillo fillo = new Fillo();
		Connection connection;
		try {
			connection = fillo.getConnection(excelpath);
			Recordset recordset = connection.executeQuery(query);

			// recordset.close();
			connection.close();
			return recordset;
		} catch (FilloException e) {
			e.printStackTrace();
		}
		return null;
	}
}
