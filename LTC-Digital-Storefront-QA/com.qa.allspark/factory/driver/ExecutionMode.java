package factory.driver;

/**
 * Enumeration to represent the mode of execution
 * 
 * @author Cognizant
 */
public enum ExecutionMode {
	LOCAL("local"), REMOTE("remote");

	private String value;

	ExecutionMode(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}