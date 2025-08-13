import java.util.Scanner;

public class UserInputCourseFeeCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fee;
        double discountPercent;

        System.out.println("Enter the total course fee (in INR):");
        fee = input.nextDouble();

        System.out.println("Enter the discount percentage (e.g., 10 for 10%):");
        discountPercent = input.nextDouble();

        double discount = (fee * discountPercent) / 100;
        double discountedFee = fee - discount;

        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + discountedFee);

        input.close();
    }
}
