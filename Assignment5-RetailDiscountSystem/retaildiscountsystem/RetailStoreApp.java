package retaildiscountsystem;

import java.util.Scanner;

/*
 * main application
 */
public class RetailStoreApp {
	/*
	 * Entry point of the retail app
	 * 
	 * @param command line args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter customer type (1- Regular, 2- Premium, 3- Wholesale): ");
		int choice = scan.nextInt();
		scan.nextLine();

		System.out.print("Enter total purchase amount: ");
		double totalPaid = scan.nextDouble();

		Discountable customer = null;

		switch (choice) {
		case 1:
			customer = new RegularCustomer();
			break;
		case 2:
			customer = new PremiumCustomer();
			break;
		case 3:
			customer = new WholesaleCustomer();
			break;
		default:
			System.out.println("Invalid choice. Exiting.");
			System.exit(0);
		}

		customer.applyDiscount(totalPaid);
		customer.show();
	}
}
