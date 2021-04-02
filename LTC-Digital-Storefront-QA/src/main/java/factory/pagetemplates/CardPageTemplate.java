package factory.pagetemplates;

import org.openqa.selenium.WebElement;

public abstract class CardPageTemplate {

	public abstract WebElement getElementFromName(String propertyName);

	public abstract boolean verifyCardAvailability(String cardName);

	public abstract boolean selectCard(String cardName);

}
