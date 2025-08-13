import java.util.Scanner;

public class IntOperation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a;
        int b;
        int c;

        System.out.println("Enter the first integer (a):");
        a = input.nextInt();

        System.out.println("Enter the second integer (b):");
        b = input.nextInt();

        System.out.println("Enter the third integer (c):");
        c = input.nextInt();

        int result1 = a + b * c;

        int result2 = a * b + c;

        double result3;
        double result4;

        if (b != 0) {
            result3 = c + (double)a / b;
            
            result4 = a % b + c;
            
            System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + String.format("%.2f", result3) + ", and " + (int)result4);

        } else {
            System.out.println("Cannot perform division or modulus by zero. Results for operations involving 'b' as divisor will be invalid.");
            System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", Invalid, and Invalid");
        }
        
        input.close();
    }
}
