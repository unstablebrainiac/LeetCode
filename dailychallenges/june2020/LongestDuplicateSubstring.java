package dailychallenges.june2020;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/541/week-3-june-15th-june-21st/3365/
 */
public class LongestDuplicateSubstring {
    public String longestDupSubstring(String S) {
        int low = 0;
        int high = S.length() - 1;

        while (low < high) {
            int mid = (low + high) >>> 1;
            String midVal = checkDuplicateOfLength(S, mid);

            if (midVal == null)
                high = mid - 1;
            else
                low = mid + 1;
        }
        String ans = checkDuplicateOfLength(S, low);
        if (ans != null || low == 0) {
            return ans;
        } else {
            ans = checkDuplicateOfLength(S, low - 1);
        }
        return ans == null ? "" : ans;
    }

    private String checkDuplicateOfLength(String S, int i) {
        Set<Integer> strings = new HashSet<>();
        for (int j = 0; j < S.length() - i + 1; j++) {
            String substring = S.substring(j, j + i);
            if (strings.contains(substring.hashCode())) {
                return substring;
            }
            strings.add(substring.hashCode());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new LongestDuplicateSubstring().longestDupSubstring("banana")); // ana
    }
}
