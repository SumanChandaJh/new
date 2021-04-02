package base;

import org.apache.log4j.Logger;

import factory.driver.Driver;
import factory.driver.DriverManager;
import factory.pageobjects.ClaimOverviewPage;
import factory.pageobjects.ClaimsLayout;
import factory.pageobjects.DigitalPaymentsLayout;
import factory.pageobjects.MessageCenterLayout;
import factory.pageobjects.PolicyBasics;
import factory.pageobjects.PolicyLayout;
import factory.pageobjects.PremiumPaymentHistory;
import factory.pageobjects.SubmitDocumentTab;

public class TabPageContext extends TestContext {

	private static Logger log = Logger.getLogger(TabPageContext.class);
	public ClaimOverviewPage claimOverviewPage;
	public ClaimsLayout claimsLayout;
	public DigitalPaymentsLayout digitalPaymentsLayout;
	public MessageCenterLayout messageCenterLayout;
	public PolicyBasics policyBasics;
	public PolicyLayout policyLayout;

	public PremiumPaymentHistory premiumPaymentHistory;
	public SubmitDocumentTab submitDocumentTab;

	public TabPageContext() {
		super();
		initializePages();
	}

	// should only be called via constructor
	private void initializePages() {
		Driver driver = DriverManager.getInstance().getWebDriver();
		policyLayout = new PolicyLayout(driver);
		claimsLayout = new ClaimsLayout(driver);
		messageCenterLayout = new MessageCenterLayout(driver);
		submitDocumentTab = new SubmitDocumentTab(driver);
		premiumPaymentHistory = new PremiumPaymentHistory(driver);
		digitalPaymentsLayout = new DigitalPaymentsLayout(driver);
	}

	public boolean navigateToTab(String pageName, String tabName) {
		switch (pageName) {
		case "Policies":
			return policyLayout.navigateToTab(tabName);
		case "Claims":
			return claimsLayout.navigateToTab(tabName);
		case "Message Center":
			return messageCenterLayout.navigateToTab(tabName);
		default:
			log.info("Incorrect tab name in feature file !!");
			return false;
		}
	}

	public boolean selectCard(String tabName, String cardName) {
		switch (tabName) {
		case "Submit Document":
			return submitDocumentTab.selectCard(cardName);
		case "Policy Basics":
			return policyBasics.selectCard(cardName);
		}
		return false;
	}

	public boolean selectClaim(String tabName, String claimNumber) {
		switch (tabName) {
		case "Submit Document":
			return submitDocumentTab.selectClaim(claimNumber);

		}
		return false;
	}

	public boolean selectPolicy(String tabName, String policyNumber) {
		switch (tabName) {
		case "Submit Document":
			return submitDocumentTab.selectPolicy(policyNumber);

		}
		return false;
	}

	/***
	 * ********* Submit Document Tab Steps *****************************
	 */

	public boolean verifyCardAvailability(String tabName, String cardName) {
		switch (tabName) {
		case "Submit Document":
			return submitDocumentTab.verifyCardAvailability(cardName);
		case "Policy Basics":
			return policyBasics.verifyCardAvailability(cardName);
		}
		return false;
	}

	public boolean verifyPageHeaders(String pageName) {
		switch (pageName) {
		case "Policies":
			return policyLayout.verifyPageHeaders();
		case "Claims":
			return claimsLayout.verifyPageHeaders();
		case "Message Center":
			return messageCenterLayout.verifyPageHeaders();
		case "Premium Payments":
			return premiumPaymentHistory.verifyPageHeaders();
		}
		return false;

	}

	public boolean verifyTabAvailability(String pageName, String tabName) {
		switch (pageName) {
		case "Policies":
			return policyLayout.verifyTabAvailability(tabName);
		case "Claims":
			return claimsLayout.verifyTabAvailability(tabName);
		case "Message Center":
			return messageCenterLayout.verifyTabAvailability(tabName);
		}
		return false;
	}
}
