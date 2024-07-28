import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Define the number of subjects
        int numberOfSubjects;
        System.out.print("Enter the number of subjects: ");
        numberOfSubjects = scanner.nextInt();

        // Array to store marks for each subject
        int[] marks = new int[numberOfSubjects];

        // Input marks for each subject
        System.out.println("Enter the marks obtained in each subject (out of 100):");
        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }

        // Calculate total marks
        int totalMarks = calculateTotalMarks(marks);

        // Calculate average percentage
        double averagePercentage = calculateAveragePercentage(totalMarks, numberOfSubjects);

        // Determine grade based on average percentage
        char grade = determineGrade(averagePercentage);

        // Display results
        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    // Function to calculate total marks
    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    // Function to calculate average percentage
    public static double calculateAveragePercentage(int totalMarks, int numberOfSubjects) {
        return (double) totalMarks / numberOfSubjects;
    }

    // Function to determine grade based on average percentage
    public static char determineGrade(double averagePercentage) {
        if (averagePercentage >= 80) {
            return 'A';
        } else if (averagePercentage >= 70) {
            return 'B';
        } else if (averagePercentage >= 60) {
            return 'C';
        } else if (averagePercentage >= 50) {
            return 'D';
        } else {
            return 'F';
        }
    }

    // Function to display results
    public static void displayResults(int totalMarks, double averagePercentage, char grade) {
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
