package dailychallenges.january2023;

import java.util.*;

/*
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
 */
public class LexicographicallySmallestEquivalentString {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, Set<Character>> equivalent = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            Set<Character> singleton = new HashSet<>();
            singleton.add(c);
            equivalent.put(c, singleton);
        }
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);

            equivalent.get(c1).add(c2);
            equivalent.get(c2).add(c1);
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (char c = 'a'; c <= 'z'; c++) {
                char smallestEquivalentCharacter = smallestEquivalentCharacter(c, equivalent);
                for (Character equivalentCharacter : equivalent.get(c)) {
                    changed |= equivalent.get(equivalentCharacter).add(smallestEquivalentCharacter);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < baseStr.length(); i++) {
            ans.append(smallestEquivalentCharacter(baseStr.charAt(i), equivalent));
        }
        return ans.toString();
    }

    private char smallestEquivalentCharacter(char c, Map<Character, Set<Character>> equivalent) {
        return (char) equivalent.get(c).stream().mapToInt(value -> value).min().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new LexicographicallySmallestEquivalentString().smallestEquivalentString(
                "leetcode",
                "programs",
                "sourcecode"
        )); // aauaaaaada
    }
}
