package factory.dataobjects;

import java.util.ArrayList;

public class Policy implements Comparable<Policy> {

	private String Coverage_Id = null;
	private String Policy_Number = null;
	private String Certificate_Status = null;
	private String Policy_Type = null;
	private String Premium_PaidThruDate = null;
	private String Client_Name = null;
	private String Policy_Status = null;
	private String InsuredFullName = null;
	private String Policy_IssueState = null;
	private String Policy_ClientNumber = null;
	private String Policy_GroupPolicyNumber = null;
	private String Product_Name = null;
	private ArrayList<Claim> claimList = new ArrayList<Claim>();
	private ArrayList<PartyRole> policyRoleList = new ArrayList<PartyRole>();

	public Policy() {
	}

	@Override
	public int compareTo(Policy o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getCertificate_Status() {
		return Certificate_Status;
	}

	public ArrayList<Claim> getClaimList() {
		return claimList;
	}

	public String getClient_Name() {
		return Client_Name;
	}

	public String getCoverage_Id() {
		return Coverage_Id;
	}

	public String getInsuredFullName() {
		return InsuredFullName;
	}

	public String getPolicy_ClientNumber() {
		return Policy_ClientNumber;
	}

	public String getPolicy_GroupPolicyNumber() {
		return Policy_GroupPolicyNumber;
	}

	public String getPolicy_IssueState() {
		return Policy_IssueState;
	}

	public String getPolicy_Number() {
		return Policy_Number;
	}

	public String getPolicy_Status() {
		return Policy_Status;
	}

	public String getPolicy_Type() {
		return Policy_Type;
	}

	public ArrayList<PartyRole> getPolicyRoleList() {
		return policyRoleList;
	}

	public String getPremium_PaidThruDate() {
		return Premium_PaidThruDate;
	}

	public String getProduct_Name() {
		return Product_Name;
	}

	public void printPolicyDetails() {

		System.out.println(
				"*********************************************************************************************");
		System.out.println("Policy Number : " + this.getPolicy_Number());
		System.out.println("Coverage Id : " + this.getCoverage_Id());
		System.out.println("Policy Type : " + this.getPolicy_Type());
		System.out.println("Policy Status : " + this.getPolicy_Status());
		System.out.println("Certificate Status : " + this.getCertificate_Status());
		System.out.println("Policy Premium Paid Thru Date : " + this.getPremium_PaidThruDate());
		System.out.println("Policy Issue State : " + this.getPolicy_IssueState());
		System.out.println("Policy Client Name : " + this.getClient_Name());
		System.out.println("Product Name : " + this.getProduct_Name());

		for (PartyRole policyRole : this.getPolicyRoleList()) {
			policyRole.printPartyRoleDetails();
		}

		for (Claim currentClaim : this.getClaimList()) {
			currentClaim.printClaimDetails();
		}

		System.out.println(
				"*********************************************************************************************");

	}

	public void setCertificate_Status(String certificate_Status) {
		Certificate_Status = certificate_Status;
	}

	public void setClaimList(ArrayList<Claim> claimList) {
		this.claimList = claimList;
	}

	public void setClient_Name(String client_Name) {
		Client_Name = client_Name;
	}

	public void setCoverage_Id(String coverage_Id) {
		Coverage_Id = coverage_Id;
	}

	public void setInsuredFullName(String insuredFullName) {
		InsuredFullName = insuredFullName;
	}

	public void setPolicy_ClientNumber(String policy_ClientNumber) {
		Policy_ClientNumber = policy_ClientNumber;
	}

	public void setPolicy_GroupPolicyNumber(String policy_GroupPolicyNumber) {
		Policy_GroupPolicyNumber = policy_GroupPolicyNumber;
	}

	public void setPolicy_IssueState(String policy_IssueState) {
		Policy_IssueState = policy_IssueState;
	}

	public void setPolicy_Number(String policy_Number) {
		Policy_Number = policy_Number;
	}

	public void setPolicy_Status(String policy_Status) {
		Policy_Status = policy_Status;
	}

	public void setPolicy_Type(String policy_Type) {
		Policy_Type = policy_Type;
	}

	public void setPolicyRoleList(ArrayList<PartyRole> policyRoleList) {
		this.policyRoleList = policyRoleList;
	}

	public void setPremium_PaidThruDate(String premium_PaidThruDate) {
		Premium_PaidThruDate = premium_PaidThruDate;
	}

	public void setProduct_Name(String product_Name) {
		Product_Name = product_Name;
	}

}
