import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Physics marks: ");
        double physicsMarks = scanner.nextDouble();

        System.out.print("Enter Chemistry marks: ");
        double chemistryMarks = scanner.nextDouble();

        System.out.print("Enter Maths marks: ");
        double mathsMarks = scanner.nextDouble();

        double totalMarks = physicsMarks + chemistryMarks + mathsMarks;
        double averagePercentage = totalMarks / 3.0;

        String grade;
        String remarks;

        if (averagePercentage >= 80) {
            grade = "A";
            remarks = "Level 4, above agency-normalized standards";
        } else if (averagePercentage >= 70) {
            grade = "B";
            remarks = "Level 3, at agency-normalized standards";
        } else if (averagePercentage >= 60) {
            grade = "C";
            remarks = "Level 2, below, but approaching agency-normalized standards";
        } else if (averagePercentage >= 50) {
            grade = "D";
            remarks = "Level 1, well below agency-normalized standards";
        } else if (averagePercentage >= 40) {
            grade = "E";
            remarks = "Level 1-, too below agency-normalized standards";
        } else {
            grade = "R";
            remarks = "Remedial standards";
        }

        System.out.println("\nAverage Mark: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);

        scanner.close();
    }
}
