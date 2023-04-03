//@authors Julian Powell and Alex Csorba
package mastermind;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface {
    public static void main(String[] args) {
//Ran into multiple issues with the EliminationBreaker, so its functionality is very limited. However, the other means
//of making and breaking work much better.

        Scanner scan = new Scanner(System.in);
        PrintStream out = System.out;
        System.out.print("Enter code length: ");
        int codeLength = scan.nextInt();
        Code.Results winningResults = new Code.Results(codeLength, 0);

        System.out.print("Enter code Range: ");
        int codeRange = scan.nextInt();

        System.out.print("Select a human(h) or computer(c) code maker: ");
        char maker = scan.next().charAt(0);

        System.out.print("Select a human(h) or computer(c) code breaker: ");
        char breaker = scan.next().charAt(0);

        CodeMaker codeMaker = null;
        CodeBreaker codeBreaker = null;
        Scanner scanner = new Scanner(System.in);
        switch (maker) {
            case 'h' -> codeMaker = new ConsoleCodeMaker(scanner, System.out, codeLength, codeRange);
            case 'c' -> codeMaker = new RandomCodeMaker(codeLength, codeRange);
        }

        switch (breaker) {
            case 'h' -> codeBreaker = new ConsoleCodeBreaker(scanner, System.out, codeLength, codeRange);
            case 'c' -> codeBreaker = new EliminationBreaker(codeLength, codeRange);
        }

        Code winningCode=codeMaker.generateCode();
        System.out.println("secret code: "+winningCode);
        System.out.println("Possible codes: "+codeBreaker.possibleCodeCount());

        boolean codeFound = false;
        int numGuesses = 0;
        while(!codeFound){
            Code guess = codeBreaker.nextGuess();
            ++numGuesses;
            System.out.println("Breaker's guess("+numGuesses+"): "+guess);
            Code.Results guessResults = guess.compare(winningCode);
            System.out.println("Bulls-Cows: "+guessResults.getBulls()+"-"+guessResults.getCows());
            codeBreaker.guessResults(guess, guessResults);
            System.out.println("Possible codes: "+codeBreaker.possibleCodeCount());

            if(guessResults.equals(winningResults)) {
                System.out.println("Game Over!");
                codeFound = true;
            }
        }
    }
}
