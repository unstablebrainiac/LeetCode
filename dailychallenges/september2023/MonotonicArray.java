package dailychallenges.september2023;

/*
 * https://leetcode.com/problems/monotonic-array/
 */
public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        int i = 0;
        for (i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                break;
            }
        }
        if (i == nums.length - 1) {
            return true;
        }
        boolean increasing = nums[i + 1] > nums[i];
        for (; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1] && !increasing) {
                return false;
            }
            if (nums[i] > nums[i + 1] && increasing) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{1, 2, 2, 3})); // true
    }
}
