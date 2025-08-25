import java.util.*;

public class RandomNumbers {

    public static int[] generate4DigitRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1000 + (int)(Math.random() * 9000); // ensures 4 digit
        }
        return arr;
    }

    public static double[] findAverageMinMax(int[] numbers) {
        int min = numbers[0], max = numbers[0], sum = 0;

        for (int x : numbers) {
            sum += x;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        double avg = sum / (double)numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String[] args) {
        int[] arr = generate4DigitRandomArray(5);
        System.out.println("Generated numbers: " + Arrays.toString(arr));

        double[] results = findAverageMinMax(arr);
        System.out.println("Average = " + results[0]);
        System.out.println("Min = " + results[1]);
        System.out.println("Max = " + results[2]);
    }
}
