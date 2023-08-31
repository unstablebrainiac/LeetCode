package dailychallenges.august2023;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
 */
public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {
        int[] maxJump = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            int tapStart = Math.max(0, i - ranges[i]);
            int tapEnd = Math.min(n, i + ranges[i]);
            maxJump[tapStart] = Math.max(maxJump[tapStart], tapEnd - tapStart);
        }

        return jump(maxJump);
    }

    /*
     * https://leetcode.com/problems/jump-game-ii/
     */
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int max = nums[0];
        int jumps = 1;
        int start = 0, end = 0;

        while (max < nums.length - 1) {
            jumps++;
            start = end + 1;
            end = max;
            OptionalInt maybeMax = IntStream.range(start, end + 1)
                    .map(index -> index + nums[index])
                    .max();
            if (maybeMax.isEmpty()) {
                return -1;
            }
            max = maybeMax
                    .orElseThrow();
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfTapsToOpenToWaterAGarden().minTaps(
                5,
                new int[]{3, 4, 1, 1, 0, 0}
        )); // 1
    }
}
