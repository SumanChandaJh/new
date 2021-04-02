package factory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.dataobjects.Policy;
import factory.dataobjects.PremiumPayment;

import base.TestUtility;
import factory.driver.Driver;
import support.businesslogic.AppVariables;
import support.businesslogic.DataUtility;
import support.fileoperations.FileOps_Common;
import support.fileoperations.FileOps_Payment;

public class PremiumPaymentHistory {

	Interaction interaction;
	Driver driver;
	public static Logger log = Logger.getLogger(PremiumPaymentHistory.class);

	@FindBy(xpath = "//div[contains(@class,'cLtcDataTableObject ')]")
	public WebElement Payment_History_Table;

	@FindBy(xpath = "//a[@class='tableControl']")
	public WebElement Next_Button;

	@FindBy(xpath = "//c-ltc-select//ul")
	public List<WebElement> Select_Year_Elements;

	@FindBy(xpath = "//c-ltc-select")
	public WebElement Select_Year;

	public String Date_Received = "//div[contains(@class,'cLtcDataTableObject')]//tbody/tr[$1]/td[1]/span/span";
	public String Payment_Type = "//div[contains(@class,'cLtcDataTableObject')]//tbody/tr[$1]/td[2]/span";
	public String Premium_Paid = "//div[contains(@class,'cLtcDataTableObject')]//tbody/tr[$1]/td[3]/span/span";

	@FindBy(xpath = ".//*[contains(text(),'for policy:')]")
	public WebElement Header_Text_Retail_Policy;

	@FindBy(xpath = ".//*[contains(text(),'for Coverage ID:')]")
	public WebElement Header_Text_Group_Policy;

	@FindBy(xpath = ".//h4/parent::*/h1")
	public WebElement SubHeader_Text;

