package dailychallenges.february2023;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Long> characters = s1.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return checkInclusion(s1, s2, characters);
    }

    private boolean checkInclusion(String s1, String s2, Map<Character, Long> characters) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Long> clone = new HashMap<>(characters);
        int totalRemaining = s1.length();
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (!clone.containsKey(c)) {
                return checkInclusion(s1, s2.substring(i + 1), characters);
            }
            Long remainingOccurences = clone.get(c);
            if (remainingOccurences == 0) {
                return checkInclusion(s1, s2.substring(1), characters);
            }
            clone.put(c, remainingOccurences - 1);
            totalRemaining--;
            if (totalRemaining == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion(
                "ab",
                "eidbaooo"
        )); // true
    }
}
