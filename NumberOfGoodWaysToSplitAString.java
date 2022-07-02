import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 */
public class NumberOfGoodWaysToSplitAString {
    public int numSplits(String s) {
        Set<Character> setLeft = new HashSet<>();
        Set<Character> setRight = new HashSet<>();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int uniqueCharacters = 0;

        int length = s.toCharArray().length;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!setLeft.contains(c)) {
                setLeft.add(c);
                uniqueCharacters++;
            }
            left[i] = uniqueCharacters;
        }

        uniqueCharacters = 0;
        for (int i = length - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (!setRight.contains(c)) {
                setRight.add(c);
                uniqueCharacters++;
            }
            right[i] = uniqueCharacters;
        }

        return (int) IntStream.range(0, length - 1)
                .filter(i -> left[i] == right[i + 1])
                .count();
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfGoodWaysToSplitAString().numSplits("aacaba")); // 2
    }
}
