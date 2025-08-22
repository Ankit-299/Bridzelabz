import java.util.Scanner;

public class FriendsComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Friend names array
        String[] friendNames = {"Amar", "Akbar", "Anthony"};

        // Arrays to store age and height
        int[] ages = new int[friendNames.length];
        double[] heights = new double[friendNames.length];

        System.out.println("Kripya Amar, Akbar, aur Anthony ke liye age aur height enter karein:");

        // Loop to take input for each friend
        for (int i = 0; i < friendNames.length; i++) {
            System.out.print(friendNames[i] + " ki age enter karein: ");
            ages[i] = scanner.nextInt();

            System.out.print(friendNames[i] + " ki height (meters mein) enter karein: ");
            heights[i] = scanner.nextDouble();
        }

        // Find the youngest friend
        int minAge = ages[0];
        String youngestFriendName = friendNames[0];
        for (int i = 1; i < friendNames.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestFriendName = friendNames[i];
            }
        }

        // Find the tallest friend
        double maxHeight = heights[0];
        String tallestFriendName = friendNames[0];
        for (int i = 1; i < friendNames.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestFriendName = friendNames[i];
            }
        }

        // Display the results
        System.out.println("\n--- Friends Comparison Results ---");
        System.out.println("Sabse youngest friend hai: " + youngestFriendName + " (" + minAge + " saal)");
        System.out.printf("Sabse tallest friend hai: " + tallestFriendName + " (%.2f meters)%n", maxHeight);

        scanner.close();
    }
}
