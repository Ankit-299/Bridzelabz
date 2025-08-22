import java.util.Scanner;
import java.util.Arrays;
public class FactorFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek number enter karein jiske factors aapko dhundhne hain: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Kripya ek positive number enter karein.");
            System.exit(0);
        }

        int maxFactor = 10;
        int[] factors = new int[maxFactor];
        int factorIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) { // Check if 'i' is a factor
                // Check if array needs resizing
                if (factorIndex == maxFactor) {
                    maxFactor *= 2; // Double the size
                    int[] tempFactors = new int[maxFactor];
                    // Copy existing factors to the new, larger array
                    for (int j = 0; j < factors.length; j++) {
                        tempFactors[j] = factors[j];
                    }
                    factors = tempFactors; // Assign the new array
                }
                factors[factorIndex] = i; // Add the factor
                factorIndex++;
            }
        }

        System.out.print(number + " ke factors hain: [");
        for (int i = 0; i < factorIndex; i++) {
            System.out.print(factors[i]);
            if (i < factorIndex - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
