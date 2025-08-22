import java.util.Scanner;
import java.util.Arrays;

public class CharArrayConverter {

    public static char[] convertStringToCharArrayCustom(String inputString) {
        char[] charArray = new char[inputString.length()];
        for (int i = 0; i < inputString.length(); i++) {
            charArray[i] = inputString.charAt(i);
        }
        return charArray;
    }

    public static boolean compareCharArrays(char[] array1, char[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek string enter karein: ");
        String userInputString = scanner.next();

        char[] customCharArray = convertStringToCharArrayCustom(userInputString);
        System.out.println("User-defined method se character array: " + Arrays.toString(customCharArray));

        char[] builtInCharArray = userInputString.toCharArray();
        System.out.println("Built-in toCharArray() method se character array: " + Arrays.toString(builtInCharArray));

        boolean comparisonResult = compareCharArrays(customCharArray, builtInCharArray);

        System.out.println("\n--- Comparison Result ---");
        if (comparisonResult) {
            System.out.println("Dono arrays identical hain (user-defined aur built-in methods ke results match karte hain). ✅");
        } else {
            System.out.println("Dono arrays identical nahi hain (user-defined aur built-in methods ke results match nahi karte hain). ❌");
        }

        scanner.close();
    }
}
