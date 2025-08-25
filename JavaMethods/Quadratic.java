import java.util.*;

public class Quadratic {

    public static double[] findRoots(int a, int b, int c) {
        double delta = (b * b) - (4 * a * c);

        if (delta > 0) {
            double root1 = (-b + Math.sqrt(delta)) / (2 * a);
            double root2 = (-b - Math.sqrt(delta)) / (2 * a);
            return new double[]{root1, root2};
        } else if (delta == 0) {
            double root = -b / (2.0 * a);
            return new double[]{root};
        } else {
            return new double[]{}; // no real roots
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        double[] roots = findRoots(a, b, c);
        if (roots.length == 2) {
            System.out.println("Two roots: " + roots[0] + ", " + roots[1]);
        } else if (roots.length == 1) {
            System.out.println("One root: " + roots[0]);
        } else {
            System.out.println("No real roots");
        }
    }
}
