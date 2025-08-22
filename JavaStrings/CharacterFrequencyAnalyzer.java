import java.util.ArrayList;
import java.util.Scanner;

public class CharacterFrequencyAnalyzer { // Class name changed here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        String[][] charFrequencies = findCharacterFrequencies(inputString);

        System.out.println("\n--- Character Frequencies ---");
        if (charFrequencies.length == 0) {
            System.out.println("No characters to display frequency for or string was empty.");
        } else {
            displayFrequencyTable(charFrequencies);
        }

        scanner.close();
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

    public static char[] uniqueCharacters(String str) {
        int length = getStringLength(str);
        if (length == 0) {
            return new char[0];
        }

        char[] tempUnique = new char[length];
        int uniqueCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = str.charAt(i);
            boolean isUnique = true;

            for (int j = 0; j < uniqueCount; j++) {
                if (tempUnique[j] == currentChar) {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique) {
                tempUnique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            result[i] = tempUnique[i];
        }
        return result;
    }

    public static String[][] findCharacterFrequencies(String str) {
        int length = getStringLength(str);
        if (length == 0) {
            return new String[0][0];
        }

        int[] frequencies = new int[256];

        for (int i = 0; i < length; i++) {
            frequencies[str.charAt(i)]++;
        }

        char[] uniqueChars = uniqueCharacters(str);

        ArrayList<String[]> uniqueFrequenciesList = new ArrayList<>();
        for (char uniqueChar : uniqueChars) {
            if (frequencies[uniqueChar] > 0) {
                uniqueFrequenciesList.add(new String[]{String.valueOf(uniqueChar), String.valueOf(frequencies[uniqueChar])});
            }
        }

        return uniqueFrequenciesList.toArray(new String[0][0]);
    }

    public static void displayFrequencyTable(String[][] frequencies) {
        System.out.printf("%-15s %-15s%n", "Character", "Frequency");
        System.out.println("--------------------------------");

        for (String[] entry : frequencies) {
            System.out.printf("%-15s %-15s%n", entry[0], entry[1]);
        }
        System.out.println("--------------------------------");
    }
}
