package weeklycontest367;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/
 */
public class FindIndicesWithIndexAndValueDifference2 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (indexDifference == 0 && valueDifference == 0) {
            return new int[]{0, 0};
        }
        int[] min = new int[nums.length];
        int[] max = new int[nums.length];
        min[nums.length - 1] = nums[nums.length - 1];
        max[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            min[i] = Math.min(min[i + 1], nums[i]);
            max[i] = Math.max(max[i + 1], nums[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            int j = i + indexDifference;
            if (j >= nums.length) {
                break;
            }
            if (Math.abs(nums[i] - min[j]) >= valueDifference || Math.abs(nums[i] - max[j]) >= valueDifference) {
                for (; j < nums.length; j++) {
                    if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                        return new int[]{i, j};
                    }
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindIndicesWithIndexAndValueDifference2().findIndices(
                new int[]{5, 1, 4, 1},
                2,
                4
        ))); // [0,3]
    }
}
