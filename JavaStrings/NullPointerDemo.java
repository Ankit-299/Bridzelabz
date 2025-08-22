import java.util.Scanner;
import java.util.Arrays;

public class NullPointerDemo {

    public static void generateNullPointerException() {
        String text = null;
        System.out.println("NullPointerException generate kar rahe hain...");
        System.out.println(text.length());
    }

    public static void handleNullPointerException() {
        String text = null;
        System.out.println("\nNullPointerException handle kar rahe hain...");
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception caught: NullPointerException! String variable null hai. Isliye iske methods call nahi ho sakte.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Pehle exception generate karte hain:");
        generateNullPointerException();

        System.out.println("\nAb exception ko handle karte hain:");
        handleNullPointerException();
    }
}
