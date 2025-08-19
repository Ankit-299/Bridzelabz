import java.util.Scanner;

public class FactorCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
        } else if (number == 1) {
            System.out.println("The greatest factor of 1 (besides itself) is 1.");
        }
        else {
            int greatestFactor = 1;
            int i = number - 1;
            while (i >= 1) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break;
                }
                i--;
            }
            System.out.println("The greatest factor of " + number + " (besides itself) is: " + greatestFactor);
        }
        scanner.close();
    }
}
