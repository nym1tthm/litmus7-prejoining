package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Entry point to the application
 */
public class VehicleApp {
	/**
	 * Main method to run the vehicle app.
	 * 
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String[] args) {
		Car myCar = new Car();
		Scanner scan = new Scanner(System.in);
		myCar.inputDetails(scan);
		myCar.displayDetails();

		Bike myBike = new Bike();
		myBike.inputDetails(scan);
		myBike.displayDetails();
	}
}
