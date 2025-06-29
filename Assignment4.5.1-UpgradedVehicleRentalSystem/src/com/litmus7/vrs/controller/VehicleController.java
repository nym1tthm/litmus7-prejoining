package com.litmus7.vrs.controller;

import java.util.List;

import java.util.Collections;
import com.litmus7.vrs.dto.Vehicle;
import com.litmus7.vrs.dto.Response;
import com.litmus7.vrs.exception.VehicleDataAccessException;
import com.litmus7.vrs.exception.VehicleServiceException;
import com.litmus7.vrs.service.VehicleService;


/*
 * Control traffic and requests to service layer
 */
public class VehicleController {

    VehicleService service = new VehicleService();

    /*
     * Load vehicles from a file
     * @param fileName String  
     */
    public Response loadVehicles(String fileName) {
        Response response = new Response();
        try {
            List<Vehicle> vehicles = service.loadAllVehicles(fileName);
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
            response.setVehicles(vehicles);
        } catch (VehicleDataAccessException e) {
            response.setStatusCode(Response.ERROR_FILE_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /*
     * Get all vehicles
     */
    public Response getAllVehicles() {
        Response response = new Response();
        List<Vehicle> vehicles = service.getAllVehicles();
        response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
        response.setVehicles(vehicles);
        return response;
    }

    /*
     * Rent a vehicle
     */
    public Response rentVehicle(int vehicleId) {
        Response response = new Response();
        if (vehicleId <= 0) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage("Vehicle ID must be positive.");
            return response;  
        }
        try {
            service.rentVehicle(vehicleId);
            response.setStatusCode(Response.SUCCESS_RENTAL);
        } catch (VehicleServiceException e) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /*
     * Return a vehicle
     */
    public Response returnVehicle(int vehicleId) {
        Response response = new Response();
        try {
            service.returnVehicle(vehicleId);
            response.setStatusCode(Response.SUCCESS_RENTAL);
        } catch (VehicleServiceException e) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /*
     * Add a new vehicle
     */
    public Response addVehicle(Vehicle vehicle) {
        Response response = new Response();
        try {
            service.addNewVehicle(vehicle);
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
        } catch (VehicleServiceException e) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage(e.getMessage());
        }
        return response;
    }

    /*
     * Search vehicle by model
     */
    public Response searchVehicleByModel(String model) {
        Response response = new Response();
        Vehicle found = service.searchVehicle(model);
        if (found != null) {
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
            response.setVehicles(Collections.singletonList(found));
        } else {
            response.setStatusCode(Response.ERROR_FILE_NOT_FOUND);
            response.setErrorMessage("Vehicle not found: " + model);
        }
        return response;
    }



    /*
     * Calculate total rental price
     */
    public double calculateTotalRentalPrice() {
        return service.calculateTotalRentalPrice();
    }
}
