package dailychallenges.october2023;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 */
public class ReverseWordsInAString3 {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(StringBuilder::new)
                .map(StringBuilder::reverse)
                .map(StringBuilder::toString)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString3().reverseWords("Let's take LeetCode contest")); // "s'teL ekat edoCteeL tsetnoc"
    }
}
