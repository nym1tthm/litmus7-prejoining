package com.litmus7.vrs.dto;

import java.util.Scanner;

/*
 * Main vehicle application 
 */
public class VehicleApp {
	/*
	 * main method for entry point into the app
	 * @param String args - command line arguments
	 */
    public static void main(String[] args) {
        VehicleService service = new VehicleService();
        service.fileToObject("vehicles.txt");
        
        System.out.println("Vehicles:\n");
        service.displayAllVehicles();

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter model to search: ");
        String keyword = scanner.nextLine();
        service.searchVehicles(keyword);

        
        double total = service.calculateTotalRentalPrice();
        System.out.println("\nTotal Rental Price of All Vehicles: $" + total);
        
        service.setVehicleStatus(6, RentalStatus.rented);
        
    }
}
