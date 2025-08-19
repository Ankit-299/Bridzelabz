import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();

        int originalNumber = number;
        int sumOfCubes = 0;
        int digit;

        if (number < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            while (originalNumber != 0) {
                digit = originalNumber % 10;
                sumOfCubes += Math.pow(digit, 3);
                originalNumber /= 10;
            }

            if (sumOfCubes == number) {
                System.out.println(number + " is an Armstrong number.");
            } else {
                System.out.println(number + " is not an Armstrong number.");
            }
        }
        scanner.close();
    }
}
