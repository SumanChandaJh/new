package factory.pagetemplates;

import org.openqa.selenium.WebElement;

public abstract class FlyoutPageTemplate {

	public abstract boolean clickElement(String properyName);

	public abstract WebElement getElementFromName(String propertyName);

	public abstract boolean verifyElementTextForFlyout(String properyName);

}
