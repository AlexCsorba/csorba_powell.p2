//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.Random;

public class RandomCodeMaker implements CodeMaker {

    private int codeLength;
    private int codeRange;

    public RandomCodeMaker(int length, int range) {
        codeLength = length;
        codeRange = range;
    }


    public Code generateCode() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < codeLength; i++) {
            if (codeRange == 1) {
                sb.append('a');
            } else {
                sb.append((char) (rand.nextInt(codeRange - 1) + 'a'));
            }
        }
        return new Code(sb.toString());
    }
}

