//@authors Julian Powell and Alex Csorba
package mastermind;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintStream out = System.out;
        System.out.print("Enter code length: ");
        int codeLength = scan.nextInt();
        int codeRange = 26;

        Code.Results winningResults = new Code.Results(codeLength, 0);
        CodeMaker codeMaker = new ConsoleCodeMaker(scan, out, codeLength, codeRange);
        CodeBreaker codeBreaker = new EliminationBreaker(codeLength, codeRange);

        Code gameCode = codeMaker.generateCode();
        System.out.println(gameCode);
        int numGuesses = 0;

        boolean foundCode = false;
        while (!foundCode) {
            System.out.println("Number of possible codes: " + codeBreaker.possibleCodeCount());
            Code guess = codeBreaker.nextGuess();
            System.out.println(guess);
            ++numGuesses;
            Code.Results currentGuessResults = gameCode.compare(guess);
            System.out.println("Number of guesses made:" + numGuesses);
            codeBreaker.guessResults(guess, currentGuessResults);

            if (currentGuessResults.equals(winningResults)) {
                foundCode = true;
                System.out.println("Number of possible codes: 0");
                System.out.println("The code has been cracked!");
                System.out.println("Game Over!");
            }
        }
    }
}
