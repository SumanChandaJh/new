package factory.dataobjects;

import java.util.ArrayList;

public class Claim {

	private String Claim_Number = null;
	private String Claim_Status = null;
	private String Claim_SubStatus = null;
	private String Claim_Source = null;
	private String Claim_Status_Effective_Date = null;
	private String Claim_Pool1_Name = null;
	private String Claim_Pool2_Name = null;
	private String Claim_Pool1_Elimination_Period = null;
	private String Claim_Pool2_Elimination_Period = null;
	private String Claim_Pool1_Elimination_Period_Credited = null;
	private String Claim_Pool2_Elimination_Period_Credited = null;
	private String Claim_Pool1_Elimination_Period_Remianing = null;
	private String Claim_Pool2_Elimination_Period_Remianing = null;
	private String Claim_Pool1_Elimination_Period_MET_Date = null;
	private String Claim_Pool2_Elimination_Period_MET_Date = null;
	private String Claim_Premium_Waiver_Effective_Date = null;
	private ArrayList<PartyRole> claimRoleList = null;

	public Claim() {
	}

	public Claim(String Claim_Number, String Claim_Status, String Claim_Status_Effective_Date) {
		super();
		this.Claim_Number = Claim_Number;
		this.Claim_Status = Claim_Status;
		this.Claim_Status_Effective_Date = Claim_Status_Effective_Date;
	}

	public String getClaim_Number() {
		return Claim_Number;
	}

	public String getClaim_Pool1_Elimination_Period() {
		return Claim_Pool1_Elimination_Period;
	}

	public String getClaim_Pool1_Elimination_Period_Credited() {
		return Claim_Pool1_Elimination_Period_Credited;
	}

	public String getClaim_Pool1_Elimination_Period_MET_Date() {
		return Claim_Pool1_Elimination_Period_MET_Date;
	}

	public String getClaim_Pool1_Elimination_Period_Remianing() {
		return Claim_Pool1_Elimination_Period_Remianing;
	}

	public String getClaim_Pool1_Name() {
		return Claim_Pool1_Name;
	}

	public String getClaim_Pool2_Elimination_Period() {
		return Claim_Pool2_Elimination_Period;
	}

	public String getClaim_Pool2_Elimination_Period_Credited() {
		return Claim_Pool2_Elimination_Period_Credited;
	}

	public String getClaim_Pool2_Elimination_Period_MET_Date() {
		return Claim_Pool2_Elimination_Period_MET_Date;
	}

	public String getClaim_Pool2_Elimination_Period_Remianing() {
		return Claim_Pool2_Elimination_Period_Remianing;
	}

	public String getClaim_Pool2_Name() {
		return Claim_Pool2_Name;
	}

	public String getClaim_Premium_Waiver_Effective_Date() {
		return Claim_Premium_Waiver_Effective_Date;
	}

	public String getClaim_Source() {
		return Claim_Source;
	}

	public String getClaim_Status() {
		return Claim_Status;
	}

	public String getClaim_Status_Effective_Date() {
		return Claim_Status_Effective_Date;
	}

	public String getClaim_SubStatus() {
		return Claim_SubStatus;
	}

	public String getClaimAttribute(String attributeName) {
		String attributeValue = null;

		switch (attributeName) {
		case "Claim_Number":
			attributeValue = getClaim_Number();
			break;
		case "Claim_Status":
			attributeValue = getClaim_Status();
			break;
		case "Claim_SubStatus":
			attributeValue = getClaim_SubStatus();
			break;
		case "Claim_Source":
			attributeValue = getClaim_Source();
			break;
		case "Claim_Status_Effective_Date":
			attributeValue = getClaim_Status_Effective_Date();
			break;
		case "Claim_Pool1_Name":
			attributeValue = getClaim_Pool1_Name();
			break;
		case "Claim_Pool2_Name":
			attributeValue = getClaim_Pool2_Name();
			break;
		case "Claim_Pool1_Elimination_Period":
			attributeValue = getClaim_Pool1_Elimination_Period();
			break;
		case "Claim_Pool2_Elimination_Period":
			attributeValue = getClaim_Pool2_Elimination_Period();
			break;
		case "Claim_Pool1_Elimination_Period_Credited":
			attributeValue = getClaim_Pool1_Elimination_Period_Credited();
			break;
		case "Claim_Pool2_Elimination_Period_Credited":
			attributeValue = getClaim_Pool2_Elimination_Period_Credited();
			break;
		case "Claim_Pool1_Elimination_Period_Remianing":
			attributeValue = getClaim_Pool1_Elimination_Period_Remianing();
			break;
		case "Claim_Pool2_Elimination_Period_Remianing":
			attributeValue = getClaim_Pool2_Elimination_Period_Remianing();
			break;
		case "Claim_Pool1_Elimination_Period_MET_Date":
			attributeValue = getClaim_Pool1_Elimination_Period_MET_Date();
			break;
		case "Claim_Pool2_Elimination_Period_MET_Date":
			attributeValue = getClaim_Pool2_Elimination_Period_MET_Date();
			break;
		case "Claim_Premium_Waiver_Effective_Date":
			attributeValue = getClaim_Premium_Waiver_Effective_Date();
			break;
		default:
			System.err.println("Invalid Claim Attribute.");
			break;
		}

		return attributeValue;
	}

