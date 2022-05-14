package biweeklycontest29;

/*
 * https://leetcode.com/contest/biweekly-contest-29/problems/longest-subarray-of-1s-after-deleting-one-element/
 */
public class LongestSubarrayOfOnesAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int curr = 0;
        int postZero = 0;
        boolean hasZero = false;
        boolean atLeastOneZero = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                curr++;
                if (hasZero) {
                    postZero++;
                }
            } else {
                atLeastOneZero = true;
                if (hasZero) {
                    if (postZero == 0) {
                        hasZero = false;
                    }
                    max = Math.max(max, curr);
                    curr = postZero;
                    postZero = 0;
                } else {
                    if (curr != 0) {
                        hasZero = true;
                    }
                }
            }
        }
        return atLeastOneZero ? Math.max(max, curr) : curr - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubarrayOfOnesAfterDeletingOneElement().longestSubarray(
                new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1}
        )); // 5
    }
}
