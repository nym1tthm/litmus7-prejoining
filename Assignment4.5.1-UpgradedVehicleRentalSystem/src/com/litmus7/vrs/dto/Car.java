package com.litmus7.vrs.dto;


/**
 * Represents a car, which is a type of vehicle 
 */
public class Car extends Vehicle {
	private int numberOfDoors;
	private boolean isAutomatic;


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
	 * Displays car details 
	 */
	@Override
    public String toString() {
        return "Car {" + super.toString() +
                ", Number of Doors: " + numberOfDoors +
                ", Automatic: " + isAutomatic + "}";
    }
}

