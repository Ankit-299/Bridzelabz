import java.util.Scanner;

public class TriangleAreaCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double baseCm;
        double heightCm;

        System.out.println("Enter the base of the triangle in centimeters:");
        baseCm = input.nextDouble();

        System.out.println("Enter the height of the triangle in centimeters:");
        heightCm = input.nextDouble();

        double areaCm2 = 0.5 * baseCm * heightCm;

        double areaIn2 = areaCm2 / (2.54 * 2.54);

        System.out.println("The area of the triangle in square centimeters is " + String.format("%.2f", areaCm2) + " and in square inches is " + String.format("%.2f", areaIn2));

        input.close();
    }
}
