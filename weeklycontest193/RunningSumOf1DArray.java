package weeklycontest193;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-193/problems/running-sum-of-1d-array/
 */
public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RunningSumOf1DArray().runningSum(
                new int[]{1, 2, 3, 4}
        ))); // 1,3,6,10
    }
}
