import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringSplitter {

    public static int getStringLengthCustom(String text) {
        int count = 0;
        try {
            while (true) {
                char ch = text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static String[] splitTextIntoWordsCustom(String text) {
        List<String> wordsList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();
        boolean lastCharWasSpace = true;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                if (!lastCharWasSpace) {
                    wordsList.add(currentWord.toString());
                    currentWord.setLength(0);
                }
                lastCharWasSpace = true;
            } else {
                currentWord.append(ch);
                lastCharWasSpace = false;
            }
        }
        if (currentWord.length() > 0) {
            wordsList.add(currentWord.toString());
        }

        return wordsList.toArray(new String[0]);
    }

    public static boolean compareStringArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Koi text enter karein: ");
        String inputText = scanner.nextLine();

        System.out.println("\n--- Custom Length Finder ---");
        int customLength = getStringLengthCustom(inputText);
        System.out.println("User-defined method se string ki length: " + customLength);
        int builtInLength = inputText.length();
        System.out.println("Built-in length() method se string ki length: " + builtInLength);
        if (customLength == builtInLength) {
            System.out.println("Custom aur Built-in length methods ke results same hain! ✅");
        } else {
            System.out.println("Custom aur Built-in length methods ke results alag hain! ❌");
        }

        System.out.println("\n--- Word Splitter ---");
        String[] customWords = splitTextIntoWordsCustom(inputText);
        System.out.println("User-defined method se words: " + Arrays.toString(customWords));

        String[] builtInWords = inputText.trim().split("\\s+"); // Handles multiple spaces
        System.out.println("Built-in split() method se words: " + Arrays.toString(builtInWords));

        boolean comparisonResult = compareStringArrays(customWords, builtInWords);

        System.out.println("\n--- Comparison Results for Split ---");
        if (comparisonResult) {
            System.out.println("Dono split methods ke results same hain! ✅");
        } else {
            System.out.println("Dono split methods ke results alag hain! ❌");
        }

        scanner.close();
    }
}
