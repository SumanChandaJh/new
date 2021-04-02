package factory.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import factory.driver.Driver;

public class CustomerRegistrationPage {

	Interaction interaction;
	Driver driver;
	public static Logger log = Logger.getLogger(CustomerRegistrationPage.class);

	public CustomerRegistrationPage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@FindBy(xpath = "//h1[@class='banner-title']\r\n")
	public WebElement BlueRibbon_Title;

	@FindBy(xpath = ".//*[@id='pnum']")
	public WebElement Insured_Policy_Number_Text;

	@FindBy(xpath = ".//*[contains(text(),'Your Role')]//parent::div//child::select")
	public WebElement Registrant_Role_dropdown;

	@FindBy(xpath = ".//*[contains(text(),'Your First Name')]//parent::div//child::input")
	public WebElement Registrant_First_Name_Text;
	@FindBy(xpath = ".//*[contains(text(),'Your Last Name')]//parent::div//child::input")
	public WebElement Registrant_Last_Name_Text;

	@FindBy(xpath = ".//*[contains(text(),\"Insured's First Name\")]/following::input[1]")
	public WebElement Insured_First_Name_Text;
	@FindBy(xpath = ".//*[contains(text(),\"Insured's Last Name\")]/following::input[1]")
	public WebElement Insured_Last_Name_Text;
	@FindBy(xpath = ".//*[@id='dob']")
	public WebElement Insured_Date_Of_Birth_Text;
	@FindBy(xpath = ".//*[@id='ssn']")
	public WebElement Insured_SSN_Text;

	@FindBy(xpath = ".//*[contains(text(),'Daytime')]//parent::div//child::input")
	public WebElement Insured_Phone_Number_Text;
	@FindBy(xpath = ".//*[@id='email']")
	public WebElement Insured_Email_Address_Text;
	@FindBy(xpath = ".//*[@id='confirmEmail']")
	public WebElement Insured_Confirm_Email_Address_Text;

	@FindBy(xpath = ".//*[@id='userName']")
	public WebElement Insured_Username_Text;
	@FindBy(xpath = ".//*[@id='password']")
	public WebElement Insured_Password_Text;
	@FindBy(xpath = ".//*[@id='cpassword']")
	public WebElement Insured_Confirm_Password_Text;

	@FindBy(xpath = ".//*[contains(@id,'secretQ1')]")
	public WebElement Insured_SQA_Question_1_Text;
	@FindBy(xpath = ".//*[@id='answer1']")
	public WebElement Insured_SQA_Answer_1_Text;
	@FindBy(xpath = ".//*[contains(@id,'secretQ2')]")
	public WebElement Insured_SQA_Question_2_Text;
	@FindBy(xpath = ".//*[@id='answer2']")
	public WebElement Insured_SQA_Answer_2_Text;
	@FindBy(xpath = ".//*[contains(@id,'secretQ3')]")
	public WebElement Insured_SQA_Question_3_Text;
	@FindBy(xpath = ".//*[@id='answer3']")
	public WebElement Insured_SQA_Answer_3_Text;

	@FindBy(xpath = "//button[@id='submitBtn']")
	public WebElement Submit_Button;
	@FindBy(xpath = "//div[@class='content-block']")
	public WebElement Success_Message_Text;
	@FindBy(xpath = ".//*[@id='errorLine']")
	public WebElement Error_Message_Text;

}
