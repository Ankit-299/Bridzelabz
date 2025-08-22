import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        char firstNonRepeating = findFirstNonRepeatingChar(inputString);

        System.out.println("\n--- First Non-Repeating Character ---");
        if (firstNonRepeating == '\0') {
            System.out.println("No non-repeating character found in the string.");
        } else {
            System.out.println("First non-repeating character: '" + firstNonRepeating + "'");
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

    public static char findFirstNonRepeatingChar(String str) {
        int length = getStringLength(str);
        if (length == 0) {
            return '\0';
        }

        int[] charFrequencies = new int[256];

        for (int i = 0; i < length; i++) {
            charFrequencies[str.charAt(i)]++;
        }

        for (int i = 0; i < length; i++) {
            if (charFrequencies[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }

        return '\0';
    }
}
