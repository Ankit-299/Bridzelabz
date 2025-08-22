import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TextProcessor {

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

        for (int i = 0; i < getStringLengthCustom(text); i++) {
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
        if (getStringLengthCustom(currentWord.toString()) > 0) {
            wordsList.add(currentWord.toString());
        }

        return wordsList.toArray(new String[0]);
    }

    public static String[][] getWordsAndLengths(String[] words) {
        String[][] wordsAndLengths = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            wordsAndLengths[i][0] = words[i];
            wordsAndLengths[i][1] = String.valueOf(getStringLengthCustom(words[i]));
        }
        return wordsAndLengths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Koi text enter karein: ");
        String inputText = scanner.nextLine();

        String[] customWords = splitTextIntoWordsCustom(inputText);
        String[][] wordsWithLengths = getWordsAndLengths(customWords);

        System.out.println("\n--- Words and Their Lengths ---");
        System.out.println("----------------------------");
        System.out.printf("%-15s %-10s%n", "Word", "Length");
        System.out.println("----------------------------");
        for (String[] entry : wordsWithLengths) {
            String word = entry[0];
            int length = Integer.parseInt(entry[1]);
            System.out.printf("%-15s %-10d%n", word, length);
        }
        System.out.println("----------------------------");

        scanner.close();
    }
}
