//@authors Julian Powell and Alex Csorba
package mastermind;

import java.util.NoSuchElementException;
public class Code implements Cloneable {

    public static class Results
    {
        private int totalBulls = 0;
        private int totalCows = 0;
        public Results(int bulls, int cows){
            totalBulls = bulls;
            totalCows = cows;
        }

        public int getBulls(){
            return totalBulls;
        }

        public int getCows(){
            return totalCows;
        }

        public boolean equals(Results otherObject){
            return totalBulls == otherObject.getBulls() && totalCows == otherObject.getCows();
        }
    }

    private String gameCode;
    private int length;

    public Code(String code) throws IllegalArgumentException {
        for (char item : code.toCharArray()) {
            if (!Character.isLetter(item)) {
                throw new IllegalArgumentException("Invalid character in code: " + item);
            }
        }
        gameCode = code.toLowerCase();
    }

    public Code clone() throws CloneNotSupportedException {
        return (Code) super.clone();
    }

    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }
        Code other = (Code) otherObject;
        return gameCode.equals(other.gameCode);
    }

    public Results compare(Code other) throws IllegalArgumentException {
        if (gameCode.length() != other.gameCode.length()) {
            throw new IllegalArgumentException("Code lengths do not match");
        }
        int bulls = 0;
        int cows = 0;
        int[] counts = new int[26];
        for (int i = 0; i < gameCode.length(); i++) {
            char c1 = gameCode.charAt(i);
            char c2 = other.gameCode.charAt(i);
            if (c1 == c2) {
                bulls++;
            } else {
                if (counts[c1 - 'a'] < 0) {
                    cows++;
                }
                if (counts[c2 - 'a'] > 0) {
                    cows++;
                }
                counts[c1 - 'a']++;
                counts[c2 - 'a']--;
            }
        }
        return new Results(bulls, cows);
    }

    public Code nextCode(int range) {
        char[] chars = gameCode.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] < 'a' + range - 1) {
                chars[i]++;
                for (int j = i + 1; j < chars.length; j++) {
                    chars[j] = 'a';
                }
                return new Code(new String(chars));
            }
        }
        throw new NoSuchElementException("No next code");
    }

    public boolean hasNextCode(int range) {
        boolean nextCodePossible = false;
        for (char c : gameCode.toCharArray()) {
            if (c < 'a' + range - 1 && nextCodePossible == false) {
                nextCodePossible = true;
            }
        }
        return nextCodePossible;
    }

    public int range() {
        int max = 0;
        for (char item : gameCode.toCharArray()) {
            int value = Character.getNumericValue(item);
            if (value > max) {
                max = value;
            }
        }
        return max-9;
    }

    public int length() {
       return gameCode.length();
    }

    public String toString() {
        return gameCode;
    }
}
