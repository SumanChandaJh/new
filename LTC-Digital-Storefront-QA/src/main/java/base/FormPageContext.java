package base;

import factory.driver.Driver;
import factory.driver.DriverManager;
import factory.pageobjects.AskAQuestionTab;
import factory.pageobjects.AssignmentOfBenifitsForm;
import factory.pageobjects.AutomaticBankWithdrawlForm;
import factory.pageobjects.AutomaticDeductionPlanForm;
import factory.pageobjects.DeathCertificateForm;
import factory.pageobjects.DirectDepositForm;
import factory.pageobjects.HIPAAForm;
import factory.pageobjects.LegalRepForm;
import factory.pageobjects.SubmitInvoiceForm;

public class FormPageContext extends TestContext {

	AskAQuestionTab askAQuestionTab;
	LegalRepForm legalRepForm;
	HIPAAForm hipaaForm;
	AutomaticBankWithdrawlForm automaticBankWithdrawlForm;
	AutomaticDeductionPlanForm automaticDeductionPlanForm;
	DirectDepositForm directDepositForm;
	AssignmentOfBenifitsForm assignmentOfBenifitsForm;
	DeathCertificateForm deathCertificateForm;
	public SubmitInvoiceForm submitInvoiceForm;

	public FormPageContext() {
		super();
		initializePages();
	}

	private void initializePages() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		askAQuestionTab = new AskAQuestionTab(driver);
		legalRepForm = new LegalRepForm(driver);
		hipaaForm = new HIPAAForm(driver);
		automaticBankWithdrawlForm = new AutomaticBankWithdrawlForm(driver);
		automaticDeductionPlanForm = new AutomaticDeductionPlanForm(driver);
		directDepositForm = new DirectDepositForm(driver);
		assignmentOfBenifitsForm = new AssignmentOfBenifitsForm(driver);
		deathCertificateForm = new DeathCertificateForm(driver);
		submitInvoiceForm = new SubmitInvoiceForm(driver);
	}

	public boolean verifyPageHeaders(String formName) {
		switch (formName) {
		case "Legal Representative":
			return legalRepForm.verifyPageHeaders();
		case "HIPAA":
			return hipaaForm.verifyPageHeaders();
		case "Automatic Deduction Plan":
			return automaticDeductionPlanForm.verifyPageHeaders();

		default:
			break;
		}
		return false;
	}

	public boolean fillForm(String formName, String... inputString) {
		switch (formName) {
		case "Legal Representative":
			return legalRepForm.fillForm();
		case "HIPAA":
			return hipaaForm.fillForm();
		case "Autumatic Bank Withdrawl":
			return automaticBankWithdrawlForm.fillForm();

		default:
			break;
		}
		return false;
	}

	public boolean verifyFormFields(String formName) {
		switch (formName) {
		case "Legal Representative":
			return legalRepForm.verifyFormFields();
		case "HIPAA":
			return hipaaForm.verifyFormFields();

		default:
			break;
		}
		return false;
	}

	public boolean clickSubmitButton(String formName) {
		switch (formName) {
		case "Legal Representative":
			return legalRepForm.clickSubmitButton();
		case "HIPAA":
			return hipaaForm.clickSubmitButton();
		case "Submit Invoice":
			return submitInvoiceForm.clickSubmitButton();
		default:
			break;
		}
		return false;
	}

	public boolean verifySuccessfulSubmissionMessage(String formName) {
		switch (formName) {
		case "Legal Representative":
			return legalRepForm.verifySuccessfulSubmissionMessage();
		case "HIPAA":
			return hipaaForm.verifySuccessfulSubmissionMessage();
		case "Submit Invoice":
			return submitInvoiceForm.verifySuccessfulSubmissionMessage();
		default:
			break;
		}
		return false;
	}

}
