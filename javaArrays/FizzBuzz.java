import java.util.Scanner;

public class FizzBuzz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek positive integer enter karein FizzBuzz ke liye: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Kripya ek positive integer enter karein.");
            scanner.close();
            return;
        }

        String[] results = new String[number + 1]; // Size 'number + 1' to include 0 up to 'number'

        for (int i = 0; i <= number; i++) {
            if (i == 0) { // Handle 0 specifically, as it's often not part of FizzBuzz logic, or treated as plain number
                results[i] = String.valueOf(i);
            } else if (i % 3 == 0 && i % 5 == 0) {
                results[i] = "FizzBuzz";
            } else if (i % 3 == 0) {
                results[i] = "Fizz";
            } else if (i % 5 == 0) {
                results[i] = "Buzz";
            } else {
                results[i] = String.valueOf(i);
            }
        }

        System.out.println("\nFizzBuzz Results:");
        for (int i = 0; i < results.length; i++) {
            System.out.println("Position " + i + " = " + results[i]);
        }

        scanner.close();
    }
}
