import java.util.ArrayList;
import java.util.Scanner;

public class TextAnalysis {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter some text:");
        String inputText = scanner.nextLine();

        String[] words = splitTextIntoWords(inputText);

        if (words.length == 0) {
            System.out.println("No words found in the entered text.");
            scanner.close();
            return;
        }

        String[][] wordAndLengths = getWordAndLengthArray(words);

        int[] minMaxLengths = findShortestAndLongest(wordAndLengths);

        System.out.println("\n--- Analysis Results ---");
        System.out.println("Shortest word length: " + minMaxLengths[0]);
        System.out.println("Longest word length: " + minMaxLengths[1]);

        System.out.print("Shortest word(s): ");
        boolean firstShort = true;
        for (String word : words) {
            if (getStringLength(word) == minMaxLengths[0]) {
                if (!firstShort) {
                    System.out.print(", ");
                }
                System.out.print("'" + word + "'");
                firstShort = false;
            }
        }
        System.out.println();

        System.out.print("Longest word(s): ");
        boolean firstLong = true;
        for (String word : words) {
            if (getStringLength(word) == minMaxLengths[1]) {
                if (!firstLong) {
                    System.out.print(", ");
                }
                System.out.print("'" + word + "'");
                firstLong = false;
            }
        }
        System.out.println();

        scanner.close();
    }

    public static String[] splitTextIntoWords(String text) {
        ArrayList<String> wordList = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < getStringLength(text); i++) {
            char ch = text.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                currentWord.append(ch);
            } else {
                if (getStringLength(currentWord.toString()) > 0) {
                    wordList.add(currentWord.toString());
                    currentWord = new StringBuilder();
                }
            }
        }

        if (getStringLength(currentWord.toString()) > 0) {
            wordList.add(currentWord.toString());
        }

        return wordList.toArray(new String[0]);
    }

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

    public static String[][] getWordAndLengthArray(String[] words) {
        String[][] wordAndLengths = new String[getStringLength(words)];

        for (int i = 0; i < getStringLength(words); i++) {
            String word = words[i];
            int length = getStringLength(word);
            String lengthAsString = String.valueOf(length);

            wordAndLengths[i] = new String[]{word, lengthAsString};
        }
        return wordAndLengths;
    }

    public static int[] findShortestAndLongest(String[][] wordLengths) {
        if (getStringLength(wordLengths) == 0) {
            return new int[]{0, 0};
        }

        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        for (int i = 0; i < getStringLength(wordLengths); i++) {
            String lengthStr = wordLengths[i][1];
            try {
                int currentLength = Integer.parseInt(lengthStr);

                if (currentLength < minLength) {
                    minLength = currentLength;
                }

                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
            } catch (NumberFormatException e) {
                System.err.println("Error parsing word length: " + lengthStr + ". Skipping this word.");
            }
        }
        return new int[]{minLength, maxLength};
    }

    private static int getStringLength(Object[] array) {
        int count = 0;
        try {
            while (true) {
                Object element = array[count];
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
        }
        return count;
    }
}
