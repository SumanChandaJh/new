package factory.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import General.Interaction;
import base.TestUtility;
import factory.driver.Driver;
import factory.pagetemplates.CardPageTemplate;

public class PolicyBasics extends CardPageTemplate {

	Interaction interaction;
	Driver driver;
	
	
	

	public PolicyBasics(Driver driver) {
		PageFactory.initElements(driver, this);
		interaction = Interaction.getInstance();
		this.driver = driver;
	}

	@Override
	public WebElement getElementFromName(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean verifyCardAvailability(String cardName) {
		ArrayList<Boolean> status = new ArrayList<Boolean>();
		String inputCardName = cardName.replaceAll(" ", "_") + "_Card";
		if (interaction.waitForElement(getElementFromName(inputCardName))) {
			status.add(TestUtility.compareText(getElementFromName(inputCardName), inputCardName, true));
			status.add(TestUtility.compareText(getElementFromName(inputCardName + "_Content"),
					inputCardName + "_Content", true));
			status.add(TestUtility.compareText(getElementFromName(inputCardName + "_Link"), inputCardName + "_Link",
					true));
			if (status.contains(false)) {
				return false;
			} else {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean selectCard(String cardName) {
		// TODO Auto-generated method stub
		return false;
	}

}
