import java.util.Scanner;

public class TriangleAreaConverter {

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

        System.out.println("The Area of the triangle in sq in is " + String.format("%.2f", areaIn2) + " and sq cm is " + String.format("%.2f", areaCm2));

        input.close();
    }
}
