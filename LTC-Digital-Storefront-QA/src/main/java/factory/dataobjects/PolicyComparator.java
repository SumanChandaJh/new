package factory.dataobjects;

import java.util.Comparator;

public class PolicyComparator implements Comparator<Policy> {

	@Override
	public int compare(Policy o1, Policy o2) {

		int flag = 0;

		if (o1.getPolicy_Number() != null) {
			if (o2.getPolicy_Number() != null) {
				flag = o1.getPolicy_Number().compareTo(o2.getPolicy_Number());
			} else {
				flag = o1.getPolicy_Number().compareTo(o2.getCoverage_Id());
			}

		} else {
			if (o2.getCoverage_Id() != null) {
				flag = o1.getCoverage_Id().compareTo(o2.getCoverage_Id());
			} else {
				flag = o1.getCoverage_Id().compareTo(o2.getPolicy_Number());

			}
		}

		return flag;
	}

}
