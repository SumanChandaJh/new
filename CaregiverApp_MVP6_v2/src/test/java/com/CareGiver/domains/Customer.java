package com.CareGiver.domains;

import java.util.Map;


/**
 * Customer Java POJO class contains all the required attributes
 * 
 * @author chatavi
 *
 */
public class Customer {

	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private String claimStatus = "";

	
	public Customer() {}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFullName() {
		return this.firstName +" "+ this.lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	


	public static Customer createCustomer(Map<String, String> entry) {
		Customer customer = new Customer();
		
		customer.setFirstName(entry.get("FirstName"));
		customer.setLastName(entry.get("LastName"));
		customer.setLastName(entry.get("Email"));
		customer.setClaimStatus(entry.get("ClaimStatus"));

		return customer;
	}
	
	@Override
	public String toString() {
		return "Customer [FirstName=" + firstName + ", LastName=" + lastName + ", Email="+ email +", ClaimStatus=" + claimStatus + "]";
	}

	
}
