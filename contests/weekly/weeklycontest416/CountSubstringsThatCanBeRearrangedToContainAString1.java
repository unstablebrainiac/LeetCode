package contests.weekly.weeklycontest416;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/count-substrings-that-can-be-rearranged-to-contain-a-string-i/
 */
public class CountSubstringsThatCanBeRearrangedToContainAString1 {

    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> word2Count = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            word2Count.put(word2.charAt(i), word2Count.getOrDefault(word2.charAt(i), 0) + 1);
        }

        int startInclusive = 0;
        int endExclusive = 0;
        long count = 0;
        Map<Character, Integer> currentCount = new HashMap<>();
        while (endExclusive < word1.length()) {
            if (isPossible(currentCount, word2Count)) {
                count += word1.length() - endExclusive + 1;
                currentCount.put(word1.charAt(startInclusive), currentCount.get(word1.charAt(startInclusive)) - 1);
                startInclusive++;
            } else {
                currentCount.put(word1.charAt(endExclusive), currentCount.getOrDefault(word1.charAt(endExclusive), 0) + 1);
                endExclusive++;
            }
        }
        while (startInclusive < word1.length()) {
            if (isPossible(currentCount, word2Count)) {
                count++;
            } else {
                break;
            }
            currentCount.put(word1.charAt(startInclusive), currentCount.get(word1.charAt(startInclusive)) - 1);
            startInclusive++;
        }

        return count;
    }

    private boolean isPossible(Map<Character, Integer> currentCount, Map<Character, Integer> word2Count) {
        for (Map.Entry<Character, Integer> entry : word2Count.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (currentCount.getOrDefault(c, 0) < count) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstringsThatCanBeRearrangedToContainAString1().validSubstringCount("bcca", "abc")); // 1
    }
}
