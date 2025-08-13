import java.util.Scanner;

public class PowerCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the base number:");
        double base = input.nextDouble();

        System.out.println("Enter the exponent:");
        double exponent = input.nextDouble();

        // Using Math.pow() to calculate base raised to the power of exponent
        double result = Math.pow(base, exponent);

        System.out.println("Result: " + result);

        input.close();
    }
}
