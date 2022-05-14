package dailychallenges.july2020;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3391/
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.replaceAll(" +", " ").trim().split(" ");
        return IntStream.range(0, words.length)
                .mapToObj(index -> words[words.length - index - 1])
                .reduce((s1, s2) -> s1 + " " + s2).orElse("");
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString().reverseWords("   Hello world!   ")); // world! Hello
    }
}
