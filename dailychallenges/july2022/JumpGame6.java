package dailychallenges.july2022;

import common.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/jump-game-vi/
 */
public class JumpGame6 {
    public int maxResult(int[] nums, int k) {
        if (nums.length < 3) {
            return Arrays.stream(nums).sum();
        }
        int[] dp = new int[nums.length];
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(k + 1, Comparator.comparing((Pair pair) -> (int) pair.getValue()).reversed());
        pq.offer(Pair.of(nums.length - 1, nums[nums.length - 1]));
        dp[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            while (pq.peek().getKey() > i + k) {
                pq.poll();
            }
            dp[i] = nums[i] + pq.peek().getValue();
            pq.offer(Pair.of(i, dp[i]));
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame6().maxResult(
                new int[]{1, -1, -2, 4, -7, 3},
                2
        )); // 7
    }
}
