package base;

import java.text.SimpleDateFormat;
import java.util.Date;

import General.ExcelUtil;
import factory.pageobjects.Invoice_Nursing_Home;

public class TestSnippet {

	public static void main(String[] args) {
		/*
		 * Policy policy = FileOps_Common.getDetailsForPolicy("5764855");
		 * policy.printPolicyDetails();
		 */

		// System.out.println(FileOps_Common.getInsuredForPolicy("5764855"));

		/*
		 * String a = TestUtility.generateDynamicContent("Claim #1 for Coverage ID: #2",
		 * "10000032", "P16380"); System.out.println(a);
		 */

		/*
		 * String OTP = SMSManager.getInstance().getOTP(); System.out.println(OTP);
		 */

		ExcelUtil excelUtil = new ExcelUtil();
		Invoice_Nursing_Home home = excelUtil
				.getNursingHomeInvoiceTestData("Submit Invoice Form - Nuursing Home - With Individual Charges");

		

		/*
		 * ArrayList<Policy> listPolicies = new ArrayList<Policy>(); listPolicies =
		 * FileOps_Common.readPolicyForUser("R15insured_Jonny R15insured_Bairstow");
		 * listPolicies = DataUtility.sortPolicyList(listPolicies); for (Policy p :
		 * listPolicies) { p.printPolicyDetails(); }
		 * 
		 * String propertyValue = "#1 long-term care"; String dynamic_string =
		 * propertyValue.replaceAll("#1", "R15insured_Jonny R15insured_Bairstow");
		 * System.out.println(dynamic_string);
		 */

	}
}
