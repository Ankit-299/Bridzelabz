import java.util.Scanner;
import java.util.ArrayList; // Used temporarily to build char array

public class PalindromeChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check for palindrome:");
        String inputString = scanner.nextLine(); // Initial input as String

        char[] cleanCharArray = cleanStringForPalindromeCheck(inputString); // Convert to char[] early

        System.out.println("\n--- Palindrome Check Results ---");
        System.out.println("Original String: \"" + inputString + "\"");
        System.out.print("Cleaned Characters:  \"");
        System.out.print(cleanCharArray); // Print char array
        System.out.println("\"");
        System.out.println("--------------------------------");

        // Logic 1: Iterative Comparison
        boolean isPalindrome1 = isPalindromeIterative(cleanCharArray);
        System.out.println("Logic 1 (Iterative): " + (isPalindrome1 ? "Is a Palindrome" : "Is NOT a Palindrome"));

        // Logic 2: Recursive Comparison
        boolean isPalindrome2 = isPalindromeRecursive(cleanCharArray, 0, cleanCharArray.length - 1);
        System.out.println("Logic 2 (Recursive): " + (isPalindrome2 ? "Is a Palindrome" : "Is NOT a Palindrome"));

        // Logic 3: Character Array Comparison
        boolean isPalindrome3 = isPalindromeCharArrayComparison(cleanCharArray);
        System.out.println("Logic 3 (Char Array): " + (isPalindrome3 ? "Is a Palindrome" : "Is NOT a Palindrome"));

        scanner.close();
    }

    // This method removes spaces and converts characters to lowercase, returning a char array.
    public static char[] cleanStringForPalindromeCheck(String str) {
        ArrayList<Character> cleanedChars = new ArrayList<>();
        int length = getStringLength(str); // Use custom getStringLength for initial String

        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                cleanedChars.add(Character.toLowerCase(ch));
            }
        }

        char[] result = new char[cleanedChars.size()];
        for (int i = 0; i < cleanedChars.size(); i++) {
            result[i] = cleanedChars.get(i);
        }
        return result;
    }

    // This method finds the length of a string without using the built-in length() method.
    public static int getStringLength(String str) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }

    // Logic 1: Iterative method to compare characters from start and end of a char array.
    public static boolean isPalindromeIterative(char[] textArray) {
        int start = 0;
        int end = textArray.length - 1; // Using array.length property

        while (start < end) {
            if (textArray[start] != textArray[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive method to compare characters from start and end of a char array.
    public static boolean isPalindromeRecursive(char[] textArray, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (textArray[start] != textArray[end]) {
            return false;
        }
        return isPalindromeRecursive(textArray, start + 1, end - 1);
    }

    // Logic 3 - Helper: Method to reverse a char array.
    public static char[] reverseCharArray(char[] originalArray) {
        int length = originalArray.length; // Using array.length property
        char[] reversedArray = new char[length];
        for (int i = 0; i < length; i++) {
            reversedArray[i] = originalArray[length - 1 - i];
        }
        return reversedArray;
    }

    // Logic 3: Method to compare original and reversed character arrays for palindrome check.
    public static boolean isPalindromeCharArrayComparison(char[] textArray) {
        int length = textArray.length; // Using array.length property
        if (length == 0) {
            return true;
        }

        char[] reversedArray = reverseCharArray(textArray);

        for (int i = 0; i < length; i++) {
            if (textArray[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }
}