	public PremiumPaymentHistory(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	public boolean verifyPremiumPaymentHistoryTableContent(String policyNumber, String paymentYear) {

		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		ArrayList<PremiumPayment> expectedPaymentList = new ArrayList<PremiumPayment>();
		ArrayList<PremiumPayment> filteredPaymentList = new ArrayList<PremiumPayment>();

		if (!policyNumber.isEmpty()) {
			expectedPaymentList = FileOps_Payment.readPremiumsForPolicy(policyNumber);

		}

		if (paymentYear.equals("All payments")) {
			filteredPaymentList = expectedPaymentList;
		} else {
			filteredPaymentList = TestUtility.getFilteredPaymentList(expectedPaymentList, paymentYear);
			if (interaction.isElementVisible(Select_Year)) {
				interaction.clickWebElement(Select_Year);
				interaction.selectElement(Select_Year_Elements, paymentYear);
			} else
				System.out.println("Year Picklist is not loaded!!!");
		}

		for (PremiumPayment currentPayment : filteredPaymentList) {
			boolean flag = isPaymentRecordFound(currentPayment);
			// matchPremiumPaymentRecords(currentPayment);
			resultList.add(flag);
		}
		if (resultList.contains(false))
			return false;
		else
			return true;

	}

	public int getPaymentHistoryTablePageRowCount() {
		int rowCount = 0;
		if (Payment_History_Table != null) {
			List<WebElement> allRows = Payment_History_Table.findElements(By.tagName("tr"));
			rowCount = allRows.size();
		}
		return rowCount;
	}

	public void matchPremiumPaymentRecords(PremiumPayment expectedPayment, int currentRow) {
		// ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		int rowCount = getPaymentHistoryTablePageRowCount();
		System.out.println("Payment History table rows::" + rowCount);
		/*
		 * for (int currentRow =1; currentRow<=rowCount; currentRow++) {
		 */
		PremiumPayment actualPayment = new PremiumPayment();
		WebElement actualDateReceivedObj = driver
				.findElement(By.xpath(TestUtility.getDynamicCellXpath(Date_Received, Integer.toString(currentRow))));

		WebElement actualPaymentTypeObj = driver
				.findElement(By.xpath(TestUtility.getDynamicCellXpath(Payment_Type, Integer.toString(currentRow))));

		WebElement actualPremiumPaidObj = driver
				.findElement(By.xpath(TestUtility.getDynamicCellXpath(Premium_Paid, Integer.toString(currentRow))));

		if ((actualDateReceivedObj != null) && (actualPaymentTypeObj != null) && (actualPremiumPaidObj != null)) {
			actualPayment.setPaymentDate(actualDateReceivedObj.getText());
			actualPayment.setPaymentType(actualPaymentTypeObj.getText());
			actualPayment.setPremiumPaid(actualPremiumPaidObj.getText().replace("$", ""));
			/*
			 * printPayment(actualPayment); System.out.println("========================");
			 * printPayment(expectedPayment);
			 */
			// resultList.add(validatePremiumPaymentRecords(expectedPayment,actualPayment));
			validatePremiumPaymentRecords(expectedPayment, actualPayment);
		} else
			System.out.println("Unable to get payment information for row number" + currentRow);
		// }
		/*
		 * if (resultList.contains(false)) return false; else return true;
		 */

	}

	private boolean validatePremiumPaymentRecords(PremiumPayment expectedPayment, PremiumPayment actualPayment) {
		/*
		 * for (PremiumPayment currentPayment : expectedPaymentList ) {
		 */
		System.out.println("______________________________________________________________________________\n");
		System.out.println("Actual Payment Details :");
		printPayment(actualPayment);
		System.out.println("Current Payment Details :");
		printPayment(expectedPayment);
		System.out.println("______________________________________________________________________________");

		if ((expectedPayment.getPaymentDate().contentEquals(actualPayment.getPaymentDate()))
				&& ((expectedPayment.getPaymentType().contentEquals(actualPayment.getPaymentType()))
						&& ((expectedPayment.getPremiumPaid().contentEquals(actualPayment.getPremiumPaid())))))
		/*
		 * if
		 * ((currentPayment.getPaymentDate().contentEquals(actualPayment.getPaymentDate(
		 * )))){ if
		 * ((currentPayment.getPaymentType().contentEquals(actualPayment.getPaymentType(
		 * )))){ if
		 * ((currentPayment.getPremiumPaid().contentEquals(actualPayment.getPremiumPaid(
		 * ))))
		 */
		{
			System.out.println("Payment Info matched");
			return true;
		} else
			System.out.println("Payment info not matched!!!!");
		// }
		return false;
	}

	private void printPayment(PremiumPayment payment) {
		System.out.println("Payment Date :" + payment.getPaymentDate());
		System.out.println("Payment Type :" + payment.getPaymentType());
		System.out.println("Premium Paid :" + payment.getPremiumPaid());

	}

	public boolean isPaymentRecordPresentInPage(int tableRowCount, PremiumPayment payment) {

		boolean paymentFound = false;
		int matchedRow;

		String expectedPaymentDate = null;
		String expectedPaymentType = null;
		String expectedPremiumPaid = null;
		String actualPaymentDate = null;
		String actualPaymentType = null;
		String actualPremiumPaid = null;

		if (payment != null) {

			expectedPaymentDate = payment.getPaymentDate();
			expectedPaymentType = payment.getPaymentType();
			expectedPremiumPaid = payment.getPremiumPaid();

		} else {
			System.out.println("No payment details found - Test Data issue");
		}

		if (tableRowCount != -1) {
			for (int currentRowNumber = 1; currentRowNumber < tableRowCount; currentRowNumber++) {
				matchedRow = 0;
				WebElement actualDateReceivedObj = driver.findElement(
						By.xpath(TestUtility.getDynamicCellXpath(Date_Received, Integer.toString(currentRowNumber))));

				WebElement actualPaymentTypeObj = driver.findElement(
						By.xpath(TestUtility.getDynamicCellXpath(Payment_Type, Integer.toString(currentRowNumber))));

				WebElement actualPremiumPaidObj = driver.findElement(
						By.xpath(TestUtility.getDynamicCellXpath(Premium_Paid, Integer.toString(currentRowNumber))));

				if ((actualDateReceivedObj != null) && (actualPaymentTypeObj != null)
						&& (actualPremiumPaidObj != null)) {
					actualPaymentDate = actualDateReceivedObj.getText();
					actualPaymentType = actualPaymentTypeObj.getText();
					actualPremiumPaid = actualPremiumPaidObj.getText().replace("$", "");

					if ((expectedPaymentDate.equalsIgnoreCase(actualPaymentDate))
							&& (expectedPaymentType.equalsIgnoreCase(actualPaymentType))
							&& (expectedPremiumPaid.equalsIgnoreCase(actualPremiumPaid))) {

						System.out.println("Match Found");
						matchedRow = currentRowNumber;
						paymentFound = true;
						System.out.println("**Matched Row::" + matchedRow);
						matchPremiumPaymentRecords(payment, matchedRow);
						break;
					}
				}
			}

		}
		return paymentFound;

	}

	public boolean isPaymentRecordFound(PremiumPayment payment) {
		boolean foundFlag = false;
		// System.out.println("Inside IsPaymentRecordFound");
		printPayment(payment);
		if (isPaymentRecordPresentInPage(getPaymentHistoryTablePageRowCount(), payment)) {
			foundFlag = true;
		} else {

			if (Next_Button != null) {
				interaction.clickWebElement(Next_Button);
				isPaymentRecordFound(payment);
			}
		}
		System.out.println("The flag value is  " + foundFlag);
		return foundFlag;
	}

	public boolean verifyPageHeaders() {
		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		log.info("Policy Number from AppVariables : " + AppVariables.POLICY);
		Policy current_policy = FileOps_Common.getDetailsForPolicy(AppVariables.POLICY);
		// current_policy.printPolicyDetails();
		String propertyName;
		WebElement headerObj;
		if (current_policy != null) {
			if (DataUtility.isGroupPolicy(current_policy)) {
				propertyName = "Premiums_Layout_Group_Policy_Header_Text";
				headerObj = Header_Text_Group_Policy;
			} else {
				propertyName = "Premiums_Layout_Retail_Policy_Header_Text";
				headerObj = Header_Text_Retail_Policy;
			}
			if (TestUtility.compareDynamicText(headerObj, propertyName, AppVariables.POLICY, true)) {
				interaction.highlightElement(headerObj, true);
				resultList.add(true);
			} else {
				resultList.add(false);
			}

			String insured_name = FileOps_Common.getInsuredForPolicy(AppVariables.POLICY);
			if (TestUtility.compareDynamicText(SubHeader_Text, "Premiums_Layout_SubHeader_Text",
					TestUtility.addUsernameSuffix(insured_name), true)) {
				interaction.highlightElement(SubHeader_Text, true);
				resultList.add(true);
			} else {
				resultList.add(false);
			}

			if (resultList.contains(false)) {
				return false;
			} else {
				return true;
			}
		} else {
			log.error("Policy Data Object is null !!");
			return false;
		}

	}

}
