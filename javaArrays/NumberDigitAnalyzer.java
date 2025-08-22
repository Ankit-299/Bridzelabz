import java.util.Scanner;

public class NumberDigitAnalyzer { // Class name changed here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek number enter karein: ");
        int number = scanner.nextInt();

        // Initial size for the array of digits
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
                    // If maxDigit limit is reached, increase the array size by 10
                    maxDigit += 10; // Increase the size of the array by 10
                    int[] newTempDigits = new int[maxDigit];
                    // Copy existing digits to the new, larger array
                    for (int j = 0; j < index; j++) { // Only copy up to the current index
                        newTempDigits[j] = digits[j];
                    }
                    digits = newTempDigits; // Assign the new array to 'digits'
                    // No break here, continue adding digits
                }
                digits[index] = tempNumber % 10; // Get the last digit
                tempNumber /= 10; // Remove the last digit
                index++; // Increment index
            }
        }

        if (index == 0) { // If no digits were extracted (e.g., negative input)
            System.out.println("Koi digits nahi milay. Kripya valid number enter karein.");
            scanner.close();
            return;
        }

        // Find the largest and second largest digit
        int largest = -1; // Initialize with a value lower than any single digit
        int secondLargest = -1; // Initialize with a value lower than any single digit

        // Check for at least one digit to avoid issues with empty array or only one digit
        if (index > 0) {
            largest = digits[0];
            for (int i = 1; i < index; i++) {
                if (digits[i] > largest) {
                    secondLargest = largest;
                    largest = digits[i];
                } else if (digits[i] > secondLargest && digits[i] != largest) {
                    secondLargest = digits[i];
                }
            }
        }

        // Handle case where largest might be the only digit or all digits are the same
        if (index == 1) { // Only one digit was processed
            secondLargest = -1; // No second largest
        } else {
            // Re-evaluate secondLargest if it's still -1 or equal to largest (e.g., if all digits are the same as largest)
            if (secondLargest == -1 || secondLargest == largest) {
                // Find a distinct second largest if possible
                boolean foundSecondLargest = false;
                for (int i = 0; i < index; i++) {
                    if (digits[i] != largest) {
                        if (secondLargest == -1 || digits[i] > secondLargest) {
                            secondLargest = digits[i];
                            foundSecondLargest = true;
                        }
                    }
                }
                if (!foundSecondLargest) {
                    secondLargest = -1; // Still no distinct second largest
                }
            }
        }


        // Display the results
        System.out.println("\n--- Digit Analysis Results ---");
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) { // Check if a second largest was found
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("Second largest digit nahi mil paya (ho sakta hai saare digits same hon ya number mein sirf ek digit ho).");
        }

        scanner.close();
    }
}
