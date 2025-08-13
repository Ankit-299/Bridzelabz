import java.util.Scanner;

public class SimpleInterest {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the Principal amount:");
        double principal = input.nextDouble();

        System.out.println("Enter the Rate of interest (in percentage):");
        double rate = input.nextDouble();

        System.out.println("Enter the Time period (in years):");
        double time = input.nextDouble();

        double simpleInterest = (principal * rate * time) / 100;

        System.out.println("The Simple Interest is: " + simpleInterest);

        input.close();
    }
}
