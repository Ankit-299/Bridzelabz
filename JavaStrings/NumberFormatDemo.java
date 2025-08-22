import java.util.Scanner;

public class NumberFormatDemo {

    public static void generateNumberFormatException() {
        String text = "abc123";
        System.out.println("NumberFormatException generate kar rahe hain...");
        System.out.println("Input String: \"" + text + "\"");
        Integer.parseInt(text);
    }

    public static void handleNumberFormatException() {
        String text = "123xyz";
        System.out.println("\nNumberFormatException handle kar rahe hain...");
        System.out.println("Input String: \"" + text + "\"");
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Exception caught: NumberFormatException! String mein non-numeric characters hain.");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Exception caught: Ek generic RuntimeException.");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Pehle exception generate karte hain:");
        generateNumberFormatException();

        System.out.println("\nAb exception ko handle karte hain:");
        handleNumberFormatException();
    }
}
