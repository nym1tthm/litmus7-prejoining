package com.litmus7.vrs.dao;

import java.io.*;
import java.util.*;
import com.litmus7.vrs.dto.*;
import com.litmus7.vrs.exception.VehicleDataAccessException;

/*
 * class to access file contents and load them as Vehicle objects
 */
public class VehicleFileDao {
	/*
	 * @param fileName String name of file.
	 * Convert txt file lines into Vehicle obj
	 */
    public List<Vehicle> loadVehiclesFromFile(String fileName) throws VehicleDataAccessException {
        List<Vehicle> vehicles = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(",");
                if (lineParts[0].equals("Car")) {
                    vehicles.add(new Car(
                        lineParts[1],
                        lineParts[2],
                        Double.parseDouble(lineParts[3]),
                        Integer.parseInt(lineParts[4]),
                        Boolean.parseBoolean(lineParts[5])));
                } else if (lineParts[0].equals("Bike")) {
                    vehicles.add(new Bike(
                        lineParts[1],
                        lineParts[2],
                        Double.parseDouble(lineParts[3]),
                        Boolean.parseBoolean(lineParts[4]),
                        Integer.parseInt(lineParts[5]))); }
            }
        } catch (IOException e) {
            throw new VehicleDataAccessException("Error accessing file: " + e.getMessage());
        }
        return vehicles;
    }
}