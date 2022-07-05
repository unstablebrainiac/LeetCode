package dailychallenges.july2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int maxSoFar = 0;
        for (int num : nums) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int start = num + 1;
            int currentLength = 1;
            while (numSet.contains(start)) {
                start++;
                currentLength++;
            }
            maxSoFar = Math.max(maxSoFar, currentLength);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(
                new int[]{100, 4, 200, 1, 3, 2}
        )); // 4
    }
}