	public ArrayList<PartyRole> getClaimRoleList() {
		return claimRoleList;
	}

	public void printClaimDetails() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");
		System.out.println("Claim Number : " + this.getClaim_Number());
		System.out.println("Claim Status : " + this.getClaim_Status());
		System.out.println("Claim Sub-Status : " + this.getClaim_SubStatus());
		System.out.println("Claim Status Effective Date : " + this.getClaim_Status_Effective_Date());
		System.out.println("Claim Source : " + this.getClaim_Source());
		System.out.println("Claim Premium Waiver Effective Date : " + this.getClaim_Premium_Waiver_Effective_Date());

		System.out.println("Claim Pool 1 Name : " + this.getClaim_Pool1_Name());
		System.out.println("Claim Pool 1 Elimination Period : " + this.getClaim_Pool1_Elimination_Period());
		System.out.println(
				"Claim Pool 1 Elimination Period Credited : " + this.getClaim_Pool1_Elimination_Period_Credited());
		System.out.println(
				"Claim Pool 1 Elimination Period Remaining : " + this.getClaim_Pool1_Elimination_Period_Remianing());
		System.out.println(
				"Claim Pool 1 Elimination Period MET Date : " + this.getClaim_Pool1_Elimination_Period_MET_Date());

		System.out.println("Claim Pool 2 Name : " + this.getClaim_Pool2_Name());
		System.out.println("Claim Pool 2 Elimination Period : " + this.getClaim_Pool2_Elimination_Period());
		System.out.println(
				"Claim Pool 2 Elimination Period Credited : " + this.getClaim_Pool2_Elimination_Period_Credited());
		System.out.println(
				"Claim Pool 2 Elimination Period Remaining : " + this.getClaim_Pool2_Elimination_Period_Remianing());
		System.out.println(
				"Claim Pool 2 Elimination Period MET Date : " + this.getClaim_Pool2_Elimination_Period_MET_Date());

		for (PartyRole claimRole : this.getClaimRoleList()) {
			claimRole.printPartyRoleDetails();
		}

		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------");

	}

	public void setClaim_Number(String claim_Number) {
		Claim_Number = claim_Number;
	}

	public void setClaim_Pool1_Elimination_Period(String claim_Pool1_Elimination_Period) {
		Claim_Pool1_Elimination_Period = claim_Pool1_Elimination_Period;
	}

	public void setClaim_Pool1_Elimination_Period_Credited(String claim_Pool1_Elimination_Period_Credited) {
		Claim_Pool1_Elimination_Period_Credited = claim_Pool1_Elimination_Period_Credited;
	}

	public void setClaim_Pool1_Elimination_Period_MET_Date(String claim_Pool1_Elimination_Period_MET_Date) {
		Claim_Pool1_Elimination_Period_MET_Date = claim_Pool1_Elimination_Period_MET_Date;
	}

	public void setClaim_Pool1_Elimination_Period_Remianing(String claim_Pool1_Elimination_Period_Remianing) {
		Claim_Pool1_Elimination_Period_Remianing = claim_Pool1_Elimination_Period_Remianing;
	}

	public void setClaim_Pool1_Name(String claim_Pool1_Name) {
		Claim_Pool1_Name = claim_Pool1_Name;
	}

	public void setClaim_Pool2_Elimination_Period(String claim_Pool2_Elimination_Period) {
		Claim_Pool2_Elimination_Period = claim_Pool2_Elimination_Period;
	}

	public void setClaim_Pool2_Elimination_Period_Credited(String claim_Pool2_Elimination_Period_Credited) {
		Claim_Pool2_Elimination_Period_Credited = claim_Pool2_Elimination_Period_Credited;
	}

	public void setClaim_Pool2_Elimination_Period_MET_Date(String claim_Pool2_Elimination_Period_MET_Date) {
		Claim_Pool2_Elimination_Period_MET_Date = claim_Pool2_Elimination_Period_MET_Date;
	}

	public void setClaim_Pool2_Elimination_Period_Remianing(String claim_Pool2_Elimination_Period_Remianing) {
		Claim_Pool2_Elimination_Period_Remianing = claim_Pool2_Elimination_Period_Remianing;
	}

	public void setClaim_Pool2_Name(String claim_Pool2_Name) {
		Claim_Pool2_Name = claim_Pool2_Name;
	}

	public void setClaim_Premium_Waiver_Effective_Date(String claim_Premium_Waiver_Effective_Date) {
		Claim_Premium_Waiver_Effective_Date = claim_Premium_Waiver_Effective_Date;
	}

	public void setClaim_Source(String claim_Source) {
		Claim_Source = claim_Source;
	}

	public void setClaim_Status(String claim_Status) {
		Claim_Status = claim_Status;
	}

	public void setClaim_Status_Effective_Date(String claim_Status_Effective_Date) {
		Claim_Status_Effective_Date = claim_Status_Effective_Date;
	}

	public void setClaim_SubStatus(String claim_SubStatus) {
		Claim_SubStatus = claim_SubStatus;
	}

	public void setClaimRoleList(ArrayList<PartyRole> claimRoleList) {
		this.claimRoleList = claimRoleList;
	}

}
