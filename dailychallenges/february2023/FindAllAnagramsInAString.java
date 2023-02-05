package dailychallenges.february2023;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Long> characters = p.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return findAnagrams(s, p, s.length(), characters);
    }

    private List<Integer> findAnagrams(String s, String p, int totalLength, Map<Character, Long> characters) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }
        Map<Character, Long> clone = new HashMap<>(characters);
        int totalRemaining = p.length();
        List<Integer> result = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!clone.containsKey(c)) {
                result.addAll(findAnagrams(s.substring(i + 1), p, totalLength, characters));
                return result;
            }
            Long remainingOccurences = clone.get(c);
            if (remainingOccurences == 0) {
                result.addAll(findAnagrams(s.substring(start + 1), p, totalLength, characters));
                return result;
            }
            clone.put(c, remainingOccurences - 1);
            totalRemaining--;
            if (totalRemaining == 0) {
                result.add(totalLength - s.length() + start);
                totalRemaining++;
                clone.put(s.charAt(start), 1L);
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams(
                "abacbabc",
                "abc"
        )); // [1, 2, 3, 5]
    }
}
