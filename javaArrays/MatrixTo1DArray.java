import java.util.Scanner;

public class MatrixTo1DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Matrix ke liye rows enter karein: ");
        int rows = scanner.nextInt();

        System.out.print("Matrix ke liye columns enter karein: ");
        int columns = scanner.nextInt();

        int[][] matrix = new int[rows][columns];

        System.out.println("Matrix ke elements enter karein:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Element [" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[] singleDimArray = new int[rows * columns];
        int index = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                singleDimArray[index] = matrix[i][j];
                index++;
            }
        }

        System.out.println("\nOriginal 2D Array (Matrix):");
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j]);
                if (j < columns - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }

        System.out.print("\nCopied 1D Array: [");
        for (int i = 0; i < singleDimArray.length; i++) {
            System.out.print(singleDimArray[i]);
            if (i < singleDimArray.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        scanner.close();
    }
}
