
package mastermind;

import java.util.ArrayList;
import java.util.List;


public class EliminationBreaker implements CodeBreaker {

    private int codeLength; // the length of the secret code
    private int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private boolean[] eliminatedCodes; // an array to keep track of which codes have been eliminated
    private Code.Results corretOutputs;
    private List<Code> possibleCodes;


    public EliminationBreaker(int codeLength, int codeRange) {
        codeLength = codeLength;
        codeRange = codeRange;
        remainingCodes = (int) Math.pow(codeRange, codeLength);
        eliminatedCodes = new boolean[remainingCodes];
        corretOutputs = new Code.Results(codeLength, 0);
    }


    public Code nextGuess() {
    }


    public void guessResults(Code guess, Code.Results results) {
        for (int i = 0; i < eliminatedCodes.length; i++) {
            if (!eliminatedCodes[i]) {
                if (!corretOutputs.equals(results)) {
                    eliminatedCodes[i] = true;
                    remainingCodes--;
                }
            }
        }
    }


    public int possibleCodeCount() {
        return remainingCodes;
    }
}