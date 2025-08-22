import java.util.Scanner;

public class LowercaseConverter {

    public static String convertToLowercaseCustom(String text) {
        StringBuilder lowercaseText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                lowercaseText.append((char) (ch + 32));
            } else {
                lowercaseText.append(ch);
            }
        }
        return lowercaseText.toString();
    }

    public static boolean compareStringsUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Koi text enter karein: ");
        String inputText = scanner.nextLine();

        String customLowercase = convertToLowercaseCustom(inputText);
        System.out.println("User-defined method se lowercase: \"" + customLowercase + "\"");

        String builtInLowercase = inputText.toLowerCase();
        System.out.println("Built-in toLowerCase() method se lowercase: \"" + builtInLowercase + "\"");

        boolean comparisonResult = compareStringsUsingCharAt(customLowercase, builtInLowercase);

        System.out.println("\n--- Comparison Results ---");
        if (comparisonResult) {
            System.out.println("Dono methods ke results same hain! ");
        } else {
            System.out.println("Dono methods ke results alag hain! ");
        }

        scanner.close();
    }
}
