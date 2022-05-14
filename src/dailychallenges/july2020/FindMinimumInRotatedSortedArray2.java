package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/547/week-4-july-22nd-july-28th/3401/
 */
public class FindMinimumInRotatedSortedArray2 {
    public int findMin(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new FindMinimumInRotatedSortedArray2().findMin(
                new int[]{2, 2, 2, 0, 1}
        )); // 0
    }
}
