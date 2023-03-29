package mastermind;
import java.util.ArrayList;
import java.util.List;
//public class EliminationBreaker implements CodeBreaker{
//
//    private int length;
//    private int range;
//
//    public EliminationBreaker(int codeLength, int codeRange){
//        length = codeLength;
//        range = codeRange;
//    }
//    public Code nextGuess() {
//        return null;
//    }
//
//    public void guessResults(Code guess, Code.Results results) {
//
//    }
//
//    public int possibleCodeCount() {
//        return 0;
//    }
//}

public class EliminationBreaker implements CodeBreaker {

    private int codeLength; // the length of the secret code
    private int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private boolean[] eliminatedCodes; // an array to keep track of which codes have been eliminated
    private Code.Results corretOutPuts;
    private List<Code> possibleCodes;



    public EliminationBreaker(int codeLength, int codeRange) {
        codeLength = codeLength;
        codeRange = codeRange;
        remainingCodes = (int) Math.pow(codeRange, codeLength);
        eliminatedCodes = new boolean[remainingCodes];
        corretOutPuts = new Code.Results(codeLength, 0) ;


    }


    public Code nextGuess() {

        int guess = 0;
        while (eliminatedCodes[guess]) {
            guess++;
        }
        eliminatedCodes[guess] = true;
        remainingCodes--;
        return null;//new Code();
    }


    public void guessResults(Code guess, Code.Results results) {
        for (int i = 0; i < eliminatedCodes.length; i++) {
            if (!eliminatedCodes[i]) {
                if (!corretOutPuts.equals(results)) {
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