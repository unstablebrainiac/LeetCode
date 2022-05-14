package dailychallenges.september2020;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3447/
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        return IntStream.range(1, s.length())
                .filter(value -> s.length() % value == 0)
                .anyMatch(value -> s.substring(0, value).repeat(s.length() / value).equals(s));
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc")); // true
    }
}
