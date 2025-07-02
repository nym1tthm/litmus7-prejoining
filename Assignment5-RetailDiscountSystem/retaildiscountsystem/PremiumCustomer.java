package retaildiscountsystem;

/*
 * class for premium customer implementing Discountable
 */
public class PremiumCustomer implements Discountable {
	private double discount;
	private double payableAmt;
	private double total;

	/*
	 * @Override calculates discount and payable amount for premium customer
	 */
	public double applyDiscount(double total) {
		this.total = total;
		if (total > 5000)
			discount = total * 10 / 100;
		else
			discount = total * 7 / 100;
		payableAmt = total - discount;
		return payableAmt;

	}

	public double getDiscount() {
		return discount;
	}

	public double getTotal() {
		return this.total;
	}

	public double getPayableAmt() {
		return payableAmt;
	}

}
