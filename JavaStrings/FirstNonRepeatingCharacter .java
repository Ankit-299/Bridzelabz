import java.util.ArrayList; // ArrayList for dynamic sizing
import java.util.Scanner;    // Scanner for user input

public class FirstNonRepeatingCharacter { // Class name is consistent with the immersive ID and functionality

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String inputString = scanner.nextLine(); // User input li gayi

        // findCharacterFrequencies method characters aur unki frequencies ko 2D array mein return karega
        String[][] charFrequencies = findCharacterFrequencies(inputString);

        System.out.println("\n--- Character Frequencies ---");
        if (charFrequencies.length == 0) {
            System.out.println("No characters to display frequency for or string was empty.");
        } else {
            // displayFrequencyTable method results ko tabular format mein dikhayega
            displayFrequencyTable(charFrequencies);
        }

        scanner.close(); // Scanner band kiya gaya
    }

    // Yeh method string ki length find karta hai bina built-in length() method use kiye
    public static int getStringLength(String str) {
        if (str == null) {
            return 0;
        }
        int count = 0;
        try {
            while (true) {
                str.charAt(count); // Har character ko access karke count badhate hain
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Jab out of bounds hoga, tab saare characters count ho chuke honge
        }
        return count;
    }

    // Yeh method string mein har character ki frequency find karta hai
    public static String[][] findCharacterFrequencies(String str) {
        int length = getStringLength(str);
        if (length == 0) {
            return new String[0][0]; // Agar string empty hai, toh empty 2D array return karo
        }

        // ASCII characters (0-255) ki frequency store karne ke liye array
        int[] frequencies = new int[256];

        // String mein loop karke har character ki frequency count karo
        for (int i = 0; i < length; i++) {
            frequencies[str.charAt(i)]++;
        }

        // Unique characters aur unki frequencies store karne ke liye ArrayList
        ArrayList<String[]> uniqueFrequenciesList = new ArrayList<>();
        // ASCII array mein loop karke woh characters find karo जिनकी frequency > 0 hai
        for (int i = 0; i < 256; i++) {
            if (frequencies[i] > 0) {
                // Character aur uski frequency ko String array mein convert karke list mein add karo
                uniqueFrequenciesList.add(new String[]{String.valueOf((char) i), String.valueOf(frequencies[i])});
            }
        }

        // ArrayList ko 2D String array mein convert karke return karo
        return uniqueFrequenciesList.toArray(new String[0][0]);
    }

    // Yeh method 2D array ko tabular format mein display karta hai
    public static void displayFrequencyTable(String[][] frequencies) {
        // Table headers print karo
        System.out.printf("%-15s %-15s%n", "Character", "Frequency");
        System.out.println("--------------------------------");

        // Har character aur uski frequency ko formatted tarike se print karo
        for (String[] entry : frequencies) {
            System.out.printf("%-15s %-15s%n", entry[0], entry[1]);
        }
        System.out.println("--------------------------------");
    }
}
