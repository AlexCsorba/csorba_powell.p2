package mastermind;
import java.util.List;
public class EliminationBreaker implements CodeBreaker{

    private int length;
    private int range;

    public EliminationBreaker(int codeLength, int codeRange){
        length = codeLength;
        range = codeRange;
    }
    public Code nextGuess() {
        return null;
    }

    public void guessResults(Code guess, Code.Results results) {

    }

    public int possibleCodeCount() {
        return 0;
    }
}
