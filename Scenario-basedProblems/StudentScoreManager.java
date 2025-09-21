import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentScoreManager {

    public static void manageScores() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of students:");
        int n = 0;
        try {
            n = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            return;
        }

        if (n <= 0) {
            System.out.println("Number of students must be greater than zero.");
            return;
        }

        float[] scores = new float[n];
        float sum = 0;
        float maxScore = -1.0f;
        float minScore = 101.0f;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter score for student " + (i + 1) + ":");
            try {
                float score = scanner.nextFloat();
                if (score < 0 || score > 100) {
                    System.out.println("Invalid score. Please enter a score between 0 and 100.");
                    i--;
                    continue;
                }
                scores[i] = score;
                sum += scores[i];
                if (scores[i] > maxScore) {
                    maxScore = scores[i];
                }
                if (scores[i] < minScore) {
                    minScore = scores[i];
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                i--;
            }
        }
        
        if (n > 0) {
            float average = sum / n;
            System.out.println("Average score: " + average);
            System.out.println("Highest score: " + maxScore);
            System.out.println("Lowest score: " + minScore);
            System.out.println("Scores above average:");
            for (float score : scores) {
                if (score > average) {
                    System.out.println(score);
                }
            }
        }
    }
}
