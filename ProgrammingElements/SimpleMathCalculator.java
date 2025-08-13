import java.util.Scanner;

public class SimpleMathCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number1;
        double number2;

        System.out.println("Enter the first floating-point number:");
        number1 = input.nextDouble();

        System.out.println("Enter the second floating-point number:");
        number2 = input.nextDouble();

        double sum = number1 + number2;
        double difference = number1 - number2;
        double product = number1 * number2;
        double quotient;

        if (number2 != 0) {
            quotient = number1 / number2;
        } else {
            System.out.println("Division by zero is not allowed.");
            quotient = Double.NaN;
        }

        System.out.println("The addition, subtraction, multiplication and division value of 2 numbers " + number1 + " and " + number2 + " is " + sum + ", " + difference + ", " + product + ", and " + quotient);

        input.close();
    }
}
