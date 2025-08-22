import java.util.Scanner;

public class IllegalArgumentDemo {

    public static void generateIllegalArgumentException() {
        String text = "JavaProgramming";
        int startIndex = 10;
        int endIndex = 5;
        System.out.println("IllegalArgumentException generate kar rahe hain...");
        System.out.println("String: \"" + text + "\"");
        System.out.println("Attempting to get substring with startIndex " + startIndex + " and endIndex " + endIndex + ":");
        System.out.println(text.substring(startIndex, endIndex));
    }

    public static void handleIllegalArgumentException() {
        String text = "ExceptionHandling";
        int startIndex = 12;
        int endIndex = 8;
        System.out.println("\nIllegalArgumentException handle kar rahe hain...");
        System.out.println("String: \"" + text + "\"");
        System.out.println("Attempting to get substring with startIndex " + startIndex + " and endIndex " + endIndex + ":");
        try {
            System.out.println(text.substring(startIndex, endIndex));
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: IllegalArgumentException! Substring ke liye invalid arguments (startIndex > endIndex).");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Exception caught: Ek generic RuntimeException.");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Pehle exception generate karte hain:");
        generateIllegalArgumentException();

        System.out.println("\nAb exception ko handle karte hain:");
        handleIllegalArgumentException();
    }
}
