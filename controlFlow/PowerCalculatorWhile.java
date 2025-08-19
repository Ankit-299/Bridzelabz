import java.util.Scanner;

public class PowerCalculatorWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the base number (positive integer): ");
        int number = scanner.nextInt();

        System.out.print("Enter the power (non-negative integer): ");
        int power = scanner.nextInt();

        if (number < 0) {
            System.out.println("Please enter a positive integer for the base number.");
        } else if (power < 0) {
            System.out.println("Please enter a non-negative integer for the power.");
        } else {
            long result = 1;
            int counter = 0;
            while (counter < power) {
                result *= number;
                counter++;
            }
            System.out.println(number + " raised to the power of " + power + " is: " + result);
        }
        scanner.close();
    }
}
