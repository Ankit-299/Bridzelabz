import java.util.Scanner;
import java.text.DecimalFormat; // For formatting BMI to 2 decimal places

public class BMICalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPersons = 10;

        double[][] weightHeightData = getWeightAndHeightInput(scanner, numberOfPersons);

        String[][] bmiResults = processAllBMI(weightHeightData);

        displayBMIData(bmiResults);

        scanner.close();
    }

    public static double[][] getWeightAndHeightInput(Scanner scanner, int numPersons) {
        double[][] data = new double[numPersons][2];
        System.out.println("Please enter weight (kg) and height (cm) for " + numPersons + " persons:");

        for (int i = 0; i < numPersons; i++) {
            System.out.println("\n--- Person " + (i + 1) + " ---");
            
            System.out.print("Enter weight in kg: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number for weight (e.g., 70.5):");
                scanner.next();
                System.out.print("Enter weight in kg: ");
            }
            data[i][0] = scanner.nextDouble();

            System.out.print("Enter height in cm: ");
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid number for height (e.g., 175.2):");
                scanner.next();
                System.out.print("Enter height in cm: ");
            }
            data[i][1] = scanner.nextDouble();
        }
        return data;
    }

    public static String[] calculateBMIAndStatus(double weightKg, double heightCm) {
        String[] result = new String[2]; // [BMI, Status]

        double heightM = heightCm / 100.0;
        double bmi = weightKg / (heightM * heightM);

        DecimalFormat df = new DecimalFormat("#.##"); // Format BMI to 2 decimal places
        result[0] = df.format(bmi); // BMI as a formatted string

        if (bmi < 18.5) {
            result[1] = "Underweight";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            result[1] = "Normal";
        } else if (bmi >= 25.0 && bmi <= 39.9) {
            result[1] = "Overweight";
        } else { // bmi >= 40.0
            result[1] = "Obese";
        }
        return result;
    }

    public static String[][] processAllBMI(double[][] weightHeightData) {
        String[][] allResults = new String[weightHeightData.length][4]; // [Height(cm), Weight(kg), BMI, Status]

        for (int i = 0; i < weightHeightData.length; i++) {
            double weight = weightHeightData[i][0];
            double height = weightHeightData[i][1];

            String[] bmiAndStatus = calculateBMIAndStatus(weight, height);

            allResults[i][0] = String.valueOf(height); // Height in cm
            allResults[i][1] = String.valueOf(weight); // Weight in kg
            allResults[i][2] = bmiAndStatus[0];       // Calculated BMI
            allResults[i][3] = bmiAndStatus[1];       // BMI Status
        }
        return allResults;
    }

    public static void displayBMIData(String[][] bmiData) {
        System.out.println("\n--- BMI Analysis for Team Members ---");
        System.out.printf("%-10s %-12s %-12s %-10s %-15s%n", "Person #", "Weight (kg)", "Height (cm)", "BMI", "Status");
        System.out.println("------------------------------------------------------------------");

        for (int i = 0; i < bmiData.length; i++) {
            System.out.printf("%-10s %-12s %-12s %-10s %-15s%n",
                              "Person " + (i + 1),
                              bmiData[i][1], // Weight
                              bmiData[i][0], // Height
                              bmiData[i][2], // BMI
                              bmiData[i][3]);// Status
        }
        System.out.println("------------------------------------------------------------------");
    }
}
