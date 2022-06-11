import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinimumOperationsToReduceXToZero {
    public int minOperations(int[] nums, int x) {
        int sum = Arrays.stream(nums).sum();
        int remaining = sum - x;

        int maxSoFar = -1;
        int start = 0;
        int end = 0;
        int current = 0;

        while (end < nums.length && start < nums.length) {
            if (current == remaining) {
                maxSoFar = Math.max(end - start, maxSoFar);
                current += nums[end++];
            } else if (current < remaining) {
                current += nums[end++];
            } else {
                current -= nums[start++];
            }
        }
        while(start < nums.length && current >= remaining) {
            if (current == remaining) {
                maxSoFar = Math.max(end - start, maxSoFar);
            }
            current -= nums[start++];
        }
        return maxSoFar == -1 ? -1 : nums.length - maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(
                new int[]{5, 2, 3, 1, 1},
                5
        )); // 2
    }
}
