package com.CareGiver.bucket;

import java.util.List;

import com.CareGiver.Base.Base;
import com.CareGiver.domains.Customer;
import com.CareGiver.domains.Provider;

import com.CareGiver.pageObjects.AllSessionsPage;

import com.CareGiver.domains.User;

import com.CareGiver.pageObjects.AllowAccessPage;
import com.CareGiver.pageObjects.CheckInPage;

import com.CareGiver.pageObjects.Common;

import com.CareGiver.pageObjects.CheckOutPage;
import com.CareGiver.pageObjects.CommonBackOfficePage;

import com.CareGiver.pageObjects.CustomerBeginSessionPage;
import com.CareGiver.pageObjects.HomeScreenPage;
import com.CareGiver.pageObjects.HourlyRatePage;
import com.CareGiver.pageObjects.HourlyRateSubmissionAcknowledgementPage;
import com.CareGiver.pageObjects.LaunchPage;
import com.CareGiver.pageObjects.LoginPage;
import com.CareGiver.pageObjects.ManageSessions;
import com.CareGiver.pageObjects.Menu;
import com.CareGiver.pageObjects.MyCustomersPage;
import com.CareGiver.pageObjects.PastSessionPage;
import com.CareGiver.pageObjects.ProfileSetUpPage;
import com.CareGiver.pageObjects.ProviderPortal_LoginPage;
import com.CareGiver.pageObjects.SessionPage;
import com.CareGiver.pageObjects.TermsAndConditionsPage;
import com.CareGiver.pageObjects.TipsPage;
import com.CareGiver.pageObjects.TourPage;


public class PageBucket extends Base {
	
/*	ObjectFactory factory = new PicoFactory();
    factory.addClass(LaunchPage.class);*/
	
	public Provider provider;
	public Customer customer;
	public List<Customer> customers;
	public User user;
	public List<User> users;
    public static String SESSION_START_TIME = "";
    public static String SESSION_END_TIME = "";
    
	Base base = new Base();
	
	public Common common = new Common(appDriver);
	public LoginPage loginPage = new LoginPage(appDriver);
	public LaunchPage launchPage = new LaunchPage(appDriver);
	public ProviderPortal_LoginPage providerPortalLogin = new ProviderPortal_LoginPage(appDriver);
	public AllowAccessPage allowAccessPage = new AllowAccessPage(appDriver);
	public MyCustomersPage myCustomers = new MyCustomersPage(appDriver);
	public Menu menu = new Menu(appDriver);
	public TipsPage tipsPage = new TipsPage(appDriver);
	public TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(appDriver);
	public CustomerBeginSessionPage customerBeginSessionPage = new CustomerBeginSessionPage(appDriver);
	public CheckInPage checkInPage = new CheckInPage(appDriver);
	public AllSessionsPage allSessionsPage = new AllSessionsPage(appDriver);

	public CheckOutPage checkOutPage = new CheckOutPage(appDriver);
	public CommonBackOfficePage commonBackOfficePage= new CommonBackOfficePage(webDriver);
    public SessionPage sessionPage=new SessionPage(appDriver);
    public TourPage tourPage=new TourPage(appDriver);
    public PastSessionPage pastSessionPage =new PastSessionPage(appDriver);

	public ManageSessions manageSessions = new ManageSessions(appDriver);
	
	public ProfileSetUpPage profilesetuppage = new ProfileSetUpPage(appDriver);
	public HourlyRatePage   hourlyratepage = new HourlyRatePage(appDriver);
	public HourlyRateSubmissionAcknowledgementPage hrratesubackpg = new HourlyRateSubmissionAcknowledgementPage(appDriver);
	public HomeScreenPage homescreenpage = new HomeScreenPage(appDriver);
	// Skip the Step at IOS platform.
	// Note: This is a workaround until QA fix the Perfecto+IOS dependency
	public boolean skipAtIOS() {
		System.err.println("Skipped the Step at IOS platform");
		return true;
	}
	
	
	public void setProvider(List<Provider> providers) {
        this.provider = providers.get(0);
    }

    public Provider getProvider() {
        return provider;
    }
    
    public void setCustomer(List<Customer> customers) {
    	this.customer = customers.get(0);
    }
    
    public void setCustomers(List<Customer> customers) {
    	this.customers = customers;
    }
    
    public Customer getCustomer() {
    	return customer;
    }
    
    public void setUser(List<User> users) {
        this.user = users.get(0);
    }

    public void setUsers(List<User> users) {
    	this.users = users;
    }
    public User getUser() {
        return user;
    }
  
}
