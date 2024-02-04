package dailychallenges.february2024;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tFrequency = t.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        Map<Character, Integer> windowFrequency = new HashMap<>();

        int startInclusive = 0, endExclusive = 0;
        String minString = "";
        Character lastCharacterAdded = null, lastCharacterRemoved = null;
        while (endExclusive <= s.length() && startInclusive < s.length()) {
            if (endExclusive - startInclusive < t.length()) {
                if (endExclusive == s.length()) {
                    break;
                }
                lastCharacterAdded = s.charAt(endExclusive++);
                lastCharacterRemoved = null;
                windowFrequency.merge(lastCharacterAdded, 1, Integer::sum);
                continue;
            }
            if (lastCharacterAdded != null) {
                if (Objects.equals(windowFrequency.get(lastCharacterAdded), tFrequency.get(lastCharacterAdded))
                        && tFrequency
                        .entrySet()
                        .stream()
                        .allMatch(entry -> entry.getValue() <= windowFrequency.getOrDefault(entry.getKey(), 0))) {
                    if (minString.isEmpty() || endExclusive - startInclusive < minString.length()) {
                        minString = s.substring(startInclusive, endExclusive);
                    }

                    lastCharacterAdded = null;
                    lastCharacterRemoved = s.charAt(startInclusive++);
                    windowFrequency.computeIfPresent(lastCharacterRemoved, (k, v) -> v - 1);
                } else {
                    if (endExclusive == s.length()) {
                        break;
                    }
                    lastCharacterAdded = s.charAt(endExclusive++);
                    windowFrequency.merge(lastCharacterAdded, 1, Integer::sum);
                }
                continue;
            }
            if (lastCharacterRemoved != null) {
                if (windowFrequency.get(lastCharacterRemoved) >= tFrequency.getOrDefault(lastCharacterRemoved, 0)) {
                    if (minString.isEmpty() || endExclusive - startInclusive < minString.length()) {
                        minString = s.substring(startInclusive, endExclusive);
                    }

                    lastCharacterRemoved = s.charAt(startInclusive++);
                    windowFrequency.computeIfPresent(lastCharacterRemoved, (k, v) -> v - 1);
                } else {
                    if (endExclusive == s.length()) {
                        break;
                    }
                    lastCharacterAdded = s.charAt(endExclusive++);
                    lastCharacterRemoved = null;
                    windowFrequency.merge(lastCharacterAdded, 1, Integer::sum);
                }
            }
        }

        return minString;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumWindowSubstring().minWindow("ADOBECODEBANC", "ABC")); // "BANC"
    }
}
