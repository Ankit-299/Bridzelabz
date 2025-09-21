public class MathUtils {

    public static long calculateFactorial(int n) {
        if (n < 0) {
            System.out.println("Invalid input: Factorial is not defined for negative numbers.");
            return -1;
        }
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findNthFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Invalid input: Fibonacci number is for n >= 1.");
            return -1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
