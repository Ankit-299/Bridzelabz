import java.util.Scanner;

public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number, int divisor) {
        return new int[]{number % divisor, number / divisor};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int n = sc.nextInt();
        System.out.print("Enter divisor: ");
        int d = sc.nextInt();

        int[] res = findRemainderAndQuotient(n, d);
        System.out.println("Remainder = " + res[0] + ", Quotient = " + res[1]);
    }
}
