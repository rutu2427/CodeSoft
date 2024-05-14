package Task1;

import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        playGame(scanner);
        scanner.close();
    }

    public static void playGame(Scanner scanner) {
        final int minVal = 1;
        final int maxVal = 100;
        final int maxAttempts = 5;
        int totalAttempts = 0;
        int roundsWon = 0;

        while (true) {
            int randomNumber = generateRandomNumber(minVal, maxVal);
            System.out.println("I have generated a random number between 1 and 100. Try to guess it!");

            int attempts = 0;
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == randomNumber) {
                    System.out.println("Congratulations! You guessed the number correctly in " + attempts + " attempts!");
                    totalAttempts += attempts;
                    roundsWon++;
                    break;
                } else if (guess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used up all your attempts. The number was: " + randomNumber);
                totalAttempts += maxAttempts;
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing!");
                System.out.println("Total rounds won: " + roundsWon);
                System.out.println("Total attempts made: " + totalAttempts);
                break;
            }
        }
    }

    public static int generateRandomNumber(int minVal, int maxVal) {
        return (int) (Math.random() * (maxVal - minVal + 1) + minVal);
    }
}

