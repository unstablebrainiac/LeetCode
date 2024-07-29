package contests.biweekly.biweeklycontest27;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-27/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 */
public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] arr) {
        Arrays.sort(target);
        Arrays.sort(arr);
        return Arrays.equals(arr, target);
    }

    public static void main(String[] args) {
        System.out.println(new MakeTwoArraysEqualByReversingSubArrays().canBeEqual(
                new int[]{1, 2, 3, 4},
                new int[]{2, 4, 1, 3}
        )); // true
    }
}
