package com.litmus7.vrs.service;

import java.util.*;
import com.litmus7.vrs.dao.VehicleFileDao;
import com.litmus7.vrs.dto.*;
import com.litmus7.vrs.exception.*;

/*
 * Service class for the vehicle app which 
 * loads vehicle data from given txt file ,
 * displays all vehicle data ,
 * allows user to search for a given vehicle using model name,
 * calculate total rental price of all vehicles
 */
public class VehicleService {

	VehicleFileDao dao = new VehicleFileDao();
	List<Vehicle> vehicles = new ArrayList<>();
	Map<Integer, Vehicle> vehicleMap = new HashMap<>();
	
	/*
	 * @param fileName string of the txt file to be read
	 * load vehicles using loadVehicleFromFile method in dao class and puts them into map<int,Vehicle>
	 * return vehicle list
	 */

	public List<Vehicle> loadAllVehicles(String fileName) throws VehicleDataAccessException {
        List<Vehicle> loadedVehicles = dao.loadVehiclesFromFile(fileName);
        this.vehicles = loadedVehicles;
        vehicleMap.clear();
        int i = 1;
        for (Vehicle v : vehicles) {
            vehicleMap.put(i++, v);
        }
        return vehicles;
    }
	

	/*
	 * get all vehicles
	 */
	public List<Vehicle> getAllVehicles() {
        return vehicles;
    }
	
	/*
	 * add new vehicle
	 */
	 public void addNewVehicle(Vehicle vehicle) throws VehicleServiceException {
	        if (vehicleMap.containsValue(vehicle)) {
	            throw new VehicleServiceException("Cannot add duplicate vehicle: " + vehicle.getModel());
	        }
	        int newId = vehicleMap.size() + 1;
	        vehicleMap.put(newId, vehicle);
	        vehicles.add(vehicle);
	    }
	
	/*
	 * rent a vehicle by vehicle number
	 * @param vehicleNumber int to indicate vehicle to rent
	 */
	public void rentVehicle(int vehicleNumber) throws VehicleServiceException{
        Vehicle v = vehicleMap.get(vehicleNumber);
        if (v == null) {
            throw new VehicleServiceException("Invalid vehicle number.");
        }
        if (!v.getRentalStatus()) {
            throw new VehicleServiceException("Vehicle is already rented and not available.");
        }
        v.setRentalStatus(false);

    }
	/*
	 * return rented vehicle
	 * @param vehicleNumber int to indicate vehicle to return
	 */
	public void returnVehicle(int vehicleNumber) throws VehicleServiceException {
        Vehicle v = vehicleMap.get(vehicleNumber);
        if (v == null) {
            throw new VehicleServiceException("Vehicle not found: " + vehicleNumber);
        }
        if (v.getRentalStatus()) {
            throw new VehicleServiceException("Vehicle is already marked as available.");
        }
        v.setRentalStatus(true);
    }
	
	

	/*
	 * Return a  vehicle details if user input model String is found
	 * @param model String which is to be searched in the record
	 */
	public Vehicle searchVehicle(String searchModel) {
		for (Vehicle v : vehicles) {
			if (v.getModel().equals(searchModel)) {
				return v;
			}
		}	
		return null;
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
	
	
	
}
