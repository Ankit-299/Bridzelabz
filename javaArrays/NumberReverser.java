import java.util.Scanner;

public class NumberReverser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek number enter karein jise reverse karna hai: ");
        int number = scanner.nextInt();

        // Handle negative numbers by converting to positive for digit extraction
        int originalNumber = number;
        int tempNumber = Math.abs(number); // Use absolute value for digit extraction

        // Find the count of digits
        int digitCount = 0;
        if (tempNumber == 0) {
            digitCount = 1; // If number is 0, it has one digit
        } else {
            int n = tempNumber;
            while (n > 0) {
                n /= 10;
                digitCount++;
            }
        }

        // Create an array to store the digits
        int[] digits = new int[digitCount];
        int index = 0;

        // Store digits in the array
        if (tempNumber == 0) { // Special case for number 0
            digits[0] = 0;
            index = 1;
        } else {
            int n = tempNumber;
            while (n > 0) {
                digits[index] = n % 10; // Get the last digit
                n /= 10; // Remove the last digit
                index++; // Increment index
            }
        }

        System.out.print("Original Number: " + originalNumber);
        System.out.print("\nReversed Digits: ");

        // Display the elements of the array in reverse order
        // Note: digits were stored in reverse order during extraction,
        // so printing them from index 0 to index-1 directly gives the reversed number.
        // For example, if number is 123, digits array will be [3, 2, 1].
        // Displaying this array is the reverse of the original number.
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i]);
        }
        System.out.println(); // New line for cleaner output

        scanner.close();
    }
}
