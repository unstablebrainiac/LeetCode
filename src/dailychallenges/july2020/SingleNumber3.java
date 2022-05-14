package dailychallenges.july2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3399/
 */
public class SingleNumber3 {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        diff &= -diff;

        int[] ans = {0, 0};
        for (int num : nums) {
            if ((num & diff) == 0) {
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SingleNumber3().singleNumber(
                new int[]{1, 2, 1, 3, 2, 5}
        ))); // [5, 3]
    }
}
