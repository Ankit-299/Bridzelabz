import java.util.*;

public class CalendarDisplay {

    static String[] months = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    static int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};

    public static boolean isLeap(int year) {
        return (year%400==0 || (year%4==0 && year%100!=0));
    }

    public static int getFirstDay(int month, int year) {
        // Zeller's congruence
        int q = 1;
        if (month < 3) {
            month += 12;
            year--;
        }
        int k = year % 100;
        int j = year / 100;
        int h = (q + (13*(month+1))/5 + k + k/4 + j/4 + 5*j) % 7;
        return (h+6)%7; // 0=Sun
    }

    public static void run(int month, int year) {
        if (month == 2 && isLeap(year)) days[1] = 29;
        else days[1] = 28;

        System.out.println("\n  " + months[month-1] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        int start = getFirstDay(month, year);
        for (int i = 0; i < start; i++) System.out.print("    ");

        for (int d=1; d<=days[month-1]; d++) {
            System.out.printf("%3d ", d);
            if ((d+start)%7==0) System.out.println();
        }
        System.out.println();
    }
}
