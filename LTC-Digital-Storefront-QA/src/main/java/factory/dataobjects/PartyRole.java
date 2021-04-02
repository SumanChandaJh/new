package factory.dataobjects;

public class PartyRole {

	private String party_UUID = null;
	private String party_full_name = null;
	private String associated_claim = null;
	private String role_status = null;
	private String role_type = null;
	private String associated_policy = null;
	private String role_name = null;
	public String provider_online_status = null;

	public String getAssociated_claim() {
		return associated_claim;
	}

	public String getAssociated_policy() {
		return associated_policy;
	}

	public String getParty_full_name() {
		return party_full_name;
	}

	public String getParty_UUID() {
		return party_UUID;
	}

	public String getProvider_online_status() {
		return provider_online_status;
	}

	public String getRole_name() {
		return role_name;
	}

	public String getRole_status() {
		return role_status;
	}

	public String getRole_type() {
		return role_type;
	}

	public void printPartyRoleDetails() {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Role Type : " + this.getRole_type());
		System.out.println("Role Name : " + this.getRole_name());
		System.out.println("Role Status : " + this.getRole_status());
		System.out.println("Role Party Name : " + this.getParty_full_name());
		System.out.println("Role UUID : " + this.getParty_UUID());
		System.out.println("Role Assoicated Policy : " + this.getAssociated_policy());
		System.out.println("Role Associated Claim : " + this.getAssociated_claim());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

	public void setAssociated_claim(String associated_claim) {
		this.associated_claim = associated_claim;
	}

	public void setAssociated_policy(String associated_policy) {
		this.associated_policy = associated_policy;
	}

	public void setParty_full_name(String party_full_name) {
		this.party_full_name = party_full_name;
	}

	public void setParty_UUID(String party_UUID) {
		this.party_UUID = party_UUID;
	}

	public void setProvider_online_status(String provider_online_status) {
		this.provider_online_status = provider_online_status;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public void setRole_status(String role_status) {
		this.role_status = role_status;
	}

	public void setRole_type(String role_type) {
		this.role_type = role_type;
	}

}
