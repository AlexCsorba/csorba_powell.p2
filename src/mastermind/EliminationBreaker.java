package mastermind;

import java.util.ArrayList;
import java.util.List;


public class EliminationBreaker implements CodeBreaker {

    private int codeLength; // the length of the secret code
    private int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private Code.Results correctOutputs;
    private ULLinkedList<Code> possibleCodes;


    public EliminationBreaker(int codeLength, int codeRange) {
        codeLength = codeLength;
        codeRange = codeRange;
        remainingCodes = (int) Math.pow(codeRange, codeLength);
        correctOutputs = new Code.Results(codeLength, 0);
    }


    public Code nextGuess() {

    }


    public void guessResults(Code guess, Code.Results results) {

    }


    public int possibleCodeCount() {
        return remainingCodes;
    }
}
