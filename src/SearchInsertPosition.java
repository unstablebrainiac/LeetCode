import java.util.Arrays;

/*
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int midIndex = nums.length / 2;
        int mid = nums[midIndex];
        if (mid == target) {
            return midIndex;
        } else if (mid < target) {
            return searchInsert(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target) + midIndex + 1;
        } else {
            return searchInsert(Arrays.copyOfRange(nums, 0, midIndex), target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsertPosition().searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
    }
}
