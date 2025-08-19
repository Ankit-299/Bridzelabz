import java.util.Scanner;

public class NaturalSumForCompareNew {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n) to find the sum of natural numbers: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            long sumForLoop = 0;
            for (int i = 1; i <= n; i++) {
                sumForLoop += i;
            }

            long sumFormula = (long) n * (n + 1) / 2;

            System.out.println("Sum using for loop: " + sumForLoop);
            System.out.println("Sum using formula: " + sumFormula);

            if (sumForLoop == sumFormula) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in computations.");
            }
        }
        scanner.close();
    }
}
