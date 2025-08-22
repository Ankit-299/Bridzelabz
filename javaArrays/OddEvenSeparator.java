import java.util.Scanner;

public class OddEvenSeparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek natural number enter karein: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Kripya ek natural number (greater than 0) enter karein.");
            System.exit(0);
        }

        int oddSize = number / 2 + (number % 2);
        int evenSize = number / 2;

        double[] oddNumbers = new double[oddSize];
        double[] evenNumbers = new double[evenSize];

        int oddIndex = 0;
        int evenIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenNumbers[evenIndex] = i;
                evenIndex++;
            } else {
                oddNumbers[oddIndex] = i;
                oddIndex++;
            }
        }

        System.out.print("Odd Numbers: [");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print((int)oddNumbers[i]);
            if (i < oddIndex - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        System.out.print("Even Numbers: [");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print((int)evenNumbers[i]);
            if (i < evenIndex - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
