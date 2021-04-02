package support.fileoperations;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import General.Settings;
import factory.dataobjects.Claim;
import factory.dataobjects.PartyRole;
import factory.dataobjects.Policy;
import support.businesslogic.AppVariables;
import support.businesslogic.Constants;

public class FileOps_Common {

	public final static String COMMON_DATA = "\\Data\\common\\Property_Manager.xlsx";
	private static Properties settings = Settings.getInstance();
	private static Logger log = Logger.getLogger(FileOps_Common.class);
	private static String filePath;
	private static String projectPath = new File(System.getProperty("user.dir")).getAbsolutePath();

	private static ArrayList<Claim> assignRoleToClaims(ArrayList<Claim> claimList,
			ArrayList<PartyRole> list_ClaimRole) {

		ArrayList<Claim> mergedClaimList = new ArrayList<Claim>();

		for (int index_i = 0; index_i < claimList.size(); index_i++) {
			Claim currentClaim = claimList.get(index_i);
			ArrayList<PartyRole> currentRoleList = new ArrayList<PartyRole>();

			for (int index = 0; index < list_ClaimRole.size(); index++) {

				PartyRole currentRole = list_ClaimRole.get(index);
				if (currentRole.getAssociated_claim().contentEquals(currentClaim.getClaim_Number())) {
					currentRoleList.add(currentRole);
					// list_ClaimRole.remove(index);
				}
			}
			currentClaim.setClaimRoleList(currentRoleList);
			mergedClaimList.add(currentClaim);
		}
		return mergedClaimList;
	}

	/**
	 * The code snippet returns column index of a column name If unable to locate
	 * the column name then return -1 else return the column index
	 * 
	 * @param columnNameString
	 *            - String
	 * @param filePath
	 *            - String
	 * @return columnIndex
	 */
	@SuppressWarnings("resource")
	public static int getColumnIndex(String columnNameString, String filePath) {
		FileInputStream file;
		int colNum = -1;
		try {
			file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row row1 = sheet.getRow(0);
			for (int i = 0; i <= row1.getLastCellNum(); i++) {
				Cell currentCell = row1.getCell(i);
				String currentCellValue = currentCell.getStringCellValue();
				if (currentCellValue.contentEquals(columnNameString)) {
					colNum = i;
					return colNum;
				}
			}
		} catch (Exception e) {
			log.error("Exception occured. Unable to fetch column number for input Column name : " + columnNameString);
		}
		return colNum;
	}

	/**
	 * This function will read the policy_claim.xlsx and return Policy which will
	 * have the attached Claim and Claim Role informations
	 * 
	 * @param policyNumber
	 * @return Policy
	 */
	@SuppressWarnings("resource")
	public static Policy getDetailsForPolicy(String policyNumber) {
		Policy policy = new Policy();

		try {
			String fileLocation = settings.getProperty("POLICY_CLAIM_DATA");
			fileLocation = fileLocation.replaceAll("#1", AppVariables.ENVIRONMENT);
			filePath = projectPath + fileLocation;
			System.err.println("filePath" + filePath);
			FileInputStream fileIn = new FileInputStream(new File(filePath));
			XSSFSheet sheet = new XSSFWorkbook(fileIn).getSheetAt(0);

			int Index_PolicyNumber = FileOps_Common.getColumnIndex("Policy_Number", filePath);
			int Index_ClaimNumber = FileOps_Common.getColumnIndex("Claim_Number", filePath);
			Iterator<Row> rowIterator = sheet.iterator();

			log.info("Total row count :" + sheet.getLastRowNum());

			boolean isPolicyDetailsCaptured = false;
			ArrayList<Claim> claimList = new ArrayList<Claim>();
			ArrayList<PartyRole> list_PolicyRole = new ArrayList<PartyRole>();
			ArrayList<PartyRole> list_ClaimRole = new ArrayList<PartyRole>();

			while (rowIterator.hasNext()) {
				DataFormatter formatter = new DataFormatter();
				Row row = rowIterator.next();

				String Policy_Number = formatter
						.formatCellValue(row.getCell(Index_PolicyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));

				if (Policy_Number.equalsIgnoreCase(policyNumber)) {

					// capturing Policy Details on current row if not already captured
					if (!isPolicyDetailsCaptured) {
						policy = readCurrentRowForPolicy(row);
						isPolicyDetailsCaptured = true;
					}

					String Claim_Number = formatter
							.formatCellValue(row.getCell(Index_ClaimNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));

					// Claim Details are present on current row
					if (!Claim_Number.isEmpty()) {

						// capturing claim details of claim on current row if not captured
						if (!DataHelper.claimPresentInList(claimList, Claim_Number)) {
							Claim claim = new Claim();
							claim = readCurrentRowForClaim(row);
							claimList.add(claim);
						}

						// capturing claim role details on current row if not already captured
						PartyRole role = new PartyRole();
						role = readCurrentRowForClaimRole(row);
						if (!isRolePresentInList(list_ClaimRole, role)) {
							list_ClaimRole.add(role);
						}

					} else {
						// capturing policy role details on current row if not already captured
						PartyRole role = new PartyRole();
						role = readCurrentRowForClaimRole(row);
						if (!isRolePresentInList(list_PolicyRole, role)) {
							list_PolicyRole.add(role);
						}
					}
				}
			}

			policy.setClaimList(assignRoleToClaims(claimList, list_ClaimRole));
			policy.setPolicyRoleList(list_PolicyRole);

			// To see if policy is correctly captured, use below code
			policy.printPolicyDetails();

		} catch (Exception e) {
			log.error("Exception occured in reading file for Policy Claim Details. ");
			e.printStackTrace();
		}
		return policy;

	}

