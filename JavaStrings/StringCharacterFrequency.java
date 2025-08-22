import java.util.ArrayList;
import java.util.Scanner;

public class StringCharacterFrequency { // Class name changed here

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        String[] charFrequencies = findCharacterFrequencies(inputString);

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

    public static String[] findCharacterFrequencies(String str) {
        int length = getStringLength(str);
        if (length == 0) {
            return new String[0];
        }

        char[] charArray = str.toCharArray();
        boolean[] visited = new boolean[length];

        ArrayList<String> frequenciesList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (visited[i]) {
                continue;
            }

            int count = 1;

            for (int j = i + 1; j < length; j++) {
                if (charArray[i] == charArray[j]) {
                    count++;
                    visited[j] = true;
                }
            }
            frequenciesList.add(charArray[i] + ":" + count);
        }

        return frequenciesList.toArray(new String[0]);
    }

    public static void displayFrequencyTable(String[] frequencies) {
        System.out.printf("%-15s %-15s%n", "Character", "Frequency");
        System.out.println("--------------------------------");

        for (String entry : frequencies) {
            String[] parts = entry.split(":");
            System.out.printf("%-15s %-15s%n", parts[0], parts[1]);
        }
        System.out.println("--------------------------------");
    }
}
