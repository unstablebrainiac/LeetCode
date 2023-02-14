import java.util.Arrays;

/*
 * https://leetcode.com/problems/largest-perimeter-triangle/
 */
public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int maxSoFar = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                maxSoFar = Math.max(maxSoFar, nums[i] + nums[i - 1] + nums[i - 2]);
            }
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new LargestPerimeterTriangle().largestPerimeter(
                new int[]{1, 2, 1, 10}
        )); // 0
    }
}
