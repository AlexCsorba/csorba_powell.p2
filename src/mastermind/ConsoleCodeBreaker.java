package mastermind;

import java.util.Scanner;
import java.io.PrintStream;

public class ConsoleCodeBreaker implements CodeBreaker {
    private Scanner scanner;
    private PrintStream out;
    private int Length;
    private int Range;

    public ConsoleCodeBreaker(Scanner scanner, PrintStream out, int codeLength, int codeRange) {
        scanner = scanner;
        out = out;
        Length = codeLength;
        Range = codeRange;
    }

    public Code nextGuess() {
        String guessString;
        Code guess;

        while (true) {
            System.out.print("Enter your guess (must be " + Length + " digits between 1-" + Range + "): ");
            guessString = scanner.nextLine();

            try {
                guess = new Code(guessString);
                if (guess.length() == Length && guess.range() == Range) {
                    return guess;
                } else {
                    System.out.println("Invalid guess. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid guess. Please try again.");
            }
        }
    }

    public void guessResults(Code guess, Code.Results results) {
        // Do nothing
    }

    public int possibleCodeCount() {
        return 0;
    }
}
