package JavaPractice;

import java.util.*;

public class GradeCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double totalMarks = 0;
		int totalSubjects = 0;

		while (true) {
			try {
				System.out.print("Enter marks obtained in a subject (out of 100) or type 'done' to finish: ");
				String input = scanner.nextLine();

				if (input.equalsIgnoreCase("done")) {
					if (totalSubjects == 0) {
						System.out.println("No subjects entered. Exiting.");
						break;
					} else {
						double averagePercentage = totalMarks / totalSubjects;
						String grade = calculateGrade(averagePercentage);
						System.out.println("\nResults:");
						System.out.println("Total Marks: " + totalMarks);
						System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage));
						System.out.println("Grade: " + grade);
						break;
					}
				}

				double marks = Double.parseDouble(input);
				if (marks < 0 || marks > 100) {
					System.out.println("Invalid input! Marks should be between 0 and 100.");
					continue;
				}
				totalMarks += marks;
				totalSubjects++;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input! Please enter a valid number or 'done' to finish.");
			}
		}
		scanner.close();
	}

	public static String calculateGrade(double averagePercentage) {
		if (averagePercentage >= 90) {
			return "A+";
		} else if (averagePercentage >= 80) {
			return "A";
		} else if (averagePercentage >= 70) {
			return "B";
		} else if (averagePercentage >= 60) {
			return "C";
		} else if (averagePercentage >= 50) {
			return "D";
		} else {
			return "F";
		}
	}
}
