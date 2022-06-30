package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
 */
public class MinimumMovesToEqualArrayElements2 {
    public int minMoves2(int[] nums) {
        int median = Arrays.stream(nums)
                .sorted()
                .skip(nums.length / 2)
                .findFirst()
                .orElse(0);
        return Arrays.stream(nums)
                .map(num -> num - median)
                .map(Math::abs)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElements2().minMoves2(
                new int[]{1, 2, 3}
        )); // 2
    }
}
