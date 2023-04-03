//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.Iterator;

public class EliminationBreaker implements CodeBreaker {

    private int codeLength; // the length of the secret code
    private int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private Code.Results correctOutputs;
    private ULLinkedList<Code> possibleCodes = new ULLinkedList<>();
    private Code firstCode;


    public EliminationBreaker(int codeLength, int codeRange) {
        codeLength = codeLength;
        codeRange = codeRange;
        remainingCodes = (int) Math.pow(codeRange, codeLength);
        correctOutputs = new Code.Results(codeLength, 0);
        String firstCodeStr = "a";
        for(int i=0;i<codeLength-1;++i){
           firstCodeStr.concat("a");
        }
       firstCode = new Code(firstCodeStr);
        possibleCodes.addFirst(firstCode);
        for(int i=0; i<remainingCodes;++i){
            possibleCodes.addLast(firstCode.nextCode(codeRange));
        }
    }


    public Code nextGuess() {
        return possibleCodes.getFirst();
    }


    public void guessResults(Code guess, Code.Results results) {
        if(!results.equals(correctOutputs)){
            boolean isFound = false;
            Iterator<Code> iter = possibleCodes.iterator();
           while(iter.hasNext()&&!isFound) {
               Code item = iter.next();
                   if (item.equals(guess)) {
                       iter.remove();
                       --remainingCodes;
                       isFound = true;
                   }
               }
           }
        }


    public int possibleCodeCount() {
        return remainingCodes;
    }
}

