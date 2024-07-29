package contests.biweekly.biweeklycontest32;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/contest/biweekly-contest-32/problems/can-convert-string-in-k-moves/
 */
public class CanConvertStringInKMoves {
    public boolean canConvertString(String s, String t, int k) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] letters = new int[26];
        IntStream.range(0, s.length())
                .map(operand -> t.charAt(operand) - s.charAt(operand))
                .filter(value -> value != 0)
                .map(operand -> operand < 0 ? operand + 26 : operand)
                .forEach(value -> {
                    if (letters[value] == 0) {
                        letters[value] = value;
                    } else {
                        letters[value] += 26;
                    }
                });
        return Arrays.stream(letters)
                .filter(value -> value != 0)
                .max()
                .orElse(0) <= k;
    }

    public static void main(String[] args) {
        System.out.println(new CanConvertStringInKMoves().canConvertString("hxvcyvn", "xbzgtou", 28)); // false
    }
}
