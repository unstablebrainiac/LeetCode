package dailychallenges.may2022;

/*
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 */
public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int start = 0, end = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            if (nums[i] < max) {
                end = i;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(nums[i], min);
            if (nums[i] > min) {
                start = i;
            }
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(
                new int[]{2, 6, 4, 8, 10, 9, 15}
        ));
    }
}
