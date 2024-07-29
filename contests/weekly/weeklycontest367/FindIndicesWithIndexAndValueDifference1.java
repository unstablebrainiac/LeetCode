package contests.weekly.weeklycontest367;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-indices-with-index-and-value-difference-i/
 */
public class FindIndicesWithIndexAndValueDifference1 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        if (indexDifference == 0 && valueDifference == 0) {
            return new int[]{0, 0};
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + indexDifference; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindIndicesWithIndexAndValueDifference1().findIndices(
                new int[]{5, 1, 4, 1},
                2,
                4
        ))); // [0,3]
    }
}
