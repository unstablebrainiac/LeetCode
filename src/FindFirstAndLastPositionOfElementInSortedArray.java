import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int anyIndex = Arrays.binarySearch(nums, target);
        if (anyIndex < 0) {
            return new int[]{-1, -1};
        }
        return expandRange(nums, target, anyIndex);
    }

    private int[] expandRange(int[] nums, int target, int anyIndex) {
        int[] ans = new int[]{anyIndex, anyIndex};
        int firstIndex = anyIndex - 1;
        while (firstIndex != -1) {
            if (nums[firstIndex] != target) {
                break;
            }
            ans[0]--;
            firstIndex--;
        }
        int lastIndex = anyIndex + 1;
        while (lastIndex != nums.length) {
            if (nums[lastIndex] != target) {
                break;
            }
            ans[1]++;
            lastIndex++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8))); // 3.4
    }
}
