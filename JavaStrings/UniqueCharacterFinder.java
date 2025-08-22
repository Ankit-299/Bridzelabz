import java.util.Scanner;

public class UniqueCharacterFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine();

        char[] uniqueChars = findUniqueCharacters(inputString);

        System.out.println("\n--- Unique Characters ---");
        if (uniqueChars.length == 0) {
            System.out.println("No unique characters found or string was empty.");
        } else {
            System.out.print("Unique characters: ");
            for (int i = 0; i < uniqueChars.length; i++) {
                System.out.print("'" + uniqueChars[i] + "' ");
            }
            System.out.println();
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

    public static char[] findUniqueCharacters(String str) {
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
}
