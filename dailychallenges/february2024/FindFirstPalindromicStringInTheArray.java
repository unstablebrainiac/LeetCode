package dailychallenges.february2024;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-first-palindromic-string-in-an-array/
 */
public class FindFirstPalindromicStringInTheArray {
    public String firstPalindrome(String[] words) {
        return Arrays.stream(words)
                .filter(word -> word.contentEquals(new StringBuilder(word).reverse()))
                .findFirst()
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println(new FindFirstPalindromicStringInTheArray().firstPalindrome(
                new String[]{"abc", "car", "ada", "racecar", "cool"})
        ); // ada
    }
}
