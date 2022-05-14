import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0) {
            return Collections.emptyList();
        }
        List<Integer> integers = new ArrayList<>();
        int length = words[0].length() * words.length;
        for (int i = 0; i < s.length() - length + 1; i++) {
            String subString = s.substring(i, i + length);
            if (match(subString, new LinkedList<>(asList(words)))) {
                integers.add(i);
            }
        }
        return integers;
    }

    private boolean match(String str, List<String> words) {
        int wordLength = words.get(0).length();
        if (str.length() == wordLength) {
            return str.equals(words.get(0));
        }
        String word = str.substring(0, wordLength);
        if (words.remove(word)) {
            return match(str.substring(wordLength), words);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SubstringWithConcatenationOfAllWords().findSubstring(
                "barfoothefoobarman",
                new String[]{"foo", "bar"}
        )); // 0,9
    }
}
