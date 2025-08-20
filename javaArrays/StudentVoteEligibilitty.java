import java.util.Scanner;
import java.util.ArrayList;

public class StudentVoteEligibilitty {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int numElements = 5;

        System.out.println(numElements + " numbers enter karein:");

        for (int i = 0; i < numElements; i++) {
            while (true) {
                System.out.print("Number " + (i + 1) + " enter karein: ");
                try {
                    int num = Integer.parseInt(scanner.nextLine());
                    numbers.add(num);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Please enter a valid number.");
                }
            }
        }

        System.out.println("\n--- Number Properties ---");

        for (int i = 0; i < numbers.size(); i++) {
            int num = numbers.get(i);
            if (num > 0) {
                System.out.print("Number " + (i + 1) + " (Value: " + num + "): Positive");
                if (num % 2 == 0) {
                    System.out.println(" and Even");
                } else {
                    System.out.println(" and Odd");
                }
            } else if (num < 0) {
                System.out.println("Number " + (i + 1) + " (Value: " + num + "): Negative");
            } else {
                System.out.println("Number " + (i + 1) + " (Value: " + num + "): Zero");
            }
        }

        System.out.println("\n--- First and Last Element Comparison ---");

        if (numbers.size() >= 2) { // Ensure there are at least two elements to compare
            int firstElement = numbers.get(0);
            int lastElement = numbers.get(numbers.size() - 1);

            System.out.println("First element: " + firstElement);
            System.out.println("Last element: " + lastElement);

            if (firstElement == lastElement) {
                System.out.println("The first and last elements are Equal.");
            } else if (firstElement > lastElement) {
                System.out.println("The first element is Greater than the last element.");
            } else {
                System.out.println("The first element is Less than the last element.");
            }
        } else {
            System.out.println("Not enough elements to compare the first and last.");
        }

        scanner.close();
    }
}
