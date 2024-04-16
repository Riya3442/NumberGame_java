import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int numberOfAttempts = 5;
        int score = 0;

        boolean playAgain = true;

        while (playAgain) {
            int generatedNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = numberOfAttempts;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to Guess the Number game!");
            System.out.println("I've generated a number between " + minRange + " and " + maxRange + ". Try to guess it!");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("Attempts left: " + attemptsLeft + ". Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You've guessed the correct number!");
                    score += attemptsLeft;
                    guessedCorrectly = true;
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                attemptsLeft--;
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = sc.next();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing Guess the Number!");
        sc.close();
    }
}