package factory.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.FlyoutPageTemplate;
import support.businesslogic.AppVariables;

public class PremiumsFlyoutPage extends FlyoutPageTemplate {

	private Interaction interaction;

	public PremiumsFlyoutPage(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
	}

	@FindBy(xpath = ".//*[@data-id=\"premiumMenuItem\"]//section[1]//*[contains(@class,'top-header')]")
	public WebElement Premiums_Header_Text;

	@FindBy(xpath = ".//*[@data-id=\"premiumMenuItem\"]//section[1]//*[contains(@class,'top-subheader')]")
	public WebElement Premiums_SubHeader_Text;

	@FindBy(xpath = "//*[@data-id=\"premiumMenuItem\"]//section[2]//span")
	public WebElement ViewPremium_Link;

	@FindBy(xpath = "//*[@data-id=\"premiumMenuItem\"]/aside/c-ltc-menu-card/div")
	public WebElement Flyout_Premiums;

	@Override
	public boolean verifyElementTextForFlyout(String propertyName) {

		return TestUtility.compareText(getElementFromName(propertyName), propertyName, true);

	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		WebElement element = null;
		if (propertyName.contains("Premiums_Header_Text"))
			element = Premiums_Header_Text;
		else if (propertyName.contains("Premiums_SubHeader_Text"))
			element = Premiums_SubHeader_Text;
		return element;
	}

	public boolean clickPremiumLink(String policyNumber) {

		ArrayList<Boolean> resultList = new ArrayList<Boolean>();
		WebElement currentSection;
		int flag = 0;
		List<WebElement> sectionElements;
		List<WebElement> sectionElementButton;
		WebElement actualPolNo;
		String actualPolNoText;
		WebElement button;

		List<WebElement> sections = Flyout_Premiums.findElements(By.tagName("section"));
		if (sections != null) {
			for (int sectionNumber = 2; sectionNumber <= sections.size() - 1; sectionNumber++) {
				currentSection = sections.get(sectionNumber);
				sectionElements = currentSection.findElements(By.tagName("div"));
				sectionElementButton = currentSection.findElements(By.tagName("c-ltc-button"));
				if (sectionElements != null) {
					actualPolNo = sectionElements.get(3);
					actualPolNoText = actualPolNo.getText();
					System.out.println("Actual Policy number " + actualPolNoText);
					System.out.println("Expected Policy Number" + policyNumber);
					if (policyNumber.equals(actualPolNoText)) {
						AppVariables.POLICY = policyNumber;
						System.out.println("Inside verification");
						button = sectionElementButton.get(0);
						System.out.println("The button is" + button.toString());
						interaction.clickWebElement(button);
						interaction.waitForSeconds(10000);
						flag++;
						break;
					}

				} else
					resultList.add(false);
			}

		} else
			resultList.add(false);

		if (resultList.contains(false) && (flag == 0))
			return false;
		else
			return true;
	}

	@Override
	public boolean clickElement(String properyName) {
		// TODO Auto-generated method stub
		return false;
	}
}
