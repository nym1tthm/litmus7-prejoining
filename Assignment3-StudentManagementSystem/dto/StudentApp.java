package com.litmus7.sms.dto;

import java.util.Scanner;

/*  
 * StudentApp class is for the entry point of the application.
 * Allows the user to input and display details of multiple students and their report card.
 */
public class StudentApp {
	/*
	 * Contains main method to prompt the user for the number of students, collects
	 * their details, and displays the report card for each student.
	 * 
	 * @param args Command-line arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.print("How many students do you want to enter? ");
		int count = Integer.parseInt(scan.nextLine());

		Student[] students = new Student[count];

		for (int i = 0; i < count; i++) {
			System.out.println("\nEnter details for student " + (i + 1));
			students[i] = new Student();
			students[i].inputDetails(scan);
		}

		for (Student student : students) {
			student.printReportCard();
		}

		scan.close();
	}
}
