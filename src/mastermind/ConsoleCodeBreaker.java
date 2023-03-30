package mastermind;

import java.util.Scanner;
import java.io.PrintStream;

public class ConsoleCodeBreaker implements CodeBreaker{
    private final Scanner scan;
    private final PrintStream output;
    private final int length;
    private final int range;

    public ConsoleCodeBreaker(java.util.Scanner scanner, java.io.PrintStream out, int codeLength, int codeRange){
        scan = scanner;
        output = out;
        length = codeLength;
        range = codeRange;
    }

    public Code nextGuess(){
        String userGuess = "";
        boolean givenValidGuess = false;

        while (!givenValidGuess) {
            output.print("Enter your guess which is" + length + " characters long which are from a-z" + range);
            String input = scan.nextLine().trim();
            if (input.length() != length) {
                output.println("Invalid guess length");
            }

            int invalidCaracters = 0;
            for (char character : input.toCharArray()) {
                if (character < '1' || Character.getNumericValue(character) > range) {
                    ++invalidCaracters;
                }
            }
            if (invalidCaracters>0) {
                output.println("Guess out of specified range");
            }
            else{
                givenValidGuess = true;
                userGuess = input;
            }
        }
        return new Code(userGuess);
    }

    @Override
    public void guessResults(Code guess, Code.Results results) {
    }

    public int possibleCodeCount(){
        return 0;
    }
}
