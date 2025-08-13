import java.util.Scanner;

public class AddTwoNumbers {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the first number:");
        int number1 = input.nextInt();

        System.out.println("Enter the second number:");
        int number2 = input.nextInt();

        int sum = number1 + number2;

        System.out.println("The sum is: " + sum);

        input.close();
    }
}
