package com.litmus7.vrs.dto;
import java.util.Scanner;

/**
 * Represents a car, which is a type of vehicle 
 */
public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;

	/**
	 * Creates a default car with 4 doors and manual transmission.
	 */
	public Car() {
		super();
		numberOfDoors = 4;
		isAutomatic = false;
	}

	/**
	 * Parameterized constructor for details.
	 * @param brand Vehicle brand
	 * @param model Vehicle model
	 * @param rentalPricePerDay Rental cost per day
	 * @param numberOfDoors Number of doors
	 * @param isAutomatic Whether the car is automatic
	 */
	public Car(String brand, String model, double rentalPricePerDay, int numberOfDoors, boolean isAutomatic) {
		super(brand, model, rentalPricePerDay);
		this.numberOfDoors = numberOfDoors;
		this.isAutomatic = isAutomatic;
	}

	/**
	 * Takes input for car details 
	 * @param scanner Scanner for user input
	 */
	public void inputDetails(Scanner scanner) {
		System.out.println("---Input car details---");
		super.inputDetails(scanner);
		System.out.print("Number of doors: ");
		numberOfDoors = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Is it automatic? (true/false): ");
		isAutomatic = scanner.nextBoolean();
		scanner.nextLine();
	}

	/**
	 * Displays car details 
	 */
	public void displayDetails() {
		System.out.println("---Displaying car details---");
		super.displayDetails();
		System.out.println("Number of doors :" + numberOfDoors);
		System.out.println("Automatic :" + isAutomatic);
	}
}

