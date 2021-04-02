package factory.dataobjects;

public class PremiumPayment {

	private String policyNumber = null;
	private String premiumPaid = null;
	private String paymentDate = null;
	private String paymentType = null;
	
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPremiumPaid() {
		return premiumPaid;
	}
	public void setPremiumPaid(String premiumPaid) {
		this.premiumPaid = premiumPaid;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	@Override
	public String toString() {
		return "PremiumPayment [policyNumber=" + policyNumber + ", premiumPaid=" + premiumPaid + ", paymentDate="
				+ paymentDate + ", paymentType=" + paymentType + "]";
	}
	
}
