package dailychallenges.february2024;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/divide-array-into-array-with-maximum-difference/
 */
public class DivideArrayIntoArraysWithMaxDifference {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];

        for (int i = 0; i < nums.length; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            System.arraycopy(nums, i, ans[i / 3], 0, 3);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new DivideArrayIntoArraysWithMaxDifference().divideArray(
                new int[]{1, 3, 4, 8, 7, 9, 3, 5, 1},
                2
        ))); // [[1, 1, 3], [3, 4, 5], [7, 8, 9]]
    }
}
