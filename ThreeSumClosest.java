import java.util.Arrays;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/3sum-closest/
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int globalClosestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int closestDistance = twoSumClosestDistance(nums, i, target);
            if (closestDistance == 0) {
                return target;
            }
            if (Math.abs(closestDistance) < Math.abs(globalClosestDistance)) {
                globalClosestDistance = closestDistance;
            }
        }
        return target + globalClosestDistance;
    }

    private int twoSumClosestDistance(int[] nums, int index, int target) {
        int i = index + 1, j = nums.length - 1;
        int closestDistance = Integer.MAX_VALUE;
        while (j > i) {
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
                continue;
            }
            int sum = nums[i] + nums[j] + nums[index];
            if (Math.abs(closestDistance) > Math.abs(sum - target)) {
                closestDistance = sum - target;
            }
            if (sum == target) {
                return 0;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return closestDistance;
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1)); // 2
    }
}
