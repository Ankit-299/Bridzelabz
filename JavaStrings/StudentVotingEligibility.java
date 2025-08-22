import java.util.Scanner;

public class StudentVotingEligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = 10;

        int[] studentAges = collectStudentAges(scanner, numberOfStudents);

        String[][] eligibilityResults = determineVotingEligibility(studentAges);

        displayResultsTable(eligibilityResults);

        scanner.close();
    }

    public static int[] collectStudentAges(Scanner scanner, int numStudents) {
        int[] ages = new int[numStudents];
        System.out.println("Please enter the age for " + numStudents + " students:");

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter age for student " + (i + 1) + ": ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid integer for age.");
                scanner.next();
                System.out.print("Enter age for student " + (i + 1) + ": ");
            }
            ages[i] = scanner.nextInt();
        }
        return ages;
    }

    public static String[][] determineVotingEligibility(int[] ages) {
        String[][] eligibilityStatus = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            int currentAge = ages[i];
            String canVote;

            if (currentAge < 0) {
                canVote = "false (Invalid Age)";
            } else if (currentAge >= 18) {
                canVote = "true";
            } else {
                canVote = "false";
            }

            eligibilityStatus[i][0] = String.valueOf(currentAge);
            eligibilityStatus[i][1] = canVote;
        }
        return eligibilityStatus;
    }

    public static void displayResultsTable(String[][] results) {
        System.out.println("\n--- Student Voting Eligibility Results ---");
        System.out.printf("%-15s %-10s %-20s%n", "Student No.", "Age", "Can Vote?");
        System.out.println("-------------------------------------------------");

        for (int i = 0; i < results.length; i++) {
            String studentNumber = String.valueOf(i + 1);
            String age = results[i][0];
            String eligibility = results[i][1];
            System.out.printf("%-15s %-10s %-20s%n", studentNumber, age, eligibility);
        }
        System.out.println("-------------------------------------------------");
    }
}
