package com.litmus7.vrs.ui;

import java.util.List;
import java.util.Scanner;

import com.litmus7.vrs.controller.VehicleController;
import com.litmus7.vrs.dto.Bike;
import com.litmus7.vrs.dto.Car;
import com.litmus7.vrs.dto.Response;
import com.litmus7.vrs.dto.Vehicle;


/*
 * UI of the VRS  application
 */
public class VehicleApp {
	/*
	 * entry point
	 * @param String args[] command line arguments
	 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VehicleController controller = new VehicleController();

        System.out.print("Enter file name to load vehicles: ");
        String fileName = scanner.nextLine();

        Response loadResponse = controller.loadVehicles(fileName);
        if (loadResponse.getStatusCode() == Response.SUCCESS_FILE_RETRIEVED) {
            System.out.println("Vehicles loaded successfully.");
        } else {
            System.out.println("Error loading vehicles: " + loadResponse.getErrorMessage());
            scanner.close();
            return;
        }

        boolean exit = false;
        while (!exit) {
            System.out.println("\nVehicle Rental System Menu:");
            System.out.println("1. Display all vehicles");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a vehicle");
            System.out.println("4. Add new vehicle");
            System.out.println("5. Search vehicle by model");
            System.out.println("6. Calculate total rental price");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    Response allResponse = controller.getAllVehicles();
                    List<Vehicle> allVehicles = allResponse.getVehicles();
                    if (allVehicles != null && !allVehicles.isEmpty()) {
                        for (int i = 0; i < allVehicles.size(); i++) {
                            System.out.println("Vehicle #" + (i + 1) + ": " + allVehicles.get(i));
                        }
                    } else {
                        System.out.println("No vehicles found.");
                    }
                    break;

                case 2:
                    System.out.print("Enter vehicle ID to rent: ");
                    int rentId = scanner.nextInt();
                    Response rentResponse = controller.rentVehicle(rentId);
                    if (rentResponse.getStatusCode() == Response.SUCCESS_RENTAL) {
                        System.out.println("Vehicle rented successfully.");
                    } else {
                        System.out.println("Rental failed: " + rentResponse.getErrorMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter vehicle ID to return: ");
                    int returnId = scanner.nextInt();
                    Response returnResponse = controller.returnVehicle(returnId);
                    if (returnResponse.getStatusCode() == Response.SUCCESS_RENTAL) {
                        System.out.println("Vehicle returned successfully.");
                    } else {
                        System.out.println("Return failed: " + returnResponse.getErrorMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter vehicle type (Car/Bike): ");
                    String type = scanner.nextLine();
                    Vehicle newVehicle = null;
                    if (type.equalsIgnoreCase("Car")) {
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter rental price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Enter number of doors: ");
                        int doors = scanner.nextInt();
                        System.out.print("Is automatic? (true/false): ");
                        boolean auto = scanner.nextBoolean();
                        newVehicle = new Car(brand, model, price, doors, auto);
                    } else if (type.equalsIgnoreCase("Bike")) {
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter model: ");
                        String model = scanner.nextLine();
                        System.out.print("Enter rental price: ");
                        double price = scanner.nextDouble();
                        System.out.print("Has gear? (true/false): ");
                        boolean gear = scanner.nextBoolean();
                        System.out.print("Enter engine CC: ");
                        int cc = scanner.nextInt();
                        newVehicle = new Bike(brand, model, price, gear, cc);
                    } else {
                        System.out.println("Invalid vehicle type.");
                        break;
                    }

                    Response addResponse = controller.addVehicle(newVehicle);
                    if (addResponse.getStatusCode() == Response.SUCCESS_FILE_RETRIEVED) {
                        System.out.println("Vehicle added successfully.");
                    } else {
                        System.out.println("Add failed: " + addResponse.getErrorMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter model to search: ");
                    String searchModel = scanner.nextLine();
                    Response searchResponse = controller.searchVehicleByModel(searchModel);
                    if (searchResponse.getStatusCode() == Response.SUCCESS_FILE_RETRIEVED) {
                        List<Vehicle> found = searchResponse.getVehicles();
                        if (found != null && !found.isEmpty()) {
                            for (Vehicle v : found) {
                                System.out.println(v);
                            }
                        }
                    } else {
                        System.out.println("Search failed: " + searchResponse.getErrorMessage());
                    }
                    break;

                case 6:
                    double total = controller.calculateTotalRentalPrice();
                    System.out.println("Total rental price of all vehicles: " + total);
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting application.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }

        scanner.close();
    }
}
