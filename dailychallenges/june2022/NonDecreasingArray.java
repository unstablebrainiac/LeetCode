package dailychallenges.june2022;

/*
 * https://leetcode.com/problems/non-decreasing-array/
 */
public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int last = Integer.MIN_VALUE;
        int current = Integer.MIN_VALUE;
        boolean modified = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < current) {
                if (modified || (last > nums[i] && i < nums.length - 1 && current > nums[i + 1])) {
                    return false;
                } else {
                    modified = true;
                }
            }
            last = current;
            current = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(
                new int[]{4, 2, 3}
        )); // true
    }
}
