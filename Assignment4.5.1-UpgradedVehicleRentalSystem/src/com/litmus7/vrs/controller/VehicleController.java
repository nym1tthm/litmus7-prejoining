package com.litmus7.vrs.controller;

import java.util.List;
import java.util.Collections;
import com.litmus7.vrs.dto.Vehicle;
import com.litmus7.vrs.dto.Response;
import com.litmus7.vrs.exception.VehicleDataAccessException;
import com.litmus7.vrs.exception.VehicleServiceException;
import com.litmus7.vrs.service.VehicleService;

public class VehicleController {

    private VehicleService service = new VehicleService();

    public Response<List<Vehicle>> loadVehicles(String fileName) {
        Response<List<Vehicle>> response = new Response<>();
        try {
            List<Vehicle> vehicles = service.loadAllVehicles(fileName);
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
            response.setData(vehicles);
        } catch (VehicleDataAccessException e) {
            response.setStatusCode(Response.ERROR_FILE_NOT_FOUND);
            response.setErrorMessage(e.getMessage());
            response.setErrorDetails(getStackTrace(e));
        }
        return response;
    }

    public Response<List<Vehicle>> getAllVehicles() {
        Response<List<Vehicle>> response = new Response<>();
        List<Vehicle> vehicles = service.getAllVehicles();
        response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
        response.setData(vehicles);
        return response;
    }

    public Response<Void> rentVehicle(int vehicleId) {
        Response<Void> response = new Response<>();
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
            response.setErrorDetails(getStackTrace(e));
        }
        return response;
    }

    public Response<Void> returnVehicle(int vehicleId) {
        Response<Void> response = new Response<>();
        try {
            service.returnVehicle(vehicleId);
            response.setStatusCode(Response.SUCCESS_RENTAL);
        } catch (VehicleServiceException e) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage(e.getMessage());
            response.setErrorDetails(getStackTrace(e));
        }
        return response;
    }

    public Response<Void> addVehicle(Vehicle vehicle) {
        Response<Void> response = new Response<>();
        try {
            service.addNewVehicle(vehicle);
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
        } catch (VehicleServiceException e) {
            response.setStatusCode(Response.ERROR_RENTAL_INVALID);
            response.setErrorMessage(e.getMessage());
            response.setErrorDetails(getStackTrace(e));
        }
        return response;
    }

    public Response<List<Vehicle>> searchVehicleByModel(String model) {
        Response<List<Vehicle>> response = new Response<>();
        Vehicle found = service.searchVehicle(model);
        if (found != null) {
            response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
            response.setData(Collections.singletonList(found));
        } else {
            response.setStatusCode(Response.ERROR_FILE_NOT_FOUND);
            response.setErrorMessage("Vehicle not found: " + model);
        }
        return response;
    }

    public Response<Double> calculateTotalRentalPrice() {
        Response<Double> response = new Response<>();
        double total = service.calculateTotalRentalPrice();
        response.setStatusCode(Response.SUCCESS_FILE_RETRIEVED);
        response.setData(total);
        return response;
    }

    private String getStackTrace(Exception e) {
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement elem : e.getStackTrace()) {
            sb.append(elem.toString()).append("\n");
        }
        return sb.toString();
    }
}
