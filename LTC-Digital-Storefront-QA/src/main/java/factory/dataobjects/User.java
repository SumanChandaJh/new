package factory.dataobjects;

public class User {

	
	String userType , username, password, fullname, userRole;

	public String getFullname() {
		return fullname;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public String getUserRole() {
		return userRole;
	}

	public String getUserType() {
		return userType;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
}