	public static String getInsuredForPolicy(String policy_Number) {
		PartyRole insured = new PartyRole();

		try {
			String fileLocation = settings.getProperty("POLICY_CLAIM_DATA");
			fileLocation = fileLocation.replaceAll("#1", AppVariables.ENVIRONMENT);
			filePath = projectPath + fileLocation;
			FileInputStream fileIn;
			fileIn = new FileInputStream(new File(filePath));
			XSSFSheet sheet = new XSSFWorkbook(fileIn).getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			int Index_PolicyNumber = FileOps_Common.getColumnIndex("Policy_Number", filePath);
			int index_Insured_Name = FileOps_Common.getColumnIndex("Insured_Name", filePath);

			while (rowIterator.hasNext()) {
				DataFormatter formatter = new DataFormatter();
				Row row = rowIterator.next();

				String Policy_Number = formatter
						.formatCellValue(row.getCell(Index_PolicyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));

				if (Policy_Number.contentEquals(policy_Number)) {
					String Insured_Name = formatter
							.formatCellValue(row.getCell(index_Insured_Name, MissingCellPolicy.CREATE_NULL_AS_BLANK));
					/*
					 * if (role_name.contentEquals("Insured")) { insured =
					 * readCurrentRowForClaimRole(row); break; }
					 */
					return Insured_Name;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";

	}

	/**
	 * 
	 * @param rowIndex
	 * @param colIndex
	 * @param columnValue
	 * @param filePath
	 */
	@SuppressWarnings("resource")
	public static String getValueFromExcel(String filePath, int rowIndex, int colIndex) {

		try {

			boolean lookUpFlag = false;
			String fetchedValue = Constants.EMPTY_STRING;
			Row row = null;
			FileInputStream file = new FileInputStream(new File(filePath));
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			XSSFSheet sheet = workbook.getSheetAt(0);

			if (rowIndex > -1 && colIndex > -1) {

				if (sheet.getRow(rowIndex) != null) {
					row = sheet.getRow(rowIndex);
					lookUpFlag = true;
				} else {
					lookUpFlag = false;
				}

				Cell cell = row.getCell(colIndex);

				if (cell != null) {
					cell = row.getCell(colIndex);
					lookUpFlag = true;
				} else {
					lookUpFlag = false;
				}

				if (lookUpFlag) {
					DataFormatter formatter = new DataFormatter();
					fetchedValue = formatter.formatCellValue(cell);
					log.info("Fetched Value from Excel :" + fetchedValue);
					return fetchedValue;
				} else {
					log.error("Unable to locate cell with Row : " + rowIndex + " Column : " + colIndex
							+ " in filepath :" + filePath);
				}
			} else {
				log.error("Cannot find a cell with Row Index :" + rowIndex + " and Column Index :" + colIndex);
			}
		} catch (IOException e) {
			log.error("I/O Exception - " + filePath);
		}
		return Constants.EMPTY_STRING;
	}

	private static boolean isRolePresentInList(ArrayList<PartyRole> list_ClaimRole, PartyRole role) {
		if (!list_ClaimRole.isEmpty()) {
			for (PartyRole currentRole : list_ClaimRole) {
				if (currentRole.getAssociated_claim().contentEquals(role.getAssociated_claim())) {
					if (currentRole.getRole_name().contentEquals(role.getRole_name())) {
						if (currentRole.getParty_UUID().contentEquals(role.getParty_UUID())) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	private static Claim readCurrentRowForClaim(Row row) {
		Claim claim = new Claim();
		DataFormatter formatter = new DataFormatter();

		// Claim Info
		String Claim_Number = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Claim_Number", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String ClaimStatus = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Claim_Status", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String ClaimSubStatus = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Claim_SubStatus", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String ClaimStatusDate = formatter
				.formatCellValue(row.getCell(FileOps_Common.getColumnIndex("Claim_Status_Effective_Date", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String ClaimPremWaiverEffDate = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Claim_Prem_Waiver_Effective_Date", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Claim_Source = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Claim_Source", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));

		// EP1 Information
		String Pool1_Name = formatter.formatCellValue(row.getCell(FileOps_Common.getColumnIndex("Pool1_Name", filePath),
				MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool1_EliminationPeriod = formatter
				.formatCellValue(row.getCell(FileOps_Common.getColumnIndex("Pool1_Elimination_Period", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool1_EliminationPeriod_Credited = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool1_Elimination_Period_Credited", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool1_EliminationPeriod_Remaining = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool1_Elimination_Period_Remaining", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool1_EliminationPeriod_MET_Date = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool1_Elimination_Period_MET_Date", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));

		// EP Pool 2 Info
		String Pool2_Name = formatter.formatCellValue(row.getCell(FileOps_Common.getColumnIndex("Pool2_Name", filePath),
				MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool2_EliminationPeriod = formatter
				.formatCellValue(row.getCell(FileOps_Common.getColumnIndex("Pool2_Elimination_Period", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool2_EliminationPeriod_Credited = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool2_Elimination_Period_Credited", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool2_EliminationPeriod_Remaining = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool2_Elimination_Period_Remaining", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Pool2_EliminationPeriod_MET_Date = formatter.formatCellValue(
				row.getCell(FileOps_Common.getColumnIndex("Pool2_Elimination_Period_MET_Date", filePath),
						MissingCellPolicy.CREATE_NULL_AS_BLANK));

		claim.setClaim_Number(Claim_Number);
		claim.setClaim_Source(Claim_Source);
		claim.setClaim_SubStatus(ClaimSubStatus);
		claim.setClaim_Status(ClaimStatus);
		claim.setClaim_Status_Effective_Date(ClaimStatusDate);
		claim.setClaim_Premium_Waiver_Effective_Date(ClaimPremWaiverEffDate);

		claim.setClaim_Pool1_Name(Pool1_Name);
		claim.setClaim_Pool1_Elimination_Period(Pool1_EliminationPeriod);
		claim.setClaim_Pool1_Elimination_Period_Credited(Pool1_EliminationPeriod_Credited);
		claim.setClaim_Pool1_Elimination_Period_Remianing(Pool1_EliminationPeriod_Remaining);
		claim.setClaim_Pool1_Elimination_Period_MET_Date(Pool1_EliminationPeriod_MET_Date);

		claim.setClaim_Pool2_Name(Pool2_Name);
		claim.setClaim_Pool2_Elimination_Period(Pool2_EliminationPeriod);
		claim.setClaim_Pool2_Elimination_Period_Credited(Pool2_EliminationPeriod_Credited);
		claim.setClaim_Pool2_Elimination_Period_Remianing(Pool2_EliminationPeriod_Remaining);
		claim.setClaim_Pool2_Elimination_Period_MET_Date(Pool2_EliminationPeriod_MET_Date);

		return claim;
	}

	private static PartyRole readCurrentRowForClaimRole(Row row) {
		PartyRole role = new PartyRole();
		DataFormatter formatter = new DataFormatter();

		String Policy_Number = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Policy_Number", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Claim_Number = formatter.formatCellValue(row.getCell(
				FileOps_Common.getColumnIndex("Claim_Number", filePath), MissingCellPolicy.CREATE_NULL_AS_BLANK));
		// Party Role Info
		int Index_Role = FileOps_Common.getColumnIndex("Party_Role", filePath);
		int Index_Role_FullName = FileOps_Common.getColumnIndex("Role_Full_Name", filePath);
		int Index_Role_UUID = FileOps_Common.getColumnIndex("Role_UUID", filePath);
		int Index_Role_Status = FileOps_Common.getColumnIndex("Role_Status", filePath);
		int Index_Role_Type = FileOps_Common.getColumnIndex("Role_Type", filePath);
		int Index_Provider_Online_Status = FileOps_Common.getColumnIndex("Provider_Online_Status", filePath);

		String role_FullName = formatter
				.formatCellValue(row.getCell(Index_Role_FullName, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String roleName = formatter.formatCellValue(row.getCell(Index_Role, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String role_UUID = formatter
				.formatCellValue(row.getCell(Index_Role_UUID, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String role_Status = formatter
				.formatCellValue(row.getCell(Index_Role_Status, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String role_Type = formatter
				.formatCellValue(row.getCell(Index_Role_Type, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Provider_Online_Status = formatter
				.formatCellValue(row.getCell(Index_Provider_Online_Status, MissingCellPolicy.CREATE_NULL_AS_BLANK));

		role.setAssociated_policy(Policy_Number);
		role.setAssociated_claim(Claim_Number);
		role.setParty_UUID(role_UUID);
		role.setParty_full_name(role_FullName);
		role.setRole_type(role_Type);
		role.setRole_name(roleName);
		role.setRole_status(role_Status);
		role.setProvider_online_status(Provider_Online_Status);

		return role;
	}

	private static Policy readCurrentRowForPolicy(Row row) {
		Policy policy = new Policy();
		DataFormatter formatter = new DataFormatter();

		// Policy Info
		int Index_PolicyNumber = FileOps_Common.getColumnIndex("Policy_Number", filePath);
		int Index_PolicyType = FileOps_Common.getColumnIndex("Policy_Type", filePath);
		int Index_PolicyStatus = FileOps_Common.getColumnIndex("Policy_Status", filePath);
		int Index_ClientName = FileOps_Common.getColumnIndex("Client_Name", filePath);
		int Index_ProductName = FileOps_Common.getColumnIndex("Product_Name", filePath);
		int Index_Policy_Prem_Paid_Thru_Date = FileOps_Common.getColumnIndex("Policy_Prem_Paid_Thru_Date", filePath);

		String Policy_Number = formatter
				.formatCellValue(row.getCell(Index_PolicyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Policy_Type = formatter
				.formatCellValue(row.getCell(Index_PolicyType, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Policy_Status = formatter
				.formatCellValue(row.getCell(Index_PolicyStatus, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Client_Name = formatter
				.formatCellValue(row.getCell(Index_ClientName, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Product_Name = formatter
				.formatCellValue(row.getCell(Index_ProductName, MissingCellPolicy.CREATE_NULL_AS_BLANK));
		String Policy_Prem_Paid_Thru_Date = formatter
				.formatCellValue(row.getCell(Index_Policy_Prem_Paid_Thru_Date, MissingCellPolicy.CREATE_NULL_AS_BLANK));

		if ((Policy_Type.equalsIgnoreCase(Constants.POLICY_TYPE_GROUP_DB))
				|| (Policy_Type.equalsIgnoreCase(Constants.POLICY_TYPE_GROUP_SF))) {

			policy.setCoverage_Id(Policy_Number);
			policy.setPolicy_Type(Policy_Type);
			policy.setCertificate_Status(Policy_Status);
			policy.setProduct_Name(Product_Name);
			policy.setPremium_PaidThruDate(Policy_Prem_Paid_Thru_Date);
			policy.setClient_Name(Client_Name);

		} else if ((Policy_Type.equalsIgnoreCase(Constants.POLICY_TYPE_RETAIL_DB))
				|| (Policy_Type.equalsIgnoreCase(Constants.POLICY_TYPE_RETAIL_SF))) {

			policy.setPolicy_Number(Policy_Number);
			policy.setPolicy_Type(Policy_Type);
			policy.setPolicy_Status(Policy_Status);
			policy.setProduct_Name(Product_Name);
			policy.setPremium_PaidThruDate(Policy_Prem_Paid_Thru_Date);
		}

		return policy;
	}

	public static ArrayList<Policy> readPolicyForUser(String user_full_name) {
		ArrayList<String> uniquePolicyNumberList = new ArrayList<String>();
		ArrayList<Policy> uniquePolicyList = new ArrayList<Policy>();

		try {
			filePath = projectPath + settings.getProperty("POLICY_CLAIM_DATA");
			FileInputStream fileIn;
			fileIn = new FileInputStream(new File(filePath));
			XSSFSheet sheet = new XSSFWorkbook(fileIn).getSheetAt(0);

			Iterator<Row> rowIterator = sheet.iterator();
			int index_role_full_name = FileOps_Common.getColumnIndex("Role_Full_Name", filePath);
			int Index_PolicyNumber = FileOps_Common.getColumnIndex("Policy_Number", filePath);
			int Index_InsuredName = FileOps_Common.getColumnIndex("Insured_Name", filePath);

			while (rowIterator.hasNext()) {
				DataFormatter formatter = new DataFormatter();
				Row row = rowIterator.next();
				String role_FullName = formatter
						.formatCellValue(row.getCell(index_role_full_name, MissingCellPolicy.CREATE_NULL_AS_BLANK));

				String Policy_Number = formatter
						.formatCellValue(row.getCell(Index_PolicyNumber, MissingCellPolicy.CREATE_NULL_AS_BLANK));

				if (role_FullName.equalsIgnoreCase(user_full_name)) {
					// System.out.println("Role name matched");
					if (!uniquePolicyNumberList.contains(Policy_Number)) {
						// System.out.println("Policy number is unique");
						Policy policy = readCurrentRowForPolicy(row);

						String Insured_Name = formatter.formatCellValue(
								row.getCell(Index_InsuredName, MissingCellPolicy.CREATE_NULL_AS_BLANK));

						policy.setInsuredFullName(Insured_Name);

						uniquePolicyList.add(policy);
						uniquePolicyNumberList.add(Policy_Number);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return uniquePolicyList;
	}

}
