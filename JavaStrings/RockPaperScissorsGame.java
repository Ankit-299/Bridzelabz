import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<String[]> gameHistory = new ArrayList<>(); // Stores results of each game: [game#, playerChoice, computerChoice, winner]

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.print("How many games do you want to play? ");
        int numberOfGames = 0;

        // Validate user input for number of games
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
                scanner.next(); // Consume invalid input
            }
        }
        scanner.nextLine(); // Consume the remaining newline character

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
            
            // Add game details to history
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

    // This method randomly determines the computer's choice (Rock, Paper, or Scissors).
    public static String getComputerChoice(Random random) {
        int choice = random.nextInt(3); // 0 for Rock, 1 for Paper, 2 for Scissors
        switch (choice) {
            case 0:
                return "Rock";
            case 1:
                return "Paper";
            case 2:
                return "Scissors";
            default:
                return "Unknown"; // Should not happen
        }
    }

    // This method determines the winner of a single round between the user and the computer.
    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equalsIgnoreCase(computerChoice)) {
            return "It's a Draw!";
        }

        // Convert choices to lowercase for easier comparison
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

    // This method calculates the average and percentage of wins for the user and the computer.
    public static String[][] calculateWinStats(int playerWins, int computerWins, int totalGames) {
        double playerWinPercentage = 0.0;
        double computerWinPercentage = 0.0;

        if (totalGames > 0) {
            playerWinPercentage = (double) playerWins / totalGames * 100;
            computerWinPercentage = (double) computerWins / totalGames * 100;
        }

        // Return a 2D String array for displaying stats: [["Player", "wins", "percentage"], ["Computer", "wins", "percentage"]]
        String[][] stats = new String[2][3];
        stats[0] = new String[]{"Player", String.valueOf(playerWins), String.format("%.2f%%", playerWinPercentage)};
        stats[1] = new String[]{"Computer", String.valueOf(computerWins), String.format("%.2f%%", computerWinPercentage)};
        return stats;
    }

    // This method displays the results of every game and also displays the average and percentage wins.
    public static void displayGameResults(ArrayList<String[]> gameHistory, String[][] winStats, int playerWins, int computerWins, int draws, int totalGames) {
        System.out.println("\n--- Game History ---");
        System.out.printf("%-8s %
