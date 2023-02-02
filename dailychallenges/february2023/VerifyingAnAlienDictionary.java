package dailychallenges.february2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://leetcode.com/problems/verifying-an-alien-dictionary/
 */
public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        return isAlienSorted(Arrays.asList(words), order, 0);
    }

    private boolean isAlienSorted(List<String> words, String order, int index) {
        if (words.size() < 2) {
            return true;
        }
        int i = 0, j = 0;
        List<String> wordsWithCommonStart = new ArrayList<>();
        while (i < order.length() && j < words.size()) {
            String word = words.get(j);
            if (index == word.length()) {
                if (!wordsWithCommonStart.isEmpty()) {
                    return false;
                }
                j++;
            } else if (order.charAt(i) == word.charAt(index)) {
                wordsWithCommonStart.add(words.get(j));
                j++;
            } else {
                if (!isAlienSorted(wordsWithCommonStart, order, index + 1)) {
                    return false;
                }
                wordsWithCommonStart = new ArrayList<>();
                i++;
            }
        }
        if (j == words.size()) {
            return isAlienSorted(wordsWithCommonStart, order, index + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(
                new String[]{
                        "word",
                        "world",
                        "row"
                },
                "worldabcefghijkmnpqstuvxyz"
        )); // false
    }
}
