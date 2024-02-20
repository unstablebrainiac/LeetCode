package dailychallenges.february2024;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        return nums.length * (nums.length + 1) / 2 - Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        System.out.println(new MissingNumber().missingNumber(
                new int[]{3, 0, 1}
        )); // 2
    }
}
