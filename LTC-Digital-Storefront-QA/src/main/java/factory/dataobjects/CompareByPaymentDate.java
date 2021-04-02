package factory.dataobjects;

import java.util.Comparator;

public class CompareByPaymentDate implements Comparator<PremiumPayment>{

	@Override
	public int compare(PremiumPayment payment1, PremiumPayment payment2) {
		// TODO Auto-generated method stub
		return payment1.getPaymentDate().compareTo(payment2.getPaymentDate());
	}

}
