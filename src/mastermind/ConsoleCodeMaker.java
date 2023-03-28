package mastermind;

import java.util.Scanner;
import java.io.PrintStream;
public class ConsoleCodeMaker implements CodeMaker{
    private Scanner scan;
    private PrintStream output;
    private int length;
    private int range;

    public ConsoleCodeMaker(java.util.Scanner scanner, java.io.PrintStream out, int codeLength, int codeRange){
        scan = scanner;
        output = out;
        length = codeLength;
        range = codeRange;
    }
    public Code generateCode() {
        Code finalCode = null;
        int validCode = 0;
        int validCharacters = 0;

        while (validCode == 0) {
            System.out.print("Enter a code that is " + length + " long that is comprised of characters between 1 and " + range);
            String input = scan.nextLine();

            if (input.length() != length) {
                System.out.println("Please enter a code of specified length");
            }
            else for (char item : input.toCharArray()) {
                if (Character.getNumericValue(item) < 1 || Character.getNumericValue(item) > range) {
                    System.out.println("Please enter a code with acceptable values");
                } else {
                    validCharacters++;
                }
            }
            if(validCharacters == length){
                validCode = 1;
                finalCode = new Code(input);
            }
        }
        return finalCode;
    }
}
