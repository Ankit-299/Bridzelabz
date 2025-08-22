import java.util.Scanner;

public class StringLengthFinder {

    public static int getStringLengthCustom(String text) {
        int count = 0;
        try {
            while (true) {
                char ch = text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ek string enter karein: ");
        String userInputString = scanner.next();

        int customLength = getStringLengthCustom(userInputString);
        System.out.println("User-defined method se string ki length: " + customLength);

        int builtInLength = userInputString.length();
        System.out.println("Built-in length() method se string ki length: " + builtInLength);

        if (customLength == builtInLength) {
            System.out.println("Dono methods ke results same hain! ✅");
        } else {
            System.out.println("Dono methods ke results alag hain! ❌");
        }

        scanner.close();
    }
}
