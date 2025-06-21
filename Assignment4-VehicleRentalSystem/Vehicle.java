package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Represents a generic vehicle with brand, model, and rental price.
 */
public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;

	/**
	 * Creates a vehicle with default values.
	 */
	public Vehicle() {
		brand = "None";
		model = "None";
		rentalPricePerDay = 0.00;
	}

	/**
	 * Creates a vehicle with specified brand, model, and rental price.
	 * 
	 * @param brand Vehicle brand
	 * @param model Vehicle model
	 * @param rentalPricePerDay Daily rental price
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
	}

	/**
	 * Takes input for vehicle details using a scanner.
	 * 
	 * @param scanner Scanner for user input
	 */
	public void inputDetails(Scanner scanner) {
		System.out.println("Enter brand:");
		brand = scanner.nextLine();

		System.out.println("Enter vehicle model:");
		model = scanner.nextLine();

		System.out.println("Enter vehicle rental price per day:");
		rentalPricePerDay = scanner.nextDouble();
		scanner.nextLine();
	}

	/**
	 * Displays vehicle details.
	 */
	public void displayDetails() {
		System.out.println("Brand :" + brand);
		System.out.println("Model :" + model);
		System.out.println("Rental Price :" + rentalPricePerDay);
	}
}
