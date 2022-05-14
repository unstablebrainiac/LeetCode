/*
 * https://leetcode.com/problems/first-missing-positive/
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        boolean lengthElementPresent = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            } else if (nums[i] == nums.length) {
                lengthElementPresent = true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            checkIndexAndSetZero(nums, nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }
        return lengthElementPresent ? nums.length + 1 : nums.length;
    }

    private void checkIndexAndSetZero(int[] nums, int value) {
        if (value > 0 && value < nums.length) {
            int temp = nums[value];
            nums[value] = 0;
            checkIndexAndSetZero(nums, temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1})); // 2
    }
}
