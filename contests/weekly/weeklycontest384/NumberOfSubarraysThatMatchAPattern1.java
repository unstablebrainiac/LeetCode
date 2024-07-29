package contests.weekly.weeklycontest384;

/*
 * https://leetcode.com/problems/number-of-subarrays-that-match-a-pattern-i/
 */
public class NumberOfSubarraysThatMatchAPattern1 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int[] trend = new int[nums.length - 1];
        for (int i = 0; i < trend.length; i++) {
            if (nums[i + 1] > nums[i]) {
                trend[i] = 1;
            } else if (nums[i + 1] < nums[i]) {
                trend[i] = -1;
            } else {
                trend[i] = 0;
            }
        }

        int count = 0;
        for (int i = 0; i < trend.length - pattern.length + 1; i++) {
            boolean match = true;
            for (int j = 0; j < pattern.length; j++) {
                if (trend[i + j] != pattern[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubarraysThatMatchAPattern1().countMatchingSubarrays(
                new int[]{1, 4, 4, 1, 3, 5, 5, 3},
                new int[]{1, 0, -1}
        )); // 2
    }
}
