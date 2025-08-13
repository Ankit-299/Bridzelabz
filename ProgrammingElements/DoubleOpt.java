import java.util.Scanner;

public class DoubleOpt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a;
        double b;
        double c;

        System.out.println("Enter the first double (a):");
        a = input.nextDouble();

        System.out.println("Enter the second double (b):");
        b = input.nextDouble();

        System.out.println("Enter the third double (c):");
        c = input.nextDouble();

        double result1 = a + b * c;

        double result2 = a * b + c;

        double result3;
        double result4;

        if (b != 0) {
            result3 = c + a / b;
            
            result4 = a % b + c;
            
            System.out.println("The results of Double Operations are " + String.format("%.2f", result1) + ", " + String.format("%.2f", result2) + ", " + String.format("%.2f", result3) + ", and " + String.format("%.2f", result4));

        } else {
            System.out.println("Cannot perform division or modulus by zero. Results for operations involving 'b' as divisor will be invalid.");
            System.out.println("The results of Double Operations are " + String.format("%.2f", result1) + ", " + String.format("%.2f", result2) + ", Invalid, and Invalid");
        }
        
        input.close();
    }
}
