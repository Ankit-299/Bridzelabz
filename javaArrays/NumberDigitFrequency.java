import java.util.Scanner;

public class NumberDigitFrequency { // Class name changed here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek number enter karein jiske digits ki frequency dhundni hai: ");
        int number = scanner.nextInt();

        // Handle negative numbers by converting to positive for digit extraction
        int tempNumber = Math.abs(number);

        // Frequency array to store counts of digits from 0 to 9
        // Index represents the digit, value represents its frequency
        int[] frequency = new int[10]; // Size 10 for digits 0-9

        // Special case for number 0
        if (tempNumber == 0) {
            frequency[0]++; // Digit 0 occurs once
        } else {
            // Loop to extract digits and update frequency
            while (tempNumber > 0) {
                int digit = tempNumber % 10; // Get the last digit
                frequency[digit]++; // Increment frequency for this digit
                tempNumber /= 10; // Remove the last digit
            }
        }

        System.out.println("\n--- Digit Frequencies ---");
        // Display the frequency of each digit
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) { // Only display digits that appeared
                System.out.println("Digit " + i + ": " + frequency[i] + " baar aaya hai");
            }
        }

        scanner.close();
    }
}
