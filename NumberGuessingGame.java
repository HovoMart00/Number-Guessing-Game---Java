package numberGuessingGame;

import java.util.Scanner;  // Import the Scanner class
import java.util.Random;   // Import the Random class

public class NumberGuessingGame {

	public static void main(String[] args) {
		int attempts = 1; // to count attempts
        boolean gameStart = false;
        
        Random generator = new Random();
        int randomNum = generator.nextInt(100) + 1;
        
        Scanner scanner = new Scanner(System.in);   // Create a Scanner object
        System.out.println("Welcome to Number Guessing Game!");
        System.out.println("Type 'start' to play or 'exit' to quit:");
        String choice = scanner.nextLine();
        
        // Choosing start the game or exit
        if (choice.equalsIgnoreCase("start")) {
            gameStart = true;
            while (gameStart){
                System.out.println("Please guess the number between 1 and 100: ");
                int guess = scanner.nextInt();
                if (guess > 100 || guess < 1) {
                    System.out.println("Out of range!");
                } else if (guess < randomNum) {
                    System.out.println("Too low!");
                } else if (guess > randomNum) {
                    System.out.println("Too high!");
                } else if (guess == randomNum) {
                    System.out.println("Correct! You guessed it in " + attempts + " attempts!");
                    gameStart = false; // exits the game
                } else {
                    System.out.println("Invalid data!");
                }
                attempts ++;
                if (gameStart == false){
                    System.out.println("Would you like to play again? (yes/no):");
                    scanner.nextLine();
                    String restart = scanner.nextLine();
                    if (restart.equalsIgnoreCase("yes")) {
                        attempts = 1; // resseting attempts
                        randomNum = generator.nextInt(100) + 1;
                         System.out.println(randomNum);
                        gameStart = true;
                    } else {
                        System.out.println("You chose to exit, have a nice day!");
                    }
                }
            }
        } else if (choice.equalsIgnoreCase("exit")) {
            System.out.println("You chose to exit, have a nice day!");
        } else {
            System.out.println("Invalid command!");
        }
        
        scanner.close(); // Close the scanner to prevent resource leaks
	}
}
