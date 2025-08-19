import java.util.Scanner;

public class NaturalSumWhileCompareNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n) to find the sum of natural numbers: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            long sumWhileLoop = 0;
            int counter = 1;
            while (counter <= n) {
                sumWhileLoop += counter;
                counter++;
            }

            long sumFormula = (long) n * (n + 1) / 2;

            System.out.println("Sum using while loop: " + sumWhileLoop);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumWhileLoop == sumFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in computations.");
            }
        }
        scanner.close();
    }
}
