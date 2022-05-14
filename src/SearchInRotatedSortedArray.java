import java.util.Arrays;

/*
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        System.out.println(Arrays.toString(nums));
        if (nums.length == 0) {
            return -1;
        }
        int midIndex = nums.length >> 1;
        int mid = nums[midIndex];
        if (mid == target) {
            return midIndex;
        }
        if (mid > target) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[0] > target) {
                if (mid > nums[0]) {
                    int result = search(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target);
                    return result == -1 ? result : result + midIndex + 1;
                } else {
                    return search(Arrays.copyOfRange(nums, 0, midIndex), target);
                }
            } else {
                int result = Arrays.binarySearch(nums, 0, midIndex, target);
                return result >= 0 ? result : -1;
            }
        } else {
            int lastIndex = nums.length - 1;
            if (nums[lastIndex] == target) {
                return lastIndex;
            } else if (nums[lastIndex] > target) {
                int result = Arrays.binarySearch(nums, midIndex, nums.length, target);
                return result >= 0 ? result : -1;
            } else {
                if (mid > nums[lastIndex]) {
                    int result = search(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target);
                    return result == -1 ? result : result + midIndex + 1;
                } else {
                    return search(Arrays.copyOfRange(nums, 0, midIndex), target);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0)); // 4
    }
}
