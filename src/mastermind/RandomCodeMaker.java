//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.Random;

public class RandomCodeMaker implements CodeMaker {

    private int length;
    private int range;
    char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    public RandomCodeMaker(int length, int range) {
        this.length = length;
        this.range = range;
    }


    public Code generateCode() {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(alphabet[rand.nextInt(range)]);
        }
        return new Code(sb.toString());
    }
}

