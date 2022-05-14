package dailychallenges.august2020;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3411/
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, s.length())
                .mapToObj(s::charAt)
                .filter(Character::isLetterOrDigit)
                .map(Character::toLowerCase)
                .forEach(stringBuilder::append);
        return String.valueOf(stringBuilder).equals(stringBuilder.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
    }
}
