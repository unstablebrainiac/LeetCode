package dailychallenges.october2023;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/
 */
public class MinimumNumberOfOperationsToMakeArrayContinuous {
    public int minOperations(int[] nums) {
        int initialLength = nums.length;
        nums = Arrays.stream(nums)
                .sorted()
                .distinct()
                .toArray();

        int left = 0, right = 0, max = 0;
        while (left < nums.length) {
            while (right < nums.length && nums[right] - nums[left] < initialLength) {
                right++;
            }
            max = Math.max(max, right - left);
            left++;
            if (max == nums.length) {
                break;
            }
        }

        return initialLength - max;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfOperationsToMakeArrayContinuous().minOperations(new int[]{1, 2, 3, 5, 6})); // 1
    }
}
