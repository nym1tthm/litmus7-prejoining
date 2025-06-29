package com.litmus7.vrs.dto;

import java.util.Objects;

public class Vehicle {
    private String brand;
    private String model;
    private double rentalPricePerDay;
    private boolean rentalStatus = true; 

    public Vehicle(String brand, String model, double rentalPricePerDay) {
        this.brand = brand;
        this.model = model;
        this.rentalPricePerDay = rentalPricePerDay;
 
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public boolean getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(boolean rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    @Override
    public String toString() {
        return "brand=" + brand + ", " +
               "model=" + model + ", " +
               "rentalPricePerDay=" + rentalPricePerDay + ", " +
               "available=" + rentalStatus;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
        	return true;
        if (o == null || getClass() != o.getClass()) 
        	return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(brand, vehicle.brand)
                && Objects.equals(model, vehicle.model)
                && rentalPricePerDay == vehicle.rentalPricePerDay;
    }

    


}