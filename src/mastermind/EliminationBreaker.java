package mastermind;
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

    private final int codeLength; // the length of the secret code
    private final int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private boolean[] eliminatedCodes; // an array to keep track of which codes have been eliminated


    public EliminationBreaker(int codeLength, int codeRange) {
        this.codeLength = codeLength;
        this.codeRange = codeRange;
        this.remainingCodes = (int) Math.pow(codeRange, codeLength);
        this.eliminatedCodes = new boolean[remainingCodes];
    }


    public Code nextGuess() {
        int guess = 0;
        while (eliminatedCodes[guess]) {
            guess++;
        }
        eliminatedCodes[guess] = true;
        remainingCodes--;
        return new Code(guess, codeLength, codeRange);
    }


    public void guessResults(Code guess, Code.Results results) {
        for (int i = 0; i < eliminatedCodes.length; i++) {
            if (!eliminatedCodes[i]) {
                Code c = new Code(i, codeLength, codeRange);
                Code.Results r = guess.checkGuess(c);
                if (!r.equals(results)) {
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