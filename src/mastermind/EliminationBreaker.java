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

    private int length; // the length of the secret code
    private int range; // the range of possible values for each digit
    private int nRemainingCodes; // the number of remaining possible codes
    private double nPossCodes;
    private Code.Results correctCodeOutput;
    private List<Code> possibleCodes;



    public EliminationBreaker(int codeLength, int codeRange) {
        length = codeLength;
        range = codeRange;
        nRemainingCodes = possibleCodes.size();
        correctCodeOutput = new Code.Results(length, 0);
        nPossCodes = Math.pow(range, length);
        possibleCodes = generatePossibleCodes(range);
        }

    public List<Code> generatePossibleCodes(int codeRange){
        List<Code> generatedList = null;
        while(nextGuess().hasNextCode(codeRange)){
            Code currentCode =
            generatedList.add();
        }
    }



    public Code nextGuess() {

    }


    public void guessResults(Code guess, Code.Results results) {

    }


    public int possibleCodeCount() {
        return nRemainingCodes;
    }
}