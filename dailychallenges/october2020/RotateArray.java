package dailychallenges.october2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3496/
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RotateArray().rotate(nums, 3);
        System.out.println(Arrays.toString(nums)); // [5, 6, 7, 1, 2, 3, 4]
    }
}
