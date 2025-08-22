import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String[]> gameHistory = new ArrayList<>();

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.print("How many games do you want to play? ");
        int numberOfGames = 0;

        while (true) {
            if (scanner.hasNextInt()) {
                numberOfGames = scanner.nextInt();
                if (numberOfGames > 0) {
                    break;
                } else {
                    System.out.print("Please enter a positive number of games: ");
                }
            } else {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.next();
            }
        }
        scanner.nextLine();

        for (int i = 1; i <= numberOfGames; i++) {
            System.out.println("\n--- Game " + i + " ---");
            String playerChoice;
            while (true) {
                System.out.print("Enter your choice (Rock, Paper, or Scissors): ");
                playerChoice = scanner.nextLine().trim();
                if (playerChoice.equalsIgnoreCase("Rock") ||
                    playerChoice.equalsIgnoreCase("Paper") ||
                    playerChoice.equalsIgnoreCase("Scissors")) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please choose Rock, Paper, or Scissors.");
                }
            }

            String computerChoice = getComputerChoice(random);
            System.out.println("Computer chose: " + computerChoice);

            String winner = findWinner(playerChoice, computerChoice);
            System.out.println("Result: " + winner);

            String actualWinnerName = "";
            if (winner.contains("Player wins")) {
                playerWins++;
                actualWinnerName = "Player";
            } else if (winner.contains("Computer wins")) {
                computerWins++;
                actualWinnerName = "Computer";
            } else {
                draws++;
                actualWinnerName = "Draw";
            }
            
            gameHistory.add(new String[]{
                String.valueOf(i),
                playerChoice,
                computerChoice,
                actualWinnerName
            });
        }

        String[][] winStats = calculateWinStats(playerWins, computerWins, numberOfGames);
        displayGameResults(gameHistory, winStats, playerWins, computerWins, draws, numberOfGames);

        scanner.close();
    }

    public static String getComputerChoice(Random random) {
        int choice = random.nextInt(3);
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "Unknown";
        }
    }

    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a Draw!";
        }

        String pChoice = playerChoice.toLowerCase();
        String cChoice = computerChoice.toLowerCase();

        if ((pChoice.equals("rock") && cChoice.equals("scissors")) ||
            (pChoice.equals("paper") && cChoice.equals("rock")) ||
            (pChoice.equals("scissors") && cChoice.equals("paper"))) {
            return "Player wins!";
        } else {
            return "Computer wins!";
        }
    }

    public static String[][] calculateWinStats(int playerWins, int computerWins, int totalGames) {
        double playerWinPercentage = 0.0;
        double computerWinPercentage = 0.0;

        if (totalGames > 0) {
            playerWinPercentage = (double) playerWins / totalGames * 100;
            computerWinPercentage = (double) computerWins / totalGames * 100;
        }

        String[][] stats = new String[2][3];
        stats[0] = new String[]{"Player", String.valueOf(playerWins), String.format("%.2f%%", playerWinPercentage)};
        stats[1] = new String[]{"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerWinPercentage)};
        return stats;
    }

    public static void displayGameResults(ArrayList<String[]> gameHistory, String[][] winStats, int playerWins, int computerWins, int draws, int totalGames) {
        System.out.println("\n--- Game History ---");
        System.out.printf("%-8s %-15s %-15s %-10s%n", "Game #", "Player Choice", "Comp Choice", "Winner");
        System.out.println("----------------------------------------------------------");
        for (String[] game : gameHistory) {
            System.out.printf("%-8s %-15s %-15s %-10s%n", game[0], game[1], game[2], game[3]);
        }
        System.out.println("----------------------------------------------------------");

        System.out.println("\n--- Overall Stats ---");
        System.out.printf("%-15s %-10s %-15s%n", "Participant", "Wins", "Win %");
        System.out.println("-----------------------------------------");
        for (String[] stat : winStats) {
            System.out.printf("%-15s %-10s %-15s%n", stat[0], stat[1], stat[2]);
        }
        System.out.println("-----------------------------------------");
        System.out.printf("%-15s %-10s %-15s%n", "Draws", String.valueOf(draws), String.format("%.2f%%", (double)draws/totalGames * 100));
        System.out.printf("%-15s %-10s %-15s%n", "Total Games", String.valueOf(totalGames), "100.00%");
        System.out.println("-----------------------------------------");
    }
}
