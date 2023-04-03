//@authors Julian Powell and Alex Csorba
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
            System.out.print("Enter secret code with length["+length+"] and range["+range+"]:" );
            String input = scan.nextLine();
            input = input.trim();

            if (input.length() != length) {
                System.out.println("Please enter a code of specified length");
            }
            else {
                for (char item : input.toCharArray()) {
                    if (item < 'a' || item - 'a' > range) {
                        System.out.println("Please enter a code with acceptable values");
                    } else {
                        validCharacters++;
                    }
                }
            }
            if(validCharacters == length){
                validCode = 1;
                finalCode = new Code(input);
            }
            validCharacters = 0;
        }
        return finalCode;
    }
}
