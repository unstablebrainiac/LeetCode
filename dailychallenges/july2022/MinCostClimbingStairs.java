package dailychallenges.july2022;

/*
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        Integer[] dp = new Integer[cost.length];
        return Math.min(
                minCostClimbingStairs(cost, 0, dp),
                minCostClimbingStairs(cost, 1, dp)
        );
    }

    private int minCostClimbingStairs(int[] cost, int start, Integer[] dp) {
        if (start >= cost.length) {
            return 0;
        }
        if (dp[start] != null) {
            return dp[start];
        }
        int ans = cost[start] + Math.min(
                minCostClimbingStairs(cost, start + 1, dp),
                minCostClimbingStairs(cost, start + 2, dp)
        );
        dp[start] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(
                new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}
        )); // 6
    }
}
