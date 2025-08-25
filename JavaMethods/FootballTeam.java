import java.util.*;

public class FootballTeam {

    // Method to find sum
    public static int findSum(int[] arr) {
        int sum = 0;
        for (int val : arr) sum += val;
        return sum;
    }

    // Method to find mean
    public static double findMean(int[] arr) {
        return (double) findSum(arr) / arr.length;
    }

    // Method to find shortest
    public static int findMin(int[] arr) {
        int min = arr[0];
        for (int val : arr) min = Math.min(min, val);
        return min;
    }

    // Method to find tallest
    public static int findMax(int[] arr) {
        int max = arr[0];
        for (int val : arr) max = Math.max(max, val);
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + rand.nextInt(101); // 150–250
        }

        System.out.println("Heights of Players: " + Arrays.toString(heights));
        System.out.println("Shortest Height: " + findMin(heights));
        System.out.println("Tallest Height: " + findMax(heights));
        System.out.println("Mean Height: " + findMean(heights));
    }
}
