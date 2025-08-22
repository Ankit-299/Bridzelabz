import java.util.Scanner;

public class StringIndexOutOfBoundsDemo {

    public static void generateStringIndexOutOfBoundsException() {
        String text = "Hello";
        System.out.println("StringIndexOutOfBoundsException generate kar rahe hain...");
        System.out.println("String length: " + text.length());
        System.out.println("Attempting to access index 5 (valid range 0-4):");
        System.out.println(text.charAt(5)); // This will cause the exception
    }

    public static void handleStringIndexOutOfBoundsException() {
        String text = "World";
        System.out.println("\nStringIndexOutOfBoundsException handle kar rahe hain...");
        System.out.println("String length: " + text.length());
        System.out.println("Attempting to access index 5 (valid range 0-4):");
        try {
            System.out.println(text.charAt(5)); // This will cause the exception
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Exception caught: StringIndexOutOfBoundsException! Aap string ki range se bahar ka index access kar rahe the.");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Pehle exception generate karte hain:");
        generateStringIndexOutOfBoundsException();

        System.out.println("\nAb exception ko handle karte hain:");
        handleStringIndexOutOfBoundsException();
    }
}
