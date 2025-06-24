package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Represents a bike, a type of vehicle
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;

	/**
	 * Creates a default bike with 0cc engine and no gears.
	 */
	public Bike() {
		super();
		engineCapacity = 0;
		hasGear = false;
	}

	/**
	 * Parameterized constructor for details.
	 * 
	 * @param brand             Vehicle brand
	 * @param model             Vehicle model
	 * @param rentalPricePerDay Rental cost per day
	 * @param hasGear           Whether the bike has gears
	 * @param engineCapacity    Engine capacity in cc
	 */
	public Bike(String brand, String model, double rentalPricePerDay, boolean hasGear, int engineCapacity) {
		super(brand, model, rentalPricePerDay);
		this.engineCapacity = engineCapacity;
		this.hasGear = hasGear;
	}

	/**
	 * Takes input for bike details
	 * 
	 * @param scanner Scanner for user input
	 */
	public void inputDetails(Scanner scanner) {
		System.out.println("---Input bike details---");
		super.inputDetails(scanner);

		System.out.print("Does it have gears (true/false)?: ");
		hasGear = scanner.nextBoolean();
		scanner.nextLine();

		System.out.print("Enter engine capacity (cc): ");
		engineCapacity = scanner.nextInt();
		scanner.nextLine();
	}

	/**
	 * Displays bike details
	 */
	public void displayDetails() {
		System.out.println("---Displaying bike details---");
		super.displayDetails();
		System.out.println("Has gear: " + hasGear);
		System.out.println("Engine capacity: " + engineCapacity + "cc");
	}
}
