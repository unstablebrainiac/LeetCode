package contests.weekly.weeklycontest366;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/problems/apply-operations-to-make-two-strings-equal/
 */
public class ApplyOperationsToMakeTwoStringsEqual {
    public int minOperations(String s1, String s2, int x) {
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indices.add(i);
            }
        }

        if (indices.size() % 2 != 0) {
            return -1;
        }

        System.out.println(indices);
        return minOperations(indices, x, 0, null, new int[indices.size()][indices.size() + 1]);
    }

    private int minOperations(List<Integer> indices, int x, int startIndex, Integer pending, int[][] dp) {
        int ans;
        if (pending == null) {
            if (startIndex == indices.size()) {
                return 0;
            }
            if (dp[startIndex][indices.size()] != 0) {
                return dp[startIndex][indices.size()];
            }

            // flip this with next
            int next1 = Math.min(x, indices.get(startIndex + 1) - indices.get(startIndex)) + minOperations(indices, x, startIndex + 2, null, dp);

            // save current as pending
            int next2 = minOperations(indices, x, startIndex + 1, startIndex, dp);

            ans = Math.min(next1, next2);
            dp[startIndex][indices.size()] = ans;
        } else {
            if (startIndex == indices.size() - 1) {
                return Math.min(x, indices.get(startIndex) - indices.get(pending));
            }
            if (dp[startIndex][pending] != 0) {
                return dp[startIndex][pending];
            }

            // flip this with pending
            int next1 = Math.min(x, indices.get(startIndex) - indices.get(pending)) + minOperations(indices, x, startIndex + 1, null, dp);

            // flip this with next
            int next2 = Math.min(x, indices.get(startIndex + 1) - indices.get(startIndex)) + minOperations(indices, x, startIndex + 2, pending, dp);

            ans = Math.min(next1, next2);
            dp[startIndex][pending] = ans;
        }

        return ans;
    }

    public static void main(String[] args) {
//        System.out.println(new Problem3().minOperations("1100011000", "0101001010", 2)); // 4
        System.out.println(new ApplyOperationsToMakeTwoStringsEqual().minOperations("00101101100010", "00001010001111", 30)); // 8
    }
}
