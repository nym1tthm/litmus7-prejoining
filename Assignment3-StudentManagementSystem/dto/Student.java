package com.litmus7.sms.dto;

import java.util.Scanner;

/* 'Student' class represents a student with a name,roll number ,and marks for 5 subjects.
 *  contains methods to input info, calculate total mark, mark average, grade obtained, and print report card.
 */
public class Student {
	private String name;
	private int rollNo;
	private int[] marks = new int[5];

	/*
	 * read student name, roll no and marks from the user.
	 * 
	 * @param scan Scanner object to read input
	 */
	public void inputDetails(Scanner scan) {

		System.out.println("Enter student name: ");
		name = scan.nextLine();

		System.out.println("Enter roll no: ");
		rollNo = Integer.parseInt(scan.nextLine());

		System.out.println("Enter marks for 5 subjects:");

		for (int i = 0; i < 5; i++) {
			System.out.println("Subject " + (i + 1) + ": ");
			marks[i] = Integer.parseInt(scan.nextLine());
		}
	}

	/*
	 * calculates and returns the total marks obtained by a student
	 * 
	 * @return Total marks in all 5 subjects
	 */
	public int calculateTotal() {
		int total = 0;
		for (int i = 0; i < 5; i++) {
			total += marks[i];
		}
		return total;
	}

	/*
	 * calculates and returns the average of a student's marks.
	 * 
	 * @return Average marks of all 5 subjects
	 */
	public double getAverage() {
		return calculateTotal() / 5.0;
	}

	/*
	 * returns grade of the student based on average marks.
	 * 
	 * @return Grade enum value (A,B,C etc)
	 */
	public Grade getGrade() {
		double avg = getAverage();

		if (avg >= 90)
			return Grade.A;
		else if (avg >= 75)
			return Grade.B;
		else if (avg >= 60)
			return Grade.C;
		else if (avg >= 50)
			return Grade.D;
		else
			return Grade.F;
	}

	/*
	 * prints the report card of a student
	 */
	public void printReportCard() {
		System.out.println("\nName: " + name);
		System.out.println("Roll Number :" + rollNo);
		System.out.println("Total Marks :" + calculateTotal());
		System.out.printf("Average Marks: %.2f\n", getAverage());
		System.out.println("Grade: " + getGrade());
	}

}
