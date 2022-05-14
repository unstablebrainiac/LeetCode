package weeklycontest191;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-191/problems/maximum-product-of-two-elements-in-an-array/
 */
public class MaximumProductOfTwoElementsInArray {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductOfTwoElementsInArray().maxProduct(new int[]{1, 5, 4, 5})); // 16
    }
}
