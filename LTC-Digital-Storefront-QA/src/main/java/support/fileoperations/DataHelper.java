package support.fileoperations;

import java.util.ArrayList;
import java.util.List;

import factory.dataobjects.Claim;
import factory.dataobjects.PartyRole;

public class DataHelper {

	/**
	 * @param claimList
	 * 
	 * @param Claim_Number
	 * @return
	 */
	public static boolean claimPresentInList(List<Claim> claimList, String Claim_Number) {
		boolean exist = false;

		if (claimList != null) {
			for (Claim claim : claimList) {
				if (claim.getClaim_Number().equalsIgnoreCase(Claim_Number)) {
					exist = true;
					break;
				}
			}
		}

		return exist;
	}

	public static boolean isClaimRoleAdded(ArrayList<PartyRole> oldClaimRoleList,
			ArrayList<PartyRole> newClaimRoleList) {
		boolean added = false;

		if (oldClaimRoleList.size() != newClaimRoleList.size()) {
			added = true;
		}

		return added;
	}
}
