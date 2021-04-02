package factory.pagetemplates;

import org.openqa.selenium.WebElement;

public abstract class TabPageTemplate {

	public abstract boolean verifyPageHeaders();

	public abstract WebElement getElementFromName(String propertyName);

	public abstract boolean verifyTabAvailability(String tabName);

	public abstract boolean navigateToTab(String tabName);

}
