import java.util.Scanner;

public class DigitAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek number enter karein: ");
        int number = scanner.nextInt();

        // Max size for the array of digits as per hint
        int maxDigit = 10;
        int[] digits = new int[maxDigit];
        int index = 0; // Current index for the digits array

        // Store digits in the array
        int tempNumber = number; // Use a temporary variable to manipulate the number
        if (tempNumber == 0) { // Handle case for input 0
            if (index < maxDigit) {
                digits[index] = 0;
                index++;
            }
        } else {
            while (tempNumber != 0) {
                if (index == maxDigit) {
                    // If maxDigit limit is reached, break out of the loop
                    System.out.println("Note: Number 10 digits se bada hai. Sirf pehle 10 digits consider kiye ja rahe hain.");
                    break;
                }
                digits[index] = tempNumber % 10; // Get the last digit
                tempNumber /= 10; // Remove the last digit
                index++; // Increment index
            }
        }

        if (index == 0) { // If no digits were extracted (e.g., negative input, though not strictly handled)
            System.out.println("Koi digits nahi milay. Kripya valid number enter karein.");
            scanner.close();
            return;
        }

        // Find the largest and second largest digit
        int largest = -1; // Initialize with a value lower than any single digit
        int secondLargest = -1; // Initialize with a value lower than any single digit

        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest; // Current largest becomes second largest
                largest = digits[i];    // New largest found
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i]; // Found a new second largest
            }
        }

        // Display the results
        System.out.println("\n--- Digit Analysis Results ---");
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) { // Check if a second largest was found (e.g., if all digits are same)
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit nahi mil paya (ho sakta hai saare digits same hon ya number mein sirf ek digit ho).");
        }

        scanner.close();
    }
}
