package dailychallenges.july2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/wiggle-subsequence/
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        int count = 2;
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
        int last = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if ((nums[i] - nums[i - 1]) * last < 0) {
                count++;
            }
            last = nums[i] - nums[i - 1];
        }
        if (count == 2) {
            return Arrays.stream(nums).anyMatch(value -> value != nums[0]) ? 2 : 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new WiggleSubsequence().wiggleMaxLength(
                new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}
        )); // 7
    }
}