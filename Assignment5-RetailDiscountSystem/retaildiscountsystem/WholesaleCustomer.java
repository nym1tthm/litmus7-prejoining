package retaildiscountsystem;

/*
 * class for wholesale customers implementing Discountable 
 */
public class WholesaleCustomer implements Discountable {
	private double discount;
	private double payableAmt;
	private double total;

	/*
	 * @Override calculates discount and payable amount for wholesale customer
	 */
	public double applyDiscount(double total) {
		this.total = total;
		if (total > 10000)
			discount = total * 15 / 100;
		else
			discount = total * 10 / 100;
		payableAmt = total - discount;
		return payableAmt;

	}

	public double getTotal() {
		return this.total;
	}

	public double getDiscount() {
		return discount;
	}

	public double getPayableAmt() {
		return payableAmt;
	}
}
