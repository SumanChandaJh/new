package com.CareGiver.domains;

import java.util.Map;


/**
 * Customer Java POJO class contains all the required attributes
 * 
 * @author 
 *
 */
public class User {

	private String userName = "";
	private String password = "";
	private String url = "";
	

	
	public User() {}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public static User createUser(Map<String, String> entry) {
		User user = new User();
		
		user.setUserName(entry.get("UserName"));
		user.setUserName(entry.get("Password"));
		user.setUserName(entry.get("URL"));
	

		return user;
	}
	
	@Override
	public String toString() {
		return "User [UserName=" + userName + ", Password" + password + ", URL="+ url +"]";
	}

	
}
