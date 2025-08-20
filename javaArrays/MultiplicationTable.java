import java.util.Scanner;

public class MultiplicationTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter a number to print its multiplication table: ");
        int number;

        // User input ke liye validation
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break; // Valid input mil gaya
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid integer number.");
                System.out.print("Enter the number again: ");
            }
        }

        // Ek array banate hain results store karne ke liye (1 se 10 tak ke liye)
        int[] results = new int[10];

        System.out.println("\n--- Multiplication Table for " + number + " ---");

        // Loop chalate hain 1 se 10 tak
        for (int i = 1; i <= 10; i++) {
            results[i - 1] = number * i; // Result store karte hain array mein
            System.out.println(number + " * " + i + " = " + results[i - 1]); // Format mein display karte hain
        }

        scanner.close(); // Scanner ko close karna zaroori hai
    }
}
