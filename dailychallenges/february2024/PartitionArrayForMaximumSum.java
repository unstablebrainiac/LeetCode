package dailychallenges.february2024;

/*
 * https://leetcode.com/problems/partition-array-for-maximum-sum/
 */
public class PartitionArrayForMaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        return maxSumAfterPartitioning(arr, k, 0, new Integer[arr.length]);
    }

    private int maxSumAfterPartitioning(int[] arr, int k, int startIndex, Integer[] dp) {
        if (startIndex == arr.length) {
            return 0;
        }
        if (dp[startIndex] != null) {
            return dp[startIndex];
        }
        int max = 0;
        int maxSum = 0;
        for (int i = 0; i < k && startIndex + i < arr.length; i++) {
            max = Math.max(max, arr[startIndex + i]);
            maxSum = Math.max(maxSum, max * (i + 1) + maxSumAfterPartitioning(arr, k, startIndex + i + 1, dp));
        }
        return dp[startIndex] = maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionArrayForMaximumSum().maxSumAfterPartitioning(
                new int[]{1, 15, 7, 9, 2, 5, 10},
                3
        )); // 84
    }
}
