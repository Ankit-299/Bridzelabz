import java.util.Scanner;

public class MultiplesFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer (less than 100): ");
        int number = scanner.nextInt();

        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100.");
        } else {
            System.out.println("Multiples of " + number + " below 100 are:");
            for (int i = 1; i < 100; i++) { // Loop from 1 to 99
                if (i % number == 0) {
                    System.out.println(i);
                }
            }
        }
        scanner.close();
    }
}
