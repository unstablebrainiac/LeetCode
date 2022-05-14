package dailychallenges.august2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3423/
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] occurences = new int[52];
        s.chars()
                .map(operand -> operand - 'A')
                .map(operand -> operand > 26 ? operand - 6 : operand)
                .forEach(value -> occurences[value]++);
        int sum = Arrays.stream(occurences)
                .map(operand -> operand % 2 == 0 ? operand : operand - 1)
                .sum();
        if (Arrays.stream(occurences).anyMatch(value -> value % 2 == 1)) {
            sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccddAA")); // 9
    }
}
