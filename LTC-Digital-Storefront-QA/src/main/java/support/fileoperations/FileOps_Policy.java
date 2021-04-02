package support.fileoperations;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import General.Settings;
import factory.dataobjects.Claim;
import factory.dataobjects.PartyRole;
import factory.dataobjects.Policy;
import support.businesslogic.Constants;

public class FileOps_Policy {

	private static Properties settings = Settings.getInstance();
	private static Logger log = Logger.getLogger(FileOps_Policy.class);

	/**
	 * This function will read the
	 * /policy_claim_data/<Environment_Name>/policy_claim.xlsx and return Policy
	 * which will have the attached Claim and Claim Role informations
	 * 
	 * @param policyNumber
	 * @return Policy
	 */
	public static Policy getDetailsForPolicy(String policyNumber) {
		Policy policy = new Policy();
		String filePath = settings.getProperty("POLICY_CLAIM_DATA");
		FileInputStream fileIn;

		try {

			fileIn = new FileInputStream(new File(filePath));
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(fileIn);
			XSSFSheet sheet = null;
			sheet = workbook.getSheetAt(0);

			// Policy Info
			int Index_PolicyNumber = FileOps_Common.getColumnIndex("Policy_Number", filePath);
			int Index_PolicyType = FileOps_Common.getColumnIndex("Policy_Type", filePath);
			int Index_PolicyStatus = FileOps_Common.getColumnIndex("Policy_Status", filePath);
			int Index_ClientName = FileOps_Common.getColumnIndex("Client_Name", filePath);
			int Index_ProductName = FileOps_Common.getColumnIndex("Product_Name", filePath);

			// Claim Info
			int Index_ClaimNumber = FileOps_Common.getColumnIndex("Claim_Number", filePath);
			int Index_ClaimStatus = FileOps_Common.getColumnIndex("Claim_Status", filePath);
			int Index_ClaimSubStatus = FileOps_Common.getColumnIndex("Claim_SubStatus", filePath);
			int Index_ClaimSource = FileOps_Common.getColumnIndex("Claim_Source", filePath);
			int Index_ClaimStatusDate = FileOps_Common.getColumnIndex("Claim_Status_Effective_Date", filePath);
			int Index_ClaimPremWaiverEffDate = FileOps_Common.getColumnIndex("Claim_Prem_Waiver_Effective_Date",
					filePath);

			// EP Pool 1 Info
			int Index_Pool1_Name = FileOps_Common.getColumnIndex("Pool1_Name", filePath);
			int Index_Pool1_Elimination_Period = FileOps_Common.getColumnIndex("Pool1_Elimination_Period", filePath);
			int Index_Pool1_Elimination_Period_Credited = FileOps_Common
					.getColumnIndex("Pool1_Elimination_Period_Credited", filePath);
			int Index_Pool1_Elimination_Period_Remaining = FileOps_Common
					.getColumnIndex("Pool1_Elimination_Period_Remaining", filePath);
			int Index_Pool1_Elimination_Period_MET_Date = FileOps_Common
					.getColumnIndex("Pool1_Elimination_Period_MET_Date", filePath);

			// EP Pool 2 Info
			int Index_Pool2_Name = FileOps_Common.getColumnIndex("Pool2_Name", filePath);
			int Index_Pool2_Elimination_Period = FileOps_Common.getColumnIndex("Pool2_Elimination_Period", filePath);
			int Index_Pool2_Elimination_Period_Credited = FileOps_Common
					.getColumnIndex("Pool2_Elimination_Period_Credited", filePath);
			int Index_Pool2_Elimination_Period_Remaining = FileOps_Common
					.getColumnIndex("Pool2_Elimination_Period_Remaining", filePath);
			int Index_Pool2_Elimination_Period_MET_Date = FileOps_Common
					.getColumnIndex("Pool2_Elimination_Period_MET_Date", filePath);

			// Party Role Info
			int Index_Role = FileOps_Common.getColumnIndex("Party_Role", filePath);
			int Index_Role_FullName = FileOps_Common.getColumnIndex("Role_Full_Name", filePath);
			int Index_Role_UUID = FileOps_Common.getColumnIndex("Role_UUID", filePath);
			int Index_Role_Status = FileOps_Common.getColumnIndex("Role_Status", filePath);
			int Index_Role_Type = FileOps_Common.getColumnIndex("Role_Type", filePath);
			int Index_ProviderOnline_Status = FileOps_Common.getColumnIndex("Provider_Online_Status", filePath);

			Iterator<Row> rowIterator = sheet.iterator();
			ArrayList<Claim> claimList = new ArrayList<Claim>();
			ArrayList<Claim> tempClaimList = new ArrayList<Claim>();
			Claim claim = new Claim();

			int policyFound = 0;
			int claimFound = 0;
			int claimRoleFound = 0;
			ArrayList<PartyRole> claimRoleList = new ArrayList<PartyRole>();
			ArrayList<PartyRole> tempclaimRoleList = new ArrayList<PartyRole>();
			ArrayList<PartyRole> list_PolicyRole = new ArrayList<PartyRole>();

			while (rowIterator.hasNext()) {
				DataFormatter formatter = new DataFormatter();
				Row row = rowIterator.next();
				String Policy_Number = formatter
						.formatCellValue(row.getCell(Index_PolicyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));
				String Claim_Number = formatter
						.formatCellValue(row.getCell(Index_ClaimNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));
				String Policy_Type = formatter
						.formatCellValue(row.getCell(Index_PolicyType, MissingCellPolicy.CREATE_NULL_AS_BLANK));

				if (Policy_Number.equalsIgnoreCase(policyNumber)) {
					String PolicyType = formatter
							.formatCellValue(row.getCell(Index_PolicyType, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String PolicyStatus = formatter
							.formatCellValue(row.getCell(Index_PolicyStatus, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String ClientName = formatter
							.formatCellValue(row.getCell(Index_ClientName, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String ProductName = formatter
							.formatCellValue(row.getCell(Index_ProductName, MissingCellPolicy.CREATE_NULL_AS_BLANK));

					if ((Policy_Type.equalsIgnoreCase("Group"))
							|| (Policy_Type.equalsIgnoreCase("LTC Group Certificate"))) {

						if (policyFound == 0) {
							policy.setCoverage_Id(Policy_Number);
							policy.setPolicy_Type(Policy_Type);
							policy.setCertificate_Status(PolicyStatus);
							policy.setProduct_Name(ProductName);
							// policy.setPremium_PaidThruDate(Reusable.getFormattedDate(PremPaidThruDate));
							policy.setClient_Name(ClientName);
							policyFound++;
						}

					} else if ((Policy_Type.equalsIgnoreCase("Retail"))
							|| (Policy_Type.equalsIgnoreCase("LTC Retail Policy"))) {

						if (policyFound == 0) {
							policy.setPolicy_Number(Policy_Number);
							policy.setPolicy_Type(Policy_Type);
							policy.setPolicy_Status(PolicyStatus);
							policy.setProduct_Name(ProductName);
							// policy.setPremium_PaidThruDate(Reusable.getFormattedDate(PremPaidThruDate));
							policyFound++;
						}

					} else if ((!Policy_Type.equalsIgnoreCase("Retail") || (!Policy_Type.equalsIgnoreCase("Group")))) {
						System.out.println("Policy Type is Unknown - " + PolicyType.toString());
						break;

					} else {
						System.out.println("Incorrect test data ");
						break;
					}

					String role_FullName = formatter
							.formatCellValue(row.getCell(Index_Role_FullName, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String role = formatter
							.formatCellValue(row.getCell(Index_Role, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String role_UUID = formatter
							.formatCellValue(row.getCell(Index_Role_UUID, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String role_Status = formatter
							.formatCellValue(row.getCell(Index_Role_Status, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					String role_Type = formatter
							.formatCellValue(row.getCell(Index_Role_Type, MissingCellPolicy.CREATE_NULL_AS_BLANK));

					if (!Claim_Number.isEmpty()) {

						String ClaimStatus = formatter.formatCellValue(
								row.getCell(Index_ClaimStatus, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String ClaimSubStatus = formatter.formatCellValue(
								row.getCell(Index_ClaimSubStatus, MissingCellPolicy.CREATE_NULL_AS_BLANK));

						String ClaimStatusDate = formatter.formatCellValue(
								row.getCell(Index_ClaimStatusDate, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String ClaimPremWaiverEffDate = formatter.formatCellValue(
								row.getCell(Index_ClaimPremWaiverEffDate, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool1_Name = formatter
								.formatCellValue(row.getCell(Index_Pool1_Name, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool1_EliminationPeriod = formatter.formatCellValue(
								row.getCell(Index_Pool1_Elimination_Period, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool1_EliminationPeriod_Credited = formatter.formatCellValue(row.getCell(
								Index_Pool1_Elimination_Period_Credited, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool1_EliminationPeriod_Remaining = formatter.formatCellValue(row.getCell(
								Index_Pool1_Elimination_Period_Remaining, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool1_EliminationPeriod_MET_Date = formatter.formatCellValue(row.getCell(
								Index_Pool1_Elimination_Period_MET_Date, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool2_Name = formatter
								.formatCellValue(row.getCell(Index_Pool2_Name, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool2_EliminationPeriod = formatter.formatCellValue(
								row.getCell(Index_Pool2_Elimination_Period, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool2_EliminationPeriod_Credited = formatter.formatCellValue(row.getCell(
								Index_Pool2_Elimination_Period_Credited, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool2_EliminationPeriod_Remaining = formatter.formatCellValue(row.getCell(
								Index_Pool2_Elimination_Period_Remaining, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Pool2_EliminationPeriod_MET_Date = formatter.formatCellValue(row.getCell(
								Index_Pool2_Elimination_Period_MET_Date, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String Claim_Source = formatter.formatCellValue(
								row.getCell(Index_ClaimSource, MissingCellPolicy.CREATE_NULL_AS_BLANK));
						String onlineStatus = formatter.formatCellValue(
								row.getCell(Index_ProviderOnline_Status, MissingCellPolicy.CREATE_NULL_AS_BLANK));

						claimRoleFound = 0;

						if (!DataHelper.claimPresentInList(tempClaimList, Claim_Number)) {

							claim = new Claim();
							claim.setClaim_Number(Claim_Number);
							claim.setClaim_Source(Claim_Source);
							claim.setClaim_SubStatus(ClaimSubStatus);
							claim.setClaim_Status(ClaimStatus);
							// claim.setClaim_Status_Effective_Date(Reusable.getFormattedDate(ClaimStatusDate));

							/*
							 * claim.setClaim_Premium_Waiver_Effective_Date(
							 * Reusable.getFormattedDate(ClaimPremWaiverEffDate));
							 */

							// Setting Claim Roles Details
							claimRoleList = new ArrayList<PartyRole>();
							PartyRole currentClaimRole = new PartyRole();
							/*
							 * currentClaimRole.setRole_FullName(role_FullName);
							 * currentClaimRole.setAssociatedClaim(Claim_Number);
							 * currentClaimRole.setRoleUUID(role_UUID);
							 * currentClaimRole.setRoleType(role_Type);
							 * 
							 * currentClaimRole.setProvider_Online_Status(onlineStatus);
							 */
							claim.setClaim_Pool1_Name(Pool1_Name);
							claim.setClaim_Pool1_Elimination_Period(Pool1_EliminationPeriod);
							claim.setClaim_Pool1_Elimination_Period_Credited(Pool1_EliminationPeriod_Credited);
							claim.setClaim_Pool1_Elimination_Period_Remianing(Pool1_EliminationPeriod_Remaining);
							/*
							 * claim.setClaim_Pool1_Elimination_Period_MET_Date(
							 * Reusable.getFormattedDate(Pool1_EliminationPeriod_MET_Date));
							 */

							claim.setClaim_Pool2_Name(Pool2_Name);
							claim.setClaim_Pool2_Elimination_Period(Pool2_EliminationPeriod);
							claim.setClaim_Pool2_Elimination_Period_Credited(Pool2_EliminationPeriod_Credited);
							claim.setClaim_Pool2_Elimination_Period_Remianing(Pool2_EliminationPeriod_Remaining);
							/*
							 * claim.setClaim_Pool2_Elimination_Period_MET_Date(
							 * Reusable.getFormattedDate(Pool2_EliminationPeriod_MET_Date));
							 */
							/*
							 * currentClaimRole.setRole(role); currentClaimRole.setRoleStatus(role_Status);
							 */

							claimRoleList.add(currentClaimRole);
							claimRoleFound++;
							tempClaimList.add(claim);
							claimFound++;

						} else {

							tempclaimRoleList = claimRoleList;
							PartyRole currentClaimRole = new PartyRole();
							/*
							 * currentClaimRole.setRole_FullName(role_FullName);
							 * currentClaimRole.setAssociatedClaim(Claim_Number);
							 * currentClaimRole.setRoleUUID(role_UUID);
							 * currentClaimRole.setRoleType(role_Type); currentClaimRole.setRole(role);
							 * currentClaimRole.setRoleStatus(role_Status);
							 * currentClaimRole.setProvider_Online_Status(onlineStatus);
							 */

							claimRoleList.add(currentClaimRole);
							if (DataHelper.isClaimRoleAdded(tempclaimRoleList, claimRoleList)) {
								claimRoleFound++;
							} else {
								claimRoleFound = 0;
							}
						}

						if (claimFound != 0) {
							if (claimRoleFound != 0) {
								claim.setClaimRoleList(claimRoleList);
								claimList.add(claim);
							}
						}
					}

					// Adding Policy Roles
					PartyRole currentPolicyRole = new PartyRole();

					if (role_Type.equalsIgnoreCase(Constants.ROLE_TYPE_DB_POLICY)
							|| (role_Type.equalsIgnoreCase(Constants.ROLE_TYPE_SF_POLICY))) {
						/*
						 * currentPolicyRole.setRole_FullName(role_FullName);
						 * currentPolicyRole.setRoleUUID(role_UUID);
						 * currentPolicyRole.setRoleType(Constants.ROLE_TYPE_DB_POLICY);
						 * currentPolicyRole.setRoleStatus(role_Status);
						 * currentPolicyRole.setRole(role);
						 * currentPolicyRole.setAssociatedPolicy(policyNumber);
						 */
						list_PolicyRole.add(currentPolicyRole);
					}
				}

				// If Policy Number Not Found then return null
				if (policyFound != 0) {
					System.out.println("Adding policy roles = " + list_PolicyRole.size());

					policy.setPolicyRoleList(list_PolicyRole);
					if (claimFound != 0) {
						policy.setClaimList(claimList);

					}

				} else {
					System.out.println("Policy Number : " + policyNumber + " not found in " + filePath);
					return null;
				}

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// return Policy
		return policy;
	}

	public static boolean isGroupPolicy(String policyType) {
		if (policyType.trim().equalsIgnoreCase("Group")) {
			return true;
		}
		return false;
	}

	public static boolean isSingleClaimUser(Policy policy) {
		ArrayList<Claim> claims = policy.getClaimList();
		if (claims.size() == 1) {
			return true;
		}
		return false;
	}

	private FileOps_Policy() {
	}

}
