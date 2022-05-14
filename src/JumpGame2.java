import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/jump-game-ii/
 */
public class JumpGame2 {
//    public int jump(int[] nums) {
//        if (nums.length == 1) {
//            return 0;
//        }
//        int[] min = new int[nums.length];
//        Arrays.fill(min, -1);
//        min[nums.length - 1] = Integer.MAX_VALUE;
//        return jump(nums, 0, 0, min);
//    }
//
//    private int jump(int[] nums, int index, int numJumpsSoFar, int[] min) {
//        if (index + nums[index] >= nums.length - 1) {
//            return numJumpsSoFar + 1;
//        }
//        if (index == nums.length - 1) {
//            min[nums.length - 1] = Math.min(min[nums.length - 1], numJumpsSoFar);
//            return numJumpsSoFar;
//        }
//        if (min[index] != -1 && numJumpsSoFar > min[index]) {
//            return min[index];
//        }
//        if (numJumpsSoFar >= min[nums.length - 1]) {
//            return Integer.MAX_VALUE;
//        }
//        int ans = IntStream.range(0, nums[index])
//                .map(num -> nums[index] - num)
//                .map(num -> jump(nums, index + num, numJumpsSoFar + 1, min))
//                .min()
//                .orElse(Integer.MAX_VALUE);
//        min[index] = Math.min(min[index], ans);
//        return ans;
//    }

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
            max = IntStream.range(start, end + 1)
                    .map(index -> index + nums[index])
                    .max()
                    .orElseThrow();
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame2().jump(
                new int[]{2, 3, 0, 1, 4}
        )); // 2
    }
}
