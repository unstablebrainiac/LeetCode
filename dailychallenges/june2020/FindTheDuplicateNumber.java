package dailychallenges.june2020;

import java.util.Arrays;
import java.util.HashSet;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3371/
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        HashSet<Object> numSet = new HashSet<>();
        return Arrays.stream(nums)
                .filter(num -> !numSet.add(num))
                .findFirst()
                .orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDuplicateNumber().findDuplicate(
                new int[]{3, 1, 3, 4, 2}
        )); // 3
    }
}
