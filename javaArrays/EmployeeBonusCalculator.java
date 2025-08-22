import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int NUM_EMPLOYEES = 10;

        // Arrays to store employee data
        double[] salaries = new double[NUM_EMPLOYEES];
        int[] yearsOfService = new int[NUM_EMPLOYEES];
        double[] newSalaries = new double[NUM_EMPLOYEES];
        double[] bonusAmounts = new double[NUM_EMPLOYEES];

        // Variables to store total amounts
        double totalBonusPayout = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        System.out.println("Kripya 10 employees ki salary aur years of service enter karein:");

        // Loop to take input for each employee
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print("Employee " + (i + 1) + " ki salary enter karein: ");
                    double currentSalary = scanner.nextDouble();
                    System.out.print("Employee " + (i + 1) + " ke years of service enter karein: ");
                    int currentYearsOfService = scanner.nextInt();

                    if (currentSalary <= 0 || currentYearsOfService < 0) {
                        System.out.println("Invalid input: Salary positive honi chahiye aur years of service non-negative. Dobara try karein.");
                    } else {
                        salaries[i] = currentSalary;
                        yearsOfService[i] = currentYearsOfService;
                        validInput = true;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input: Kripya number enter karein.");
                    scanner.next(); // Consume the invalid input
                }
            }
        }

        // Loop to calculate bonus, new salary, and totals
        for (int i = 0; i < NUM_EMPLOYEES; i++) {
            double bonusPercentage;
            if (yearsOfService[i] > 5) {
                bonusPercentage = 0.05; // 5% bonus
            } else {
                bonusPercentage = 0.02; // 2% bonus
            }

            double bonus = salaries[i] * bonusPercentage;
            double newSalary = salaries[i] + bonus;

            bonusAmounts[i] = bonus;
            newSalaries[i] = newSalary;

            totalBonusPayout += bonus;
            totalOldSalary += salaries[i];
            totalNewSalary += newSalary;
        }

        // Print the results
        System.out.println("\n--- Zara Company Bonus Payout Summary ---");
        System.out.printf("Total Bonus Payout: %.2f%n", totalBonusPayout);
        System.out.printf("Total Old Salary (All Employees): %.2f%n", totalOldSalary);
        System.out.printf("Total New Salary (All Employees): %.2f%n", totalNewSalary);

        scanner.close();
    }
}
