package mastermind;

import java.util.NoSuchElementException;
public class Code implements Cloneable {
    private String code;

    public Code(String code) throws IllegalArgumentException {
        for (char c : code.toCharArray()) {
            if (!Character.isLetter(c)) {
                throw new IllegalArgumentException("Invalid character in code: " + c);
            }
        }
        this.code = code.toLowerCase();
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
        return this.code.equals(other.code);
    }

    public Results compare(Code other) throws IllegalArgumentException {
        if (this.code.length() != other.code.length()) {
            throw new IllegalArgumentException("Code lengths do not match");
        }
        int bulls = 0;
        int cows = 0;
        int[] counts = new int[26];
        for (int i = 0; i < this.code.length(); i++) {
            char c1 = this.code.charAt(i);
            char c2 = other.code.charAt(i);
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
        char[] chars = this.code.toCharArray();
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
        for (char c : this.code.toCharArray()) {
            if (c < 'a' + range - 1) {
                return true;
            }
        }
        return false;
    }

    public int range() {
        int max = 0;
        for (char c : this.code.toCharArray()) {
            int value = c - 'a' + 1;
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int length() {
        return this.code.length();
    }

    public String toString() {
        return this.code;
    }




}
