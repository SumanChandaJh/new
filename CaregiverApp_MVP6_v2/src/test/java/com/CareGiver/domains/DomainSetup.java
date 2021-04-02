package com.CareGiver.domains;

import java.util.List;

import com.CareGiver.supportLibraries.Util;

public class DomainSetup {
	
	private Provider provider;
	private Customer customer;
	private List<Customer> customers;
	private List<Session> sessions;
	private Session session;
	private boolean hasMultipleCustomer;

	// Page initiation with domain 
	//AllSessionsPage allSessionsPage = new AllSessionsPage(this);
	
	

	public void setProvider(List<Provider> providers) {
		if (providers.size() > 0) {
			for (Provider provider : providers) {
				if (provider.getEnvironment().equalsIgnoreCase(Util.getRunEnvironment())) {
					this.provider = provider;
					break;
				}
			}
		} else {
			System.err.println("Data Table of Provider is Empty");
		}
	}

	public Provider getProvider() {
		return provider;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}
	
	public List<Customer> getCustomers() {
		return customers;
	}
	
	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}
	
	public boolean isSingleCustomer() {
		boolean isSingle = false;
		
		if(customers.size() == 1) isSingle = true;
		else if(customers.size() > 1) isSingle = false;
		
		return isSingle;
	}

	public void checkAndSetMultipleCustomerFlag() {
		if(!isSingleCustomer()) setHasMultipleCustomerFlag(true);
		else setHasMultipleCustomerFlag(false);
	}

	public void setHasMultipleCustomerFlag(boolean hasMultipleCustomer) {
		this.hasMultipleCustomer = hasMultipleCustomer;
	}
	
	public boolean getHasMultipleCustomerFlag() {
		return hasMultipleCustomer;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	public Customer setCustomerByCustomerName(String customerFullName) {
		for(Customer customer : getCustomers()) {
			if(customer.getFullName().equalsIgnoreCase(customerFullName)) 
				setCustomer(customer);
				break;
		}
		
		return customer;
	}
	
	
}
