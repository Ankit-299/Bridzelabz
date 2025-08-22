import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kitne students ka data enter karna hai? ");
        int numberOfStudents = scanner.nextInt();

        // Arrays to store marks, percentages, and grades
        // Columns: 0=Physics, 1=Chemistry, 2=Maths
        double[][] marks = new double[numberOfStudents][3];
        double[] percentages = new double[numberOfStudents];
        String[] grades = new String[numberOfStudents];

        // Take input for marks of students with validation
        System.out.println("Kripya har student ke Physics, Chemistry, aur Maths ke marks enter karein (0-100 ke beech mein):");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nStudent " + (i + 1) + " ke marks:");
            for (int j = 0; j < 3; ) { // Loop for 3 subjects
                String subjectName = "";
                if (j == 0) subjectName = "Physics";
                else if (j == 1) subjectName = "Chemistry";
                else if (j == 2) subjectName = "Maths";

                System.out.print(subjectName + " marks enter karein: ");
                double currentMarks = scanner.nextDouble();

                if (currentMarks >= 0 && currentMarks <= 100) {
                    marks[i][j] = currentMarks;
                    j++; // Move to next subject only if input is valid
                } else {
                    System.out.println("Invalid input: Marks 0 aur 100 ke beech mein hone chahiye. Kripya dobara enter karein.");
                }
            }
        }

        // Calculate percentage and grade for each student
        for (int i = 0; i < numberOfStudents; i++) {
            double totalMarks = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = (totalMarks / 300.0) * 100; // Assuming each subject is out of 100

            // Determine grade based on percentage
            if (percentages[i] >= 80) {
                grades[i] = "A";
            } else if (percentages[i] >= 70) {
                grades[i] = "B";
            } else if (percentages[i] >= 60) {
                grades[i] = "C";
            } else if (percentages[i] >= 50) {
                grades[i] = "D";
            } else if (percentages[i] >= 40) {
                grades[i] = "E";
            } else {
                grades[i] = "R"; // Remedial
            }
        }

        // Display the results for each student
        System.out.println("\n--- Student Results ---");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s %-10s%n", "Student", "Physics", "Chemistry", "Maths", "Percentage", "Grade");
        System.out.println("-------------------------------------------------------------------------------------------------");
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%-10d %-10.2f %-11.2f %-10.2f %-15.2f %-10s%n",
                              (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------------------");

        scanner.close();
    }
}
