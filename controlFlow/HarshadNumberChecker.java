import java.util.Scanner;

public class HarshadNumberChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int sumOfDigits = 0;
        int tempNumber = number;

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            while (tempNumber != 0) {
                int digit = tempNumber % 10;
                sumOfDigits += digit;
                tempNumber /= 10;
            }

            if (originalNumber % sumOfDigits == 0) {
                System.out.println(originalNumber + " is a Harshad Number.");
            } else {
                System.out.println(originalNumber + " is not a Harshad Number.");
            }
        }
        scanner.close();
    }
}
