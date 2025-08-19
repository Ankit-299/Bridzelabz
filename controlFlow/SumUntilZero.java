import java.util.Scanner;

public class SumUntilZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;
        double inputNumber;

        System.out.println("Enter numbers to sum (enter 0 to stop):");

        inputNumber = scanner.nextDouble();

        while (inputNumber != 0) {
            total += inputNumber;
            inputNumber = scanner.nextDouble();
        }

        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}
