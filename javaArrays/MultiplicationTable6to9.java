import java.util.Scanner;

public class MultiplicationTable6to9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number to print its multiplication table (from 6 to 9): ");
        int number;

        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer number.");
                System.out.print("Enter the number again: ");
            }
        }

        int[] multiplicationResult = new int[4];

        System.out.println("\n--- Multiplication Table for " + number + " (from 6 to 9) ---");

        for (int i = 6; i <= 9; i++) {
            multiplicationResult[i - 6] = number * i;
            System.out.println(number + " * " + i + " = " + multiplicationResult[i - 6]);
        }

        scanner.close();
    }
}
