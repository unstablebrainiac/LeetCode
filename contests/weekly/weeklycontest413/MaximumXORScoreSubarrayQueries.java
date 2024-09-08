package contests.weekly.weeklycontest413;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-xor-score-subarray-queries/
 */
public class MaximumXORScoreSubarrayQueries {
    public int[] maximumSubarrayXor(int[] nums, int[][] queries) {
        int[][] xorResults = new int[nums.length][nums.length];
        System.arraycopy(nums, 0, xorResults[0], 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i; j++) {
                xorResults[i][j] = xorResults[i - 1][j] ^ xorResults[i - 1][j + 1];
            }
        }
        for (int j = 0; j < nums.length; j++) {
            int max = xorResults[0][j];
            for (int i = 1; i < nums.length - j; i++) {
                max = Math.max(max, xorResults[i][j]);
                xorResults[i][j] = max;
            }
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int length = right - left + 1;
            for (int j = 0; j < length; j++) {
                result[i] = Math.max(result[i], xorResults[length - j - 1][left + j]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MaximumXORScoreSubarrayQueries().maximumSubarrayXor(new int[]{2, 8, 4, 32, 16, 1}, new int[][]{
                {0, 2},
                {1, 4},
                {0, 5}
        }))); // [12, 60, 60]
    }
}
