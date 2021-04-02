package support.fileoperations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import General.Settings;
import factory.dataobjects.CompareByPaymentDate;
import factory.dataobjects.PremiumPayment;

public class FileOps_Payment {

	private static String filePath;
	private static String projectPath = new File(System.getProperty("user.dir")).getAbsolutePath();
	private static Properties settings = Settings.getInstance();

	public static ArrayList<PremiumPayment> readPremiumsForPolicy(String policyNumber) {
		String policy_Number = null;
		ArrayList<PremiumPayment> premPaymentList = new ArrayList<PremiumPayment>();
		int found = 0;
		try {
			filePath = projectPath + settings.getProperty("PREMIUM_PAYMENT_DATA");
			FileInputStream fileIn;
			fileIn = new FileInputStream(new File(filePath));
			XSSFSheet sheet = new XSSFWorkbook(fileIn).getSheetAt(0);

			int Index_policyNumber = FileOps_Common.getColumnIndex("POLICY_NUM", filePath);
			int Index_premiumPaid = FileOps_Common.getColumnIndex("PREMIUM_PAID", filePath);
			int Index_paymentType = FileOps_Common.getColumnIndex("PAYMENT_TYPE", filePath);
			int Index_paymentDate = FileOps_Common.getColumnIndex("PAYMENT_DT", filePath);

			Iterator<Row> rowIterator = sheet.iterator();
			DataFormatter formatter = new DataFormatter();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				policy_Number = formatter
						.formatCellValue(row.getCell(Index_policyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));
				PremiumPayment premPayment = new PremiumPayment();

				if (policy_Number.equalsIgnoreCase(policyNumber)) {
					premPayment.setPolicyNumber(policyNumber);
					premPayment.setPaymentDate(formatter
							.formatCellValue(row.getCell(Index_paymentDate, MissingCellPolicy.CREATE_NULL_AS_BLANK)));
					premPayment.setPremiumPaid(formatter
							.formatCellValue(row.getCell(Index_premiumPaid, MissingCellPolicy.CREATE_NULL_AS_BLANK)));
					premPayment.setPaymentType(formatter
							.formatCellValue(row.getCell(Index_paymentType, MissingCellPolicy.CREATE_NULL_AS_BLANK)));

					found++;
					premPaymentList.add(premPayment);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (found != 0) {
			System.out.println("Size of Payment List fetched from Excel : " + premPaymentList.size());
			Collections.sort(premPaymentList, new CompareByPaymentDate());
			Collections.reverse(premPaymentList);
			return premPaymentList;
		} else
			return new ArrayList<PremiumPayment>();
	}

}
