package retaildiscountsystem;

/*
 * class for regular customer implementing Discountable
 */
public class RegularCustomer implements Discountable {
	private double discount;
	private double payableAmt;
	private double total;

	/*
	 * @Override calculates discount and payable amount for regular customer
	 */
	public double applyDiscount(double total) {
		this.total = total;
		discount = total * 5 / 100;
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
