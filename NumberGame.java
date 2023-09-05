package JavaPractice;

import java.util.Random;
import java.util.Scanner;

class NumberGuessingGame {
    private int lowerBound;
    private int upperBound;
    private int targetNumber;
    private int maxAttempts;
    private int attemptsLeft;

    public NumberGuessingGame(int lowerBound, int upperBound, int maxAttempts) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.maxAttempts = maxAttempts;
        this.targetNumber = generateRandomNumber(lowerBound, upperBound);
        this.attemptsLeft = maxAttempts;
    }

    private int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public int getAttemptsLeft() {
        return attemptsLeft;
    }

    public void play(Scanner scanner) {
        int attempts = 0;
        int userGuess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I have selected a number between " + lowerBound + " and " + upperBound + ". Try to guess it.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            userGuess = scanner.nextInt();
            attempts++;
            attemptsLeft--;

            if (userGuess < targetNumber) {
                System.out.println("Too low! Try again.");
                System.out.println("-----------------------------------------------------------------------------------------------");
            } else if (userGuess > targetNumber) {
                System.out.println("Too high! Try again.");
                System.out.println("-----------------------------------------------------------------------------------------------");
            } else {
                System.out.println("Congratulations! You've guessed the number (" + targetNumber + ") in " + attempts + " attempts.");
                System.out.println("-----------------------------------------------------------------------------------------------");
                break;
            }
        }

        if (attempts >= maxAttempts) {
            System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            System.out.println("-----------------------------------------------------------------------------------------------");
        }
    }
}

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound = 1;
        int upperBound = 100;
        int maxAttempts = 10;
        int rounds = 0;
        int score = 0;

        while (true) {
            NumberGuessingGame game = new NumberGuessingGame(lowerBound, upperBound, maxAttempts);
            game.play(scanner);
            rounds++;
            score += game.getAttemptsLeft();

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next();

            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total score: " + score);
        scanner.close();
    }
}
