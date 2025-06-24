package com.litmus7.vrs.dto;

import java.io.*;
import java.util.*;

/*
 * Service class for the vehicle app which 
 * loads vehicle data from given txt file ,
 * displays all vehicle data ,
 * allows user to search for a given vehicle using model name,
 * calculate total rental price of all vehicles
 */
public class VehicleService {

	List<Vehicle> vehicles = new ArrayList<>();
	Map<Integer, Vehicle> vehicleMap = new HashMap<>();
	
	/*
	 * Converts text file lines into corresponding Vehicle objects and assign properties
	 */

	public void fileToObject(String fileName) {
		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String line;
			int id = 1;

			while ((line = reader.readLine()) != null) {
				String[] parts = line.split(",");

				if (parts[0].equals("Car")) {
					String brand = parts[1];
					String model = parts[2];
					double rentalPrice = Double.parseDouble(parts[3]);
					int doors = Integer.parseInt(parts[4]);
					boolean isAuto = Boolean.parseBoolean(parts[5]);
					Car car = new Car(brand, model, rentalPrice, doors, isAuto);
					vehicles.add(car);
					vehicleMap.put(id++, car);

				} else if (parts[0].equals("Bike")) {
					String brand = parts[1];
					String model = parts[2];
					double rentalPrice = Double.parseDouble(parts[3]);
					boolean hasGear = Boolean.parseBoolean(parts[4]);
					int engineCc = Integer.parseInt(parts[5]);
					Bike bike = new Bike(brand, model, rentalPrice, hasGear, engineCc);
					vehicles.add(bike);
					vehicleMap.put(id++, bike);
				}
			}
		} catch (IOException e) {
			System.out.println("Error loading vehicles: " + e.getMessage());
		}
	}

	/*
	 * Return information of all Vehicle objects 
	 */

	public void displayAllVehicles() {
		int i = 1;
		for (Vehicle v : vehicles) {
			System.out.println("Vehicle #" + i);
			v.displayDetails();
			i = i + 1;
			System.out.println();
		}
	}

	/*
	 * Return a  vehicle details if user input model String is found
	 * @param model String which is to be searched in teh record
	 */
	public void searchVehicles(String searchModel) {
		boolean found = false;
		for (Vehicle v : vehicles) {
			if (v.getModel().equals(searchModel)) {
				found = true;
				v.displayDetails();
				break;
			}
		}
		if (found == false)
			System.out.println("Not found");
	}

	/*
	 * return total rental price of all vehicles
	 */
	public double calculateTotalRentalPrice() {
		double total = 0.0;
		for (Vehicle v : vehicles) {
			total += v.getRentalPricePerDay();
		}
		return total;
	}
	/*
	 * Set rental status of a vehicle using vehicle id
	 */
	public void setVehicleStatus(int vehicleId, RentalStatus newStatus) {
		Vehicle v = vehicleMap.get(vehicleId);
		if (v != null) {
			v.setStatus(newStatus);
			System.out.println("Status updated for Vehicle #" + vehicleId);
			v.displayDetails();
		} else {
			System.out.println("Vehicle ID not found.");
		}
	}
}
