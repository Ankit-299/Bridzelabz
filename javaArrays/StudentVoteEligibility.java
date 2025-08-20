import java.util.Scanner;
import java.util.ArrayList;

public class StudentVoteEligibility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> studentAges = new ArrayList<>();
        int numStudents = 10;

        System.out.println(numStudents + " students ki age enter karein:");

        for (int i = 0; i < numStudents; i++) {
            while (true) {
                System.out.print("Student " + (i + 1) + " ki age enter karein: ");
                try {
                    int age = Integer.parseInt(scanner.nextLine());
                    studentAges.add(age);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number for age.");
                }
            }
        }

        System.out.println("\n--- Voting Eligibility Results ---");

        for (int i = 0; i < studentAges.size(); i++) {
            int age = studentAges.get(i);
            if (age < 0) {
                System.out.println("Student " + (i + 1) + " (Age: " + age + "): Invalid age. Age cannot be negative.");
            } else if (age >= 18) {
                System.out.println("Student " + (i + 1) + " (Age: " + age + "): The student with the age " + age + " can vote. ✅");
            } else {
                System.out.println("Student " + (i + 1) + " (Age: " + age + "): The student with the age " + age + " cannot vote. ❌");
            }
        }

        scanner.close();
    }
}
