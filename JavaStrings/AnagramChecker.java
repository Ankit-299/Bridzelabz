import java.util.Scanner;
import java.util.Arrays; // For comparing frequency arrays efficiently

public class AnagramChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first string:");
        String text1 = scanner.nextLine();

        System.out.println("Enter the second string:");
        String text2 = scanner.nextLine();

        boolean areAnagrams = checkAnagrams(text1, text2);

        System.out.println("\n--- Anagram Check Results ---");
        System.out.println("String 1: \"" + text1 + "\"");
        System.out.println("String 2: \"" + text2 + "\"");
        
        if (areAnagrams) {
            System.out.println("Result: The two strings ARE anagrams.");
        } else {
            System.out.println("Result: The two strings are NOT anagrams.");
        }

        scanner.close();
    }

    // This method cleans a string by converting it to lowercase and removing non-alphabetic characters.
    public static String cleanString(String str) {
        StringBuilder cleaned = new StringBuilder();
        for (int i = 0; i < str.length(); i++) { // Using built-in length() for simplicity here
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                cleaned.append(Character.toLowerCase(ch));
            }
        }
        return cleaned.toString();
    }

    // This method checks if two texts are anagrams.
    public static boolean checkAnagrams(String text1, String text2) {
        String cleanText1 = cleanString(text1);
        String cleanText2 = cleanString(text2);

        // Check if the lengths of the two cleaned texts are equal
        if (cleanText1.length() != cleanText2.length()) {
            return false;
        }

        // Create arrays to store the frequency of characters (256 for ASCII)
        int[] frequency1 = new int[256];
        int[] frequency2 = new int[256];

        // Loop through the first text to find character frequencies
        for (int i = 0; i < cleanText1.length(); i++) {
            frequency1[cleanText1.charAt(i)]++;
        }

        // Loop through the second text to find character frequencies
        for (int i = 0; i < cleanText2.length(); i++) {
            frequency2[cleanText2.charAt(i)]++;
        }

        // Compare the frequency arrays. If any frequency is not equal, they are not anagrams.
        // Using Arrays.equals() for efficient comparison of two int arrays
        return Arrays.equals(frequency1, frequency2);
    }
}
