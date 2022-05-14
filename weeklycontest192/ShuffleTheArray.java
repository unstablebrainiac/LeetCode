package weeklycontest192;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-192/problems/shuffle-the-array/
 */
public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < n; i++) {
            ans[i << 1] = nums[i];
            ans[(i << 1) + 1] = nums[n + i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShuffleTheArray().shuffle(
                new int[]{2, 5, 1, 3, 4, 7},
                3
        ))); // [2, 3, 5, 4, 1, 7]
    }
}
