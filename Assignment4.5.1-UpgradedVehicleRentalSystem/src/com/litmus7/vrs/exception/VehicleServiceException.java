package com.litmus7.vrs.exception;


/*
 * exceptions exclusive to service class
 */

public class VehicleServiceException extends Exception {
	public VehicleServiceException(String message) {
        super(message);
    }
	public VehicleServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}


