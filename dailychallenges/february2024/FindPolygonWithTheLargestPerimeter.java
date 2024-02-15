package dailychallenges.february2024;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-polygon-with-the-largest-perimeter/
 */
public class FindPolygonWithTheLargestPerimeter {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = Arrays.stream(nums).mapToLong(i -> (long) i).sum();

        for (int i = nums.length - 1; i >= 2; i--) {
            sum -= nums[i];
            if (sum > nums[i]) {
                return sum + nums[i];
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FindPolygonWithTheLargestPerimeter().largestPerimeter(
                new int[]{1, 12, 1, 2, 5, 50, 3})
        ); // 12
    }
}
