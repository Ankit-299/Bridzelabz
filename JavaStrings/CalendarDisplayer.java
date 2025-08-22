import java.util.Scanner;

public class CalendarDisplayer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter month (1-12):");
        int month = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                month = scanner.nextInt();
                if (month >= 1 && month <= 12) {
                    break;
                } else {
                    System.out.println("Invalid month. Please enter a number between 1 and 12.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        System.out.println("Enter year (e.g., 2023):");
        int year = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
                if (year > 0) { // Assuming year must be positive
                    break;
                } else {
                    System.out.println("Invalid year. Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.nextLine(); // Consume newline

        displayCalendar(month, year);

        scanner.close();
    }

    // Method to get the name of the month
    public static String getMonthName(int month) {
        String[] monthNames = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return monthNames[month];
    }

    // Method to check for Leap Year
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get the number of days in the month
    public static int getNumberOfDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) {
            return 29;
        }
        return daysInMonth[month];
    }

    // Method to get the first day of the month using Gregorian calendar algorithm
    // 0 = Sunday, 1 = Monday, ..., 6 = Saturday
    public static int getFirstDayOfMonth(int month, int year) {
        // Zeller's congruence implementation
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (1 + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // Method to display the calendar
    public static void displayCalendar(int month, int year) {
        System.out.println("\n  " + getMonthName(month) + " " + year);
        System.out.println("  Sun Mon Tue Wed Thu Fri Sat");

        int firstDay = getFirstDayOfMonth(month, year);
        int numberOfDays = getNumberOfDaysInMonth(month, year);

        // First loop: Print leading spaces
        for (int i = 0; i < firstDay; i++) {
            System.out.printf("%4s", ""); // Print 4 spaces for each day before the first
        }

        // Second loop: Display days of the month
        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf("%4d", day); // Right-justified in a field of width 4
            if ((firstDay + day) % 7 == 0) { // If it's Saturday, move to the next line
                System.out.println();
            }
        }
        System.out.println(); // Ensure a newline at the end of the calendar
    }
}
