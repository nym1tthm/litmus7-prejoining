package com.litmus7.vrs.dto;

import java.util.List;


/*
 * DTO for response to user actions
 */
public class Response {
	public static int SUCCESS_FILE_RETRIEVED = 101;
    public static int ERROR_FILE_NOT_FOUND = 102;
    public static int SUCCESS_RENTAL = 201;
    public static int ERROR_RENTAL_INVALID = 202;

    private int statusCode;
    private String errorMessage;
    private List<Vehicle> vehicles;
    
    
    public int getStatusCode() { 
    	return statusCode; }
    
    public void setStatusCode(int statusCode) {
    	this.statusCode = statusCode; }

    public String getErrorMessage() {
    	return errorMessage; }
    
    public void setErrorMessage(String errorMessage) {
    	this.errorMessage = errorMessage; }

    public List<Vehicle> getVehicles() {
    	return vehicles; }
    
    public void setVehicles(List<Vehicle> vehicles) {
    	this.vehicles = vehicles; 
    }
}


