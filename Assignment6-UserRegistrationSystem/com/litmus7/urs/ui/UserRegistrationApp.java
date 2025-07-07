package com.litmus7.urs.ui;

import java.util.Scanner;

import com.litmus7.urs.controller.RegistrationController;
import com.litmus7.urs.dto.*;


public class UserRegistrationApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationController controller = new RegistrationController();

        System.out.println("--- User Registration ---");

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = new User(username,age,email,password);
        Response<User> response = controller.register(user);
        if (response.getStatusCode() == Response.SUCCESS_REGISTRATION) {
            User registeredUser = response.getData();
            System.out.println("Registration successful! User Details:");
            System.out.println("Username: " + registeredUser.getUsername());
            System.out.println("Age: " + registeredUser.getAge());
            System.out.println("Email: " + registeredUser.getEmail());
        } else {
            System.out.println("Error: " + response.getMessage());
            System.out.println("Registration failed.");
        }

        scanner.close();
    }
 }

