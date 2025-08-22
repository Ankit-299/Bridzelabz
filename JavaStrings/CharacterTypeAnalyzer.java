import java.util.ArrayList;
import java.util.Scanner;

public class CharacterTypeAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to analyze:");
        String inputString = scanner.nextLine();

        String[][] analysisResult = findVowelsAndConsonants(inputString);

        if (analysisResult.length == 0) {
            System.out.println("No characters found for analysis in the entered string.");
        } else {
            displayCharacterAnalysis(analysisResult);
        }

        scanner.close();
    }

    public static String checkCharType(char ch) {
        char lowerCh = ch;

        if (ch >= 'A' && ch <= 'Z') {
            lowerCh = (char) (ch + ('a' - 'A'));
        }

        if (lowerCh >= 'a' && lowerCh <= 'z') {
            if (lowerCh == 'a' || lowerCh == 'e' || lowerCh == 'i' || lowerCh == 'o' || lowerCh == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        } else {
            return "Not a Letter";
        }
    }

    public static String[][] findVowelsAndConsonants(String str) {
        ArrayList<String[]> analysisList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            String type = checkCharType(ch);
            analysisList.add(new String[]{String.valueOf(ch), type});
        }

        return analysisList.toArray(new String[0][0]);
    }

    public static void displayCharacterAnalysis(String[][] analysisArray) {
        System.out.println("\n--- Character Analysis ---");
        System.out.printf("%-15s %-15s%n", "Character", "Type");
        System.out.println("--------------------------------");

        for (String[] row : analysisArray) {
            System.out.printf("%-15s %-15s%n", row[0], row[1]);
        }
        System.out.println("--------------------------------");
    }
}
