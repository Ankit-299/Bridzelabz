import java.util.Scanner;

public class ArrayInputSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ek double array banate hain maximum 10 elements ke liye
        double[] numbers = new double[10];
        // Total sum store karne ke liye variable
        double total = 0.0;
        // Array ka current index track karne ke liye
        int index = 0;

        System.out.println("Please enter numbers (0 or a negative number to stop, max 10 numbers):");

        // Infinite loop jab tak user rukne ko na kahe ya array bhar na jaye
        while (true) {
            // Check karte hain ki array full toh nahi ho gaya
            if (index == numbers.length) {
                System.out.println("Array is full. No more numbers can be added.");
                break;
            }

            System.out.print("Enter number " + (index + 1) + ": ");
            double num;

            try {
                num = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                continue; // Invalid input par loop continue karega
            }

            // Check karte hain agar user ne 0 ya negative number enter kiya hai
            if (num <= 0) {
                System.out.println("0 or negative number entered. Stopping input.");
                break; // Loop ko break karte hain
            }

            // Number ko array mein store karte hain aur index badhate hain
            numbers[index] = num;
            index++;
        }

        System.out.println("\n--- Entered Numbers ---");
        // Saare entered numbers display karte hain aur unka sum calculate karte hain
        if (index == 0) {
            System.out.println("No numbers were entered.");
        } else {
            for (int i = 0; i < index; i++) {
                System.out.println("Number " + (i + 1) + ": " + numbers[i]);
                total += numbers[i]; // Sum mein add karte hain
            }
        }

        System.out.println("\n--- Summary ---");
        System.out.println("Total sum of all entered numbers: " + total);

        scanner.close(); // Scanner ko close karna zaroori hai
    }
}
