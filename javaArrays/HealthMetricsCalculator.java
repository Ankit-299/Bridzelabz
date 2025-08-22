import java.util.Scanner;

public class HealthMetricsCalculator { // Class name changed here
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Kitne persons ka BMI calculate karna hai? ");
        int numberOfPersons = scanner.nextInt();

        // Multi-dimensional array to store height, weight, and BMI
        // Column 0: Height (meters)
        // Column 1: Weight (kg)
        // Column 2: BMI
        double[][] personData = new double[numberOfPersons][3];
        String[] weightStatus = new String[numberOfPersons];

        // Take input for weight and height for each person with validation
        System.out.println("Kripya har person ki height (meters mein) aur weight (kg mein) enter karein (positive values):");
        for (int i = 0; i < numberOfPersons; i++) {
            double currentHeight;
            double currentWeight;

            // Input validation for height
            while (true) {
                System.out.print("Person " + (i + 1) + " ki height (meters mein) enter karein: ");
                currentHeight = scanner.nextDouble();
                if (currentHeight > 0) {
                    break; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input: Height positive honi chahiye. Kripya dobara enter karein.");
                }
            }
            personData[i][0] = currentHeight; // Store height

            // Input validation for weight
            while (true) {
                System.out.print("Person " + (i + 1) + " ka weight (kg mein) enter karein: ");
                currentWeight = scanner.nextDouble();
                if (currentWeight > 0) {
                    break; // Valid input, exit loop
                } else {
                    System.out.println("Invalid input: Weight positive honi chahiye. Kripya dobara enter karein.");
                }
            }
            personData[i][1] = currentWeight; // Store weight
        }

        // Calculate BMI and determine weight status
        for (int i = 0; i < numberOfPersons; i++) {
            double height = personData[i][0];
            double weight = personData[i][1];

            // BMI Formula: weight (kg) / (height (m) * height (m))
            personData[i][2] = weight / (height * height); // Store BMI

            // Determine weight status based on the provided table
            if (personData[i][2] <= 18.4) {
                weightStatus[i] = "Underweight";
            } else if (personData[i][2] >= 18.5 && personData[i][2] <= 24.9) {
                weightStatus[i] = "Normal";
            } else if (personData[i][2] >= 25.0 && personData[i][2] <= 39.9) {
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
                              (i + 1), personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
        System.out.println("-------------------------------------------------------");

        scanner.close();
    }
}
