package dailychallenges.january2023;

import java.util.*;

/*
 * https://leetcode.com/problems/palindrome-partitioning/
 */
public class PalindromePartitioning {
    private boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private List<List<String>> partition(String s, int index, Map<Integer, List<List<String>>> dp) {
        if (dp.get(index) != null) {
            return dp.get(index);
        }
        String substring = s.substring(index);
        if (substring.length() == 1) {
            List<String> singleton = new LinkedList<>();
            singleton.add(substring);
            List<List<String>> singletonOfSingleton = new ArrayList<>();
            singletonOfSingleton.add(singleton);
            dp.put(index, singletonOfSingleton);
            return singletonOfSingleton;
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 1; i < substring.length(); i++) {
            String prefix = substring.substring(0, i);
            if (isPalindrome(prefix)) {
                List<List<String>> suffixes = partition(s, index + i, dp);
                List<List<String>> clone = new ArrayList<>();
                suffixes.forEach(suffix -> clone.add(new ArrayList<>(suffix)));
                clone.forEach(suffix -> suffix.add(0, prefix));
                result.addAll(clone);
            }
        }
        if (isPalindrome(substring)) {
            List<String> singleton = new LinkedList<>();
            singleton.add(substring);
            result.add(singleton);
        }
        dp.put(index, result);
        return result;
    }

    public List<List<String>> partition(String s) {
        return partition(s, 0, new HashMap<>());
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab")); // [[a, a, b], [aa, b]]
    }
}
