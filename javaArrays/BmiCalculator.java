import java.util.Scanner;

public class BmiCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kitne persons ka BMI calculate karna hai? ");
        int numberOfPersons = scanner.nextInt();

        // Arrays to store data for each person
        double[] heights = new double[numberOfPersons];
        double[] weights = new double[numberOfPersons];
        double[] bmis = new double[numberOfPersons];
        String[] weightStatus = new String[numberOfPersons];

        // Take input for weight and height for each person
        System.out.println("Kripya har person ki height (meters mein) aur weight (kg mein) enter karein:");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.print("Person " + (i + 1) + " ki height (meters mein) enter karein: ");
            heights[i] = scanner.nextDouble();

            System.out.print("Person " + (i + 1) + " ka weight (kg mein) enter karein: ");
            weights[i] = scanner.nextDouble();
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            // BMI Formula: weight (kg) / (height (m) * height (m))
            bmis[i] = weights[i] / (heights[i] * heights[i]);

            // Determine weight status based on the provided table
            if (bmis[i] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (bmis[i] >= 18.5 && bmis[i] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (bmis[i] >= 25.0 && bmis[i] <= 39.9) {
                weightStatus[i] = "Overweight";
            } else { // bmis[i] >= 40.0
                weightStatus[i] = "Obese";
            }
        }

        // Display the results for each person
        System.out.println("\n--- BMI Results ---");
        System.out.println("-------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-15s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < numberOfPersons; i++) {
            System.out.printf("%-10d %-10.2f %-11.2f %-10.2f %-15s%n",
                              (i + 1), heights[i], weights[i], bmis[i], weightStatus[i]);
        }
        System.out.println("-------------------------------------------------------");

        scanner.close();
    }
}
