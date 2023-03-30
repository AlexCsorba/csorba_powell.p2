package mastermind;

import java.util.Scanner;
import java.io.PrintStream;

public class ConsoleCodeBreaker implements CodeBreaker {
    private Scanner scanner;
    private PrintStream out;
    private int codeLength;
    private int codeRange;

    public ConsoleCodeBreaker(Scanner scanner, PrintStream out, int codeLength, int codeRange) {
        this.scanner = scanner;
        this.out = out;
        this.codeLength = codeLength;
        this.codeRange = codeRange;
    }

    public Code nextGuess() {
        Code guess = null;
        boolean validGuess = false;
        while (!validGuess) {
            out.print("Enter your guess (" + codeLength + " digits from 1 to " + codeRange + "): ");
            String input = scanner.nextLine();
            try {
                guess = new Code(input);
                validGuess = true;
            } catch (IllegalArgumentException e) {
                out.println("Invalid guess: " + e.getMessage());
            }
        }
        return guess;
    }

    public void guessResults(Code guess, Code.Results results) {
        // Do nothing
    }

    public int possibleCodeCount() {
        return 0;
    }
}
