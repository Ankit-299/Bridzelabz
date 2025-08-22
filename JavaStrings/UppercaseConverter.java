import java.util.Scanner;

public class UppercaseConverter {

    public static String convertToUppercaseCustom(String text) {
        StringBuilder uppercaseText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                uppercaseText.append((char) (ch - 32));
            } else {
                uppercaseText.append(ch);
            }
        }
        return uppercaseText.toString();
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

        String customUppercase = convertToUppercaseCustom(inputText);
        System.out.println("User-defined method se uppercase: \"" + customUppercase + "\"");

        String builtInUppercase = inputText.toUpperCase();
        System.out.println("Built-in toUpperCase() method se uppercase: \"" + builtInUppercase + "\"");

        boolean comparisonResult = compareStringsUsingCharAt(customUppercase, builtInUppercase);

        System.out.println("\n--- Comparison Results ---");
        if (comparisonResult) {
            System.out.println("Dono methods ke results same hain! ✅");
        } else {
            System.out.println("Dono methods ke results alag hain! ❌");
        }

        scanner.close();
    }
}
