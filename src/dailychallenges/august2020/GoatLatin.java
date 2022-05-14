package dailychallenges.august2020;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3429/
 */
public class GoatLatin {
    public String toGoatLatin(String S) {
        String[] words = S.split(" ");
        return IntStream.range(0, words.length)
                .mapToObj(index ->
                        Arrays.asList('a', 'e', 'i', 'o', 'u').contains(Character.toLowerCase(words[index].charAt(0)))
                                ? words[index] + "ma" + "a".repeat(index + 1)
                                : words[index].substring(1) + words[index].charAt(0) + "ma" + "a".repeat(index + 1)
                )
                .reduce((s1, s2) -> s1 + " " + s2)
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println(new GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog")); // heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa
    }
}
