import java.util.Scanner;

public class SumUntilNonPositive {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;

        System.out.println("Enter numbers to sum (enter 0 or a negative number to stop):");

        while (true) {
            double inputNumber = scanner.nextDouble();
            if (inputNumber <= 0) {
                break;
            }
            total += inputNumber;
        }

        System.out.println("The total sum is: " + total);
        scanner.close();
    }
}
