//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.Iterator;

public class EliminationBreaker implements CodeBreaker {

    private int codeLength; // the length of the secret code
    private int codeRange; // the range of possible values for each digit
    private int remainingCodes; // the number of remaining possible codes
    private Code.Results correctOutputs; //the expected results if the code is guessed (bulls = codeLength)
    private ULLinkedList<Code> possibleCodes = new ULLinkedList<>();   //list of all remaining possible codes
    private Code firstCode; //first code in the possibleCodes list

    public EliminationBreaker(int codeLength, int codeRange) {
        codeLength = codeLength;
        codeRange = codeRange;
        remainingCodes = (int) Math.pow(codeRange, codeLength);
        correctOutputs = new Code.Results(codeLength, 0);
        //Completely understand everything in the constructor from here down is not correct, could not figure out how
        //to populate this list accordingly without brute forcing the first code in the list. Even with this, our code
        //implies that the length of the code will always be 4. The linked list of codes also contains "aaaa" followed by
        //"aaab" for the remainder of the nodes in the list.
        firstCode = new Code("aaaa");
        possibleCodes.addFirst(firstCode);

        for(int i=0; i<remainingCodes;++i){
            possibleCodes.addLast(firstCode.nextCode(codeRange));
        }
    }


    public Code nextGuess() {
        return possibleCodes.getFirst();
    }


    public void guessResults(Code guess, Code.Results results) {
        //This method should remove codes from the list in more situations than just when they are completely equal to
        //eachother however we ran into difficulty removing codes from the list by their specific characters
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

