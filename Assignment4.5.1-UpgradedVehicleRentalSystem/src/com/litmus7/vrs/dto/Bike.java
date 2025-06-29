package com.litmus7.vrs.dto;


/**
 * Represents a bike, a type of vehicle
 */
public class Bike extends Vehicle {
	private boolean hasGear;
	private int engineCapacity;

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
	 * Displays bike details
	 */
	@Override
    public String toString() {
        return "Bike {" + super.toString() +
                ", Has Gear: " + hasGear +
                ", Engine Capacity: " + engineCapacity + "cc}";
    }
}	
