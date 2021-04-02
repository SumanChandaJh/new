package support.businesslogic;

import java.util.ArrayList;
import java.util.Collections;

import org.apache.log4j.Logger;

import factory.dataobjects.Claim;
import factory.dataobjects.Policy;
import factory.dataobjects.PolicyComparator;

public class DataUtility {

	private static Logger log = Logger.getLogger(DataUtility.class);

	public static boolean isGroupPolicy(Policy policy) {
		if ((policy.getPolicy_Type().equalsIgnoreCase(Constants.POLICY_TYPE_GROUP_DB))
				|| (policy.getPolicy_Type().equalsIgnoreCase(Constants.POLICY_TYPE_GROUP_SF))) {
			log.info("Policy in context is a group policy.");
			return true;
		}
		return false;
	}

	/**
	 * * Sort Policies based on the User Id
	 * 
	 * 
	 * @param userId
	 * @return ArrayList<Policy> - Sorted Policy List
	 */
	public static ArrayList<Policy> sortPolicyList(ArrayList<Policy> policyList) {

		// Temporary Policy List declaration
		ArrayList<Policy> paidPolList = new ArrayList<Policy>();
		ArrayList<Policy> actClPolList = new ArrayList<Policy>();
		ArrayList<Policy> inaClPolList = new ArrayList<Policy>();
		ArrayList<Policy> noClPolList = new ArrayList<Policy>();

		ArrayList<Policy> sortedPolList = new ArrayList<Policy>();

		ArrayList<Claim> claimList = null;

		int actPolicyCounter = 0;
		int inactPolicyCounter = 0;
		int paidUpPolicyCounter = 0;
		int groupPolicyCounter = 0;
		int retailPolicyCounter = 0;

		for (Policy policy : policyList) {
			claimList = policy.getClaimList();
			String coverageId = policy.getCoverage_Id();
			String policyNumber = policy.getPolicy_Number();

			if (coverageId != null) {
				groupPolicyCounter++;
				log.info("***Group Policy - Count: " + groupPolicyCounter + "***");
				log.info("Coverage id : " + policy.getCoverage_Id());
				log.info("Certificate_Status : " + policy.getCertificate_Status());

				if (policy.getCertificate_Status().equalsIgnoreCase("Inactive")) {
					inactPolicyCounter++;
				} else if (policy.getCertificate_Status().equalsIgnoreCase("Paid Up")) {
					paidUpPolicyCounter++;
				} else if (policy.getCertificate_Status().equalsIgnoreCase("Active")) {
					actPolicyCounter++;
				}

			} else if (policyNumber != null) {
				retailPolicyCounter++;
				log.info("***Retail Policy - Count: " + retailPolicyCounter + "***");
				log.info("Policy Number : " + policyNumber);
				log.info("Policy_Status : " + policy.getPolicy_Status());

				if (policy.getPolicy_Status().equalsIgnoreCase("Inactive")) {
					inactPolicyCounter++;
				} else if (policy.getPolicy_Status().equalsIgnoreCase("Paid Up")) {
					paidUpPolicyCounter++;
				} else if (policy.getPolicy_Status().equalsIgnoreCase("Active")) {
					actPolicyCounter++;
				}
			}

			int inactiveInt = 0;
			int terminatedInt = 0;
			int activeInt = 0;
			int noclaimInt = 0;
			int claimCounter = 0;

			if (claimList.size() > 0) {
				for (Claim claim : claimList) {
					String claimStatus = claim.getClaim_Status();
					log.info("claimStatus:" + claimStatus);
					if (claimStatus.equalsIgnoreCase("Active")) {
						activeInt++;
						claimCounter++;

					} else if (claimStatus.equalsIgnoreCase("Inactive")) {
						inactiveInt++;
						claimCounter++;

					} else if (claimStatus.equalsIgnoreCase("Terminated")) {
						terminatedInt++;
						claimCounter++;
					}
				}
			} else {
				noclaimInt++;
			}

			int claimListSize = policy.getClaimList().size();
			if (actPolicyCounter != 0 && activeInt != 0) {
				actClPolList.add(policy);
				Collections.sort(actClPolList, new PolicyComparator());

			} else if (actPolicyCounter != 0 && (inactiveInt != 0 || terminatedInt != 0)) {
				inaClPolList.add(policy);
				Collections.sort(inaClPolList, new PolicyComparator());

			} else if (actPolicyCounter != 0 && (noclaimInt != 0)) {
				noClPolList.add(policy);
				Collections.sort(noClPolList, new PolicyComparator());

			} else if (paidUpPolicyCounter != 0 && activeInt != 0) {
				actClPolList.add(policy);
				Collections.sort(actClPolList, new PolicyComparator());

			} else if (paidUpPolicyCounter != 0 && (inactiveInt != 0 || terminatedInt != 0)) {
				inaClPolList.add(policy);
				Collections.sort(paidPolList, new PolicyComparator());

			} else if (paidUpPolicyCounter != 0 && (noclaimInt != 0)) {
				noClPolList.add(policy);
				Collections.sort(noClPolList, new PolicyComparator());

			} else if (inactPolicyCounter != 0 && activeInt != 0) {
				inaClPolList.add(policy);
				Collections.sort(inaClPolList, new PolicyComparator());

			} else if (inactPolicyCounter != 0 && (inactiveInt != 0 || terminatedInt != 0)) {
				inaClPolList.add(policy);
				Collections.sort(inaClPolList, new PolicyComparator());

			} else if (inactPolicyCounter != 0 && (noclaimInt != 0)) {
				noClPolList.add(policy);
				Collections.sort(noClPolList, new PolicyComparator());
			}

			if (claimListSize == claimCounter) {
				actPolicyCounter = 0;
				inactPolicyCounter = 0;
				paidUpPolicyCounter = 0;
			}
		}

		for (Policy actPol : actClPolList) {
			sortedPolList.add(actPol);
		}

		for (Policy noPol : noClPolList) {
			sortedPolList.add(noPol);
		}

		for (Policy paidPol : paidPolList) {
			paidPolList.add(paidPol);
		}

		for (Policy inaPol : inaClPolList) {
			sortedPolList.add(inaPol);
		}

		return sortedPolList;
	}

}
