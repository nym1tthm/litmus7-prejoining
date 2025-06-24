package com.litmus7.vrs.dto;

import java.util.Scanner;

/**
 * Represents a generic vehicle with brand, model, and rental price.
 */
public class Vehicle {

	private String brand;
	private String model;
	private double rentalPricePerDay;
	private RentalStatus status;

	/**
	 * Creates a vehicle with default values.
	 */
	public Vehicle() {
		brand = "None";
		model = "None";
		rentalPricePerDay = 0.00;
		status = RentalStatus.available;
	}

	/**
	 * Creates a vehicle with specified brand, model, and rental price.
	 * 
	 * @param brand             Vehicle brand
	 * @param model             Vehicle model
	 * @param rentalPricePerDay Daily rental price
	 */
	public Vehicle(String brand, String model, double rentalPricePerDay) {
		this.brand = brand;
		this.model = model;
		this.rentalPricePerDay = rentalPricePerDay;
		this.status = RentalStatus.available;
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

	/*
	 * get rental status of vehicle
	 */
	public RentalStatus getStatus() {
		return status;
	}

	/*
	 * set rental status of vehicle
	 */
	public void setStatus(RentalStatus status) {
		this.status = status;
	}

	/*
	 * Return model of vehicle
	 */
	public String getModel() {
		return model;
	}

	/*
	 * Return rental rate of vehicle
	 */
	public double getRentalPricePerDay() {
		return rentalPricePerDay;
	}

	/**
	 * Displays vehicle details.
	 */
	public void displayDetails() {
		System.out.println("Brand :" + brand);
		System.out.println("Model :" + model);
		System.out.println("Rental Price :" + rentalPricePerDay);
		System.out.println("Status: " + status);
	}
}
