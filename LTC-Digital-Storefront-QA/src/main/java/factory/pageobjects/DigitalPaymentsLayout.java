package factory.pageobjects;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;

public class DigitalPaymentsLayout {

	Interaction interaction;
	Driver driver;
	public static Logger log = Logger.getLogger(DigitalPaymentsLayout.class);

	@FindBy(xpath = ".//*[text()='Amount due']")
	public WebElement Amount_Due_label;

	@FindBy(xpath = ".//*[text()='Payment due date']")
	public WebElement Payment_Due_Date_label;

	@FindBy(xpath = ".//*[text()='Payment frequency']")
	public WebElement Payment_Frequency_label;

	@FindBy(xpath = ".//*[text()='Amount due']/following::div[1]")
	public WebElement Amount_Due_text;

	@FindBy(xpath = ".//*[text()='Payment due date']/following::div[1]")
	public WebElement Payment_Due_Date_text;

	@FindBy(xpath = ".//*[text()='Payment frequency']/following::div[1]")
	public WebElement Payment_Frequency_text;

	@FindBy(xpath = ".//*[@class=\"detailsIcon\"]//*[@class=\"accordion-icon \"]")
	public WebElement See_Details_Icon;

	@FindBy(xpath = ".//*[@class=\"detailsIcon\"]/span[2]")
	public WebElement See_Details_label;

	@FindBy(xpath = ".//*[text()='Premium amount']")
	public WebElement Premium_Amount_label;

	@FindBy(xpath = ".//*[text()='Premium amount']/following::div[1]")
	public WebElement Premium_Amount_text;

	@FindBy(xpath = ".//*[text()='Payment received']")
	public WebElement Premium_Received_label;

	@FindBy(xpath = ".//*[text()='Payment received']/following::div[1]")
	public WebElement Premium_Received_text;

	@FindBy(xpath = ".//*[text()='Payment received']/following::div[4]")
	public WebElement Net_Amount_Due_label;

	@FindBy(xpath = ".//*[text()='Payment received']/following::div[5]")
	public WebElement Net_Amount_Due_text;

	@FindBy(xpath = ".//*[text()='Submit one-time payment']")
	public WebElement ONE_TIME_PAYMENT_CARD_HEADER_TEXT;

	@FindBy(xpath = ".//*[text()='Submit one-time payment']/following::div[1]")
	public WebElement ONE_TIME_PAYMENT_CARD_CONTENT;

	@FindBy(xpath = ".//*[text()='Submit one-time payment']/parent::div/c-ltc-button/a")
	public WebElement ONE_TIME_PAYMENT_CARD_LINK;

	@FindBy(xpath = ".//*[text()='Submit one-time payment']/parent::div/c-ltc-button//div")
	public WebElement ONE_TIME_PAYMENT_CARD_LINK_TEXT;

	@FindBy(xpath = ".//*[text()='Submit one-time payment']/parent::div")
	public WebElement ONE_TIME_PAYMENT_CARD;

	public DigitalPaymentsLayout(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;

	}

	public boolean verifyAmountDue(String amount_due) {
		return TestUtility.compareText(Amount_Due_text, amount_due, false);
	}

	public boolean verifyAmountDueDate(String amount_due_date) {
		return TestUtility.compareText(Payment_Due_Date_text, amount_due_date, false);
	}

	public boolean verifyAmountFrequency(String amount_amount_frequency) {
		return TestUtility.compareText(Payment_Frequency_text, amount_amount_frequency, false);
	}

	public boolean clickMoreDetailsLink() {
		if (TestUtility.compareText(See_Details_label, "PREMIUM_PAYMENT_MORE_DETAILS_ICON_TEXT", true)) {
			return interaction.clickWebElement(See_Details_Icon);
		}
		return false;
	}

	public boolean verifyPremiumAmount(String premium_amount) {
		return TestUtility.compareText(Premium_Amount_text, premium_amount, false);
	}

	public boolean verifyPremiumAmountReceived(String premium_amount_received) {
		return TestUtility.compareText(Premium_Received_text, premium_amount_received, false);
	}

	public boolean verifyNetAmountDue(String net_amount_due) {
		return TestUtility.compareText(Net_Amount_Due_text, net_amount_due, false);
	}

	public boolean verifyOneTimePaymentCardText(String card_header_text, String card_content) {
		ArrayList<Boolean> resultList = new ArrayList<>();

		resultList.add(TestUtility.compareText(ONE_TIME_PAYMENT_CARD_HEADER_TEXT, card_header_text, true));
		resultList.add(TestUtility.compareText(ONE_TIME_PAYMENT_CARD_CONTENT, card_content, true));
		resultList
				.add(TestUtility.compareText(ONE_TIME_PAYMENT_CARD_LINK_TEXT, "ONE_TIME_PAYMENT_CARD_LINK_TEXT", true));

		if (resultList.contains(false)) {
			return false;
		} else {
			interaction.highlightElement(ONE_TIME_PAYMENT_CARD, true);

			return true;
		}
	}

	public boolean clickOneTimePaymentCardLink() {
		// TODO Auto-generated method stub
		return false;
	}

}
