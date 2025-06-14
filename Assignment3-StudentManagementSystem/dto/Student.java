package com.litmus7.sms.dto;
import java.util.Scanner;

public class Student {
	private String name;
	private int rollNo;
	private int[] marks = new int[5];
	
	public void inputDetails(Scanner scan) {
		
		System.out.println("Enter student name: ");
		name = scan.nextLine();
		
		System.out.println("Enter roll no: ");
		rollNo = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter marks for 5 subjects:");

		for (int i = 0 ; i < 5 ; i++) {
			System.out.println("Subject " + (i + 1) + ": ");
			marks[i] = Integer.parseInt(scan.nextLine());
		}	
	}
	
	public int calculateTotal() {
		int total = 0;
		for (int i = 0 ; i < 5; i++) {
			total += marks[i];
		}
		return total;	
	}
	
	public double getAverage() {
        return calculateTotal() / 5.0;
    }
	
	public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 60) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    public void printReportCard() {
        System.out.println("\nName: " + name);
        System.out.println("Roll Number :" + rollNo);
        System.out.println("Total Marks :" + calculateTotal());
        System.out.printf("Average Marks: %.2f\n", getAverage());
        System.out.println("Grade: " + getGrade());
    }
	
}
