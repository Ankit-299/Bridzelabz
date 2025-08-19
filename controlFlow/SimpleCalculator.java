import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double first;
        double second;
        String op;
        double result = 0.0;

        System.out.print("Enter first number: ");
        first = scanner.nextDouble();

        System.out.print("Enter second number: ");
        second = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /): ");
        op = scanner.next();

        switch (op) {
            case "+":
                result = first + second;
                System.out.println("Result: " + result);
                break;
            case "-":
                result = first - second;
                System.out.println("Result: " + result);
                break;
            case "*":
                result = first * second;
                System.out.println("Result: " + result);
                break;
            case "/":
                if (second != 0) {
                    result = first / second;
                    System.out.println("Result: " + result);
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                }
                break;
            default:
                System.out.println("Invalid Operator.");
                break;
        }

        scanner.close();
    }
}
