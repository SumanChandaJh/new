package com.CareGiver.domains;

import java.util.Map;


/**
 * Provider class to store the Provider Profile Information
 * 
 * @author chatavi
 *
 */
public class Provider {

	private String environment = "";
	private String fullName = "";
	private String email = "";
	private String username = "";
	private String password = "";
	private String sFUsername = "";
	private String sFPassword = "";

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String env) {
		this.environment = env;
	}

	public String getSFusername() {
		return sFUsername;
	}

	public void setSFusername(String sFusername) {
		this.sFUsername = sFusername;
	}

	public String getSFpassword() {
		return sFPassword;
	}

	public void setSFpassword(String sFpassword) {
		this.sFPassword = sFpassword;
	}

	public static Provider createProvider(Map<String, String> entry) {
		Provider provider = new Provider();
		
		provider.setEnvironment(entry.get("Environment"));
		provider.setFullName(entry.get("FullName"));
		provider.setEmail(entry.get("Email"));
		provider.setUsername(entry.get("Username"));
		provider.setPassword(entry.get("Password"));
		provider.setSFusername(entry.get("SFUsername"));
		provider.setSFpassword(entry.get("SFPassword"));
		
		return provider;
	}
	
	@Override
	public String toString() {
		return "Provider [Env=" +environment + ", FullName=" + fullName + ", Email=" + email + ", Username="+ username +", Password=" + password + ", sf_username =" +sFUsername+", sf_password ="+sFPassword+ ", ]";
	}

}
