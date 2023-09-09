package dailychallenges.september2023;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/combination-sum-iv/
 */
public class CombinationSum4 {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 1;
        return combinationSum4(nums, target, dp);
    }

    private int combinationSum4(int[] nums, int target, Integer[] dp) {
        if (dp[target] != null) {
            return dp[target];
        }
        int ans = Arrays.stream(nums)
                .filter(num -> num <= target)
                .map(num -> combinationSum4(nums, target - num, dp))
                .sum();
        dp[target] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4().combinationSum4(new int[]{1, 2, 3}, 4)); // 7
    }
}
