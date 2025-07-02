package retaildiscountsystem;

/*
 * interface Discountable for different consumer classes to implement
 */
public interface Discountable {
	double getDiscount();

	double getPayableAmt();

	double getTotal();

	/*
	 * abstract method to be implemented by consumer classes
	 * @param totalAmount double which is total purchase cost
	 */
	public double applyDiscount(double totalAmount);

	/*
	 * display details
	 */
	default void show() {
		System.out.println("Customer Type: " + this.getClass().getSimpleName() + "\n" + "Original Amount: " + getTotal()
				+ "\nDiscount Applied: " + getDiscount() + "\nFinal Payable Amount: " + getPayableAmt());
	}

}
