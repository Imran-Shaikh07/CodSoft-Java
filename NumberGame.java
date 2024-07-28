import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Define game parameters
        final int START = 1;
        final int END = 100;
        final int MAX_ATTEMPTS = 10;

        int rounds = 0;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int randomNumber = random.nextInt(END - START + 1) + START;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Guess a number between " + START + " and " + END + ":");

            while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess;
                try {
                    userGuess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    continue;
                }

                attempts++;

                if (userGuess < randomNumber) {
                    System.out.println("Too low!");
                } else if (userGuess > randomNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct!");
                    guessedCorrectly = true;
                    score++;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + MAX_ATTEMPTS + " attempts. The correct number was " + randomNumber + ".");
            }

            rounds++;
            System.out.println("Score: " + score + " out of " + rounds + " rounds.");

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.nextLine().equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Final score: " + score + " out of " + rounds + " rounds.");
        scanner.close();
    }
}
