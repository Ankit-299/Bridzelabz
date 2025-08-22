import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    public static void generateArrayIndexOutOfBoundsException() {
        String[] names = {"Alice", "Bob", "Charlie"};
        System.out.println("ArrayIndexOutOfBoundsException generate kar rahe hain...");
        System.out.println("Array size: " + names.length);
        System.out.println("Attempting to access index 3 (valid range 0-2):");
        System.out.println(names[3]); // This will cause the exception
    }

    public static void handleArrayIndexOutOfBoundsException() {
        String[] names = {"David", "Eve"};
        System.out.println("\nArrayIndexOutOfBoundsException handle kar rahe hain...");
        System.out.println("Array size: " + names.length);
        System.out.println("Attempting to access index 2 (valid range 0-1):");
        try {
            System.out.println(names[2]); // This will cause the exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception caught: ArrayIndexOutOfBoundsException! Aap array ki range se bahar ka index access kar rahe the.");
            System.out.println("Error message: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Exception caught: Ek generic RuntimeException.");
            System.out.println("Error message: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("Pehle exception generate karte hain:");
        generateArrayIndexOutOfBoundsException();

        System.out.println("\nAb exception ko handle karte hain:");
        handleArrayIndexOutOfBoundsException();
    }
}
