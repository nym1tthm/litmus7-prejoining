package com.litmus7.sms.dto;


import java.util.Scanner;

public class StudentApp {	
	public static void main(String[] args) {
	     Scanner scan = new Scanner(System.in);
	
	     System.out.print("How many students do you want to enter? ");
	     int count = Integer.parseInt(scan.nextLine());
	
	     Student[] students = new Student[count];
	
	     for (int i = 0; i < count; i++) {
	         System.out.println("\nEnter details for student " + (i + 1) );
	         students[i] = new Student();
	         students[i].inputDetails(scan);
	     }

	     for (Student s : students) {
	         s.printReportCard();
	     }
	
	     scan.close();
 }
}
