import java.util.Scanner;

public class StringUtilities {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string with leading and trailing spaces:");
        String inputString = scanner.nextLine();

        int[] trimPoints = trimSpaces(inputString);
        String customTrimmedString = createSubstring(inputString, trimPoints[0], trimPoints[1]);

        String builtInTrimmedString = inputString.trim();

        System.out.println("\n--- String Trimming Results ---");
        System.out.println("Original string: '" + inputString + "'");
        System.out.println("Custom trimmed string: '" + customTrimmedString + "'");
        System.out.println("Built-in trimmed string: '" + builtInTrimmedString + "'");

        boolean areEqual = compareStrings(customTrimmedString, builtInTrimmedString);
        System.out.println("Are custom and built-in trimmed strings equal? " + areEqual);

        scanner.close();
    }

    public static int[] trimSpaces(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start <= end && str.charAt(start) == ' ') {
            start++;
        }

        while (end >= start && str.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end};
    }

    public static String createSubstring(String str, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex >= str.length() || startIndex > endIndex) {
            return "";
        }

        StringBuilder substring = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            substring.append(str.charAt(i));
        }
        return substring.toString();
    }

    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
