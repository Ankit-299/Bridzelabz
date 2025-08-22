import java.util.Scanner;

public class FootballTeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];
        double sum = 0;

        for (int i = 0; i < 11; i++) {
            System.out.print("Player " + (i + 1) + " ki height enter karein (in meters): ");
            heights[i] = scanner.nextDouble();
        }

        for (int i = 0; i < 11; i++) {
            sum += heights[i];
        }

        double mean = sum / 11;
        System.out.println("Football team ki mean height hai: " + mean + " meters");

        scanner.close();
    }
}
