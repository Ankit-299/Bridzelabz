import java.util.Scanner;

public class DivisionCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number1;
        int number2;

        System.out.println("Enter the first number (dividend):");
        number1 = input.nextInt();

        System.out.println("Enter the second number (divisor):");
        number2 = input.nextInt();

        if (number2 != 0) {
            int quotient = number1 / number2;
            int remainder = number1 % number2;

            System.out.println("The Quotient is " + quotient + " and Reminder is " + remainder + " of two number " + number1 + " and " + number2);
        } else {
            System.out.println("Error: Cannot divide by zero.");
        }

        input.close();
    }
}
