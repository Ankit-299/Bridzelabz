import java.util.Scanner;

public class DistanceConverter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double distanceInFeet;

        System.out.println("Enter the distance in feet:");
        distanceInFeet = input.nextDouble();

        double yards = distanceInFeet / 3.0;
        double miles = yards / 1760.0;

        System.out.println("The distance " + distanceInFeet + " feet is equal to " + String.format("%.2f", yards) + " yards and " + String.format("%.2f", miles) + " miles");

        input.close();
    }
}
