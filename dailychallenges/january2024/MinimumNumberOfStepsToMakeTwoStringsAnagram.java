package dailychallenges.january2024;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
 */
public class MinimumNumberOfStepsToMakeTwoStringsAnagram {
    public int minSteps(String s, String t) {
        Map<Character, Long> sFrequency = getFrequency(s);
        Map<Character, Long> tFrequency = getFrequency(t);

        int additions = 0, deletions = 0;

        for (char c = 'a'; c <= 'z'; c++) {
            long sCount = sFrequency.getOrDefault(c, 0L);
            long tCount = tFrequency.getOrDefault(c, 0L);
            if (sCount > tCount) {
                deletions += (int) (sCount - tCount);
            } else if (tCount > sCount) {
                additions += (int) (tCount - sCount);
            }
        }

        return Math.max(additions, deletions);
    }

    private Map<Character, Long> getFrequency(String str) {
        return str.chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfStepsToMakeTwoStringsAnagram().minSteps("leetcode", "practice")); // 5
    }
}
