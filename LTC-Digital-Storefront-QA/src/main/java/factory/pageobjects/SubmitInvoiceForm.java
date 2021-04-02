package factory.pageobjects;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import General.Interaction;
import General.Settings;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.FormPageTemplate;
import support.fileoperations.ExcelReader;

public class SubmitInvoiceForm extends FormPageTemplate {

	private Interaction interaction;
	private Driver driver;
	private Properties settings;
	private static Logger log = Logger.getLogger(SubmitInvoiceForm.class);

	public SubmitInvoiceForm(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
		settings = Settings.getInstance();
	}

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcInvoiceForm\"]//*[@id=\"ltc-dd-40\"]/label")
	public WebElement provider_dropdown_label;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcInvoiceForm\"]//*[@id=\"ltc-dd-40\"]/div")
	public WebElement provider_dropdown_listbox;

	@FindBy(xpath = ".//*[@data-aura-class=\"cLtcInvoiceForm\"]//*[@id=\"ltc-dd-40\"]/ul")
	public WebElement provider_dropdown_ul;

	@FindBy(xpath = ".//legend[contains(text(),'Is there a rate change')]")
	WebElement rateChange_label;

	@FindBy(xpath = ".//legend[contains(text(),'Is there a rate change')]/following-sibling::div")
	WebElement rateChange_radio;

	@FindBy(xpath = ".//legend[contains(text(),'Is there a refund')]")
	WebElement refund_label;

	@FindBy(xpath = ".//legend[contains(text(),'Is there a refund')]/following-sibling::div")
	WebElement refund_radio;

	@FindBy(xpath = ".//legend[contains(text(),'Medicare cover')]")
	WebElement medicareCover_label;

	@FindBy(xpath = ".//legend[contains(text(),'Medicare cover')]/following-sibling::div")
	WebElement medicareCover_radio;

	@FindBy(xpath = ".//*[contains(text(),'UB-04')]//ancestor::div[@class='cLtcFlowTextArea']//textArea")
	WebElement medicareCover_reason;

	@FindBy(xpath = ".//legend[contains(text(),'facility overnight')]")
	WebElement insured_left_facility_label;

	@FindBy(xpath = ".//legend[contains(text(),'facility overnight')]/following-sibling::div")
	WebElement insured_left_facility_radio;

	@FindBy(xpath = ".//*[contains(text(),'what dates')]//ancestor::div[@class='cLtcFlowTextArea']//textArea")
	WebElement insured_left_facility_reason;

	@FindBy(xpath = ".//*[contains(text(),'Service period start')]")
	WebElement service_start_date_from_label;

	@FindBy(xpath = ".//*[contains(text(),'Service period start')]/following-sibling::div/input")
	WebElement service_start_date_from_input;

	@FindBy(xpath = ".//*[contains(text(),'Service period end')]")
	WebElement service_start_date_to_label;

	@FindBy(xpath = ".//*[contains(text(),'Service period end')]/following-sibling::div/input")
	WebElement service_start_date_to_input;

	@FindBy(xpath = ".//h5[contains(text(),'Itemize')]")
	WebElement itemize_charges_header;

	@FindBy(xpath = ".//h5[contains(text(),'Itemize')]/following-sibling::div[@class='facilitiesInfo']/div")
	WebElement itemize_charges_header_content;

	/**
	 * 
	 * Service Type
	 * .//*[@class='cLtcFlowDynamicRepeater']/div[1]/div[#1]/child::div[@class='cLtcFlowRepeaterCard']//ul
	 * 
	 * service charge
	 * .//*[@class='cLtcFlowDynamicRepeater']/div[1]/div[#1]/child::div[@class='cLtcFlowRepeaterCard']//*[@data-aura-class="uiInputSmartNumber"]
	 * 
	 */

	@FindBy(xpath = ".//*[text()='Add more charges']")
	WebElement add_more_charges_link;

	@FindBy(xpath = ".//*[contains(text(),'Additional')]")
	WebElement additional_information_label;

	@FindBy(xpath = ".//*[contains(text(),'Additional')]/ancestor::div[@class='cLtcFlowTextArea']//textArea")
	WebElement additional_information_textArea;

	@FindBy(xpath = ".//*[contains(text(),'I attest to the knowledge')]")
	WebElement fraud_disclaimer_label;

	@FindBy(xpath = ".//*[contains(text(),'Additional')]/ancestor::div[@class='cLtcFlowTextArea']//textArea")
	WebElement fraud_disclaimer_checkbox;

	@FindBy(xpath = ".//*[@value=\"Submit invoice\"]")
	WebElement submit_invoice_button;

	@Override
	public boolean verifyPageHeaders() {
		return false;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		return null;
	}

	@Override
	public boolean verifyFormFields() {
		return false;
	}

	@Override
	public boolean fillForm() {
		return false;
	}

	@Override
	public boolean clickSubmitButton() {
		return false;
	}

	@Override
	public boolean verifySuccessfulSubmissionMessage() {
		return false;
	}

	public boolean selectProviderByType(String providerType) {

		if (TestUtility.compareText(provider_dropdown_label, "provider_dropdown_label", true)) {
			if (interaction.clickWebElement(provider_dropdown_listbox)) {
				interaction.selectDropDownValue(provider_dropdown_ul, providerType);

				if (provider_dropdown_listbox.getText().endsWith(providerType)) {
					interaction.highlightElement(provider_dropdown_listbox, true);
					return true;
				}
			}
		}

		return false;
	}

	public boolean fillInvoiceForm(String providerType) throws InvalidFormatException, IOException {
		int sheetNumber = -1;
		String sheetName = "";

		String filepath = new File(System.getProperty("user.dir")).getAbsolutePath()
				+ settings.getProperty("INVOICE_DATA");
		if (providerType.contentEquals("Nursing Home")) {
			sheetNumber = 0;
			sheetName = "Nursing_Home";
		} else if (providerType.contains("Assisted Living Facility")) {
			sheetNumber = 1;
			sheetName = "Assisted_Living_Facility";
		}

		ExcelReader reader = new ExcelReader();
		List<Map<String, String>> data = reader.getData(filepath, sheetNumber);

		data.stream().forEach(record -> {
			record.entrySet().stream().filter(x -> x.getKey().contains("Sachin"))
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
				//	.forEach((entry) -> System.out.println(entry.getKey() + " : " + entry.getValue()));
		});

		// filter out records of other scenarios

		Map<String, String> map = data.get(0);

		map.entrySet().stream().filter(x -> x.getKey().contains("Sachin"))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

		// put current record into invoice object ---optional step

		// fill the form fields with the entry

		String serviceStartDate = data.get(0).get("SERVICE_START_DATE");
		System.out.println(serviceStartDate);

		interaction.setTextElement(service_start_date_from_input, serviceStartDate);

		return true;
	}

}
