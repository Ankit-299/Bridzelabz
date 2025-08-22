import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class CardDeckSimulator {

    // Suits and Ranks for a standard deck of cards
    private static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    private static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    private static final int NUM_OF_CARDS = SUITS.length * RANKS.length; // Total cards in a standard deck

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Initialize the deck of cards
        String[] deck = initializeDeck();
        System.out.println("Deck initialized with " + deck.length + " cards.");

        // Step 2: Shuffle the deck
        shuffleDeck(deck);
        System.out.println("Deck shuffled.");

        System.out.println("\nEnter the number of players (minimum 2):");
        int numPlayers = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                numPlayers = scanner.nextInt();
                if (numPlayers >= 2) {
                    break;
                } else {
                    System.out.println("Invalid number of players. Please enter a number greater than or equal to 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }

        System.out.println("Enter the number of cards to distribute per player:");
        int cardsPerPlayer = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                cardsPerPlayer = scanner.nextInt();
                if (cardsPerPlayer > 0 && (cardsPerPlayer * numPlayers) <= NUM_OF_CARDS) {
                    break;
                } else if (cardsPerPlayer <= 0) {
                    System.out.println("Invalid number of cards. Please enter a positive number.");
                } else {
                    System.out.println("Not enough cards in the deck for " + numPlayers + " players with " + cardsPerPlayer + " cards each. Max possible cards per player: " + (NUM_OF_CARDS / numPlayers));
                    System.out.print("Please enter a valid number of cards per player: ");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        scanner.nextLine(); // Consume newline

        // Step 3: Distribute cards to players
        String[][] playersHands = distributeCards(deck, numPlayers, cardsPerPlayer);
        System.out.println("\nCards distributed to " + numPlayers + " players.");

        // Step 4: Print the cards each player has
        printPlayerHands(playersHands);

        scanner.close();
    }

    // This method initializes the deck of cards with all possible suit and rank combinations.
    // Each card is represented as a string "Rank of Suit" (e.g., "Ace of Spades").
    public static String[] initializeDeck() {
        String[] deck = new String[NUM_OF_CARDS];
        int cardIndex = 0;
        for (String suit : SUITS) {
            for (String rank : RANKS) {
                deck[cardIndex] = rank + " of " + suit;
                cardIndex++;
            }
        }
        return deck;
    }

    // This method shuffles the given deck of cards using the Fisher-Yates (Knuth) shuffle algorithm.
    public static void shuffleDeck(String[] deck) {
        Random random = new Random();
        for (int i = 0; i < deck.length; i++) {
            // Generate a random index between i (inclusive) and deck.length (exclusive)
            int randomCardNumber = i + (int) (Math.random() * (deck.length - i)); // Using Math.random as per hint
            
            // Swap the card at current index i with the card at the random index
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // This method distributes 'n' cards (cardsPerPlayer * numPlayers) from the shuffled deck
    // to 'x' players (numPlayers).
    public static String[][] distributeCards(String[] deck, int numPlayers, int cardsPerPlayer) {
        // Check if distribution is possible (though already checked in main, good for robustness)
        if ((long)numPlayers * cardsPerPlayer > deck.length) {
            System.err.println("Error: Not enough cards in the deck to distribute as requested.");
            return null; // Return null or throw an exception if invalid distribution
        }

        String[][] playerHands = new String[numPlayers][cardsPerPlayer];
        int cardIndex = 0;

        for (int i = 0; i < numPlayers; i++) {
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerHands[i][j] = deck[cardIndex];
                cardIndex++;
            }
        }
        return playerHands;
    }

    // This method prints the cards held by each player in a clear format.
    public static void printPlayerHands(String[][] playersHands) {
        if (playersHands == null) {
            System.out.println("No hands to display.");
            return;
        }

        System.out.println("\n--- Player's Hands ---");
        for (int i = 0; i < playersHands.length; i++) {
            System.out.println("Player " + (i + 1) + " has:");
            for (int j = 0; j < playersHands[i].length; j++) {
                System.out.println("  - " + playersHands[i][j]);
            }
            System.out.println(); // Newline for better readability between players
        }
    }
}
