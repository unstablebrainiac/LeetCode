package dailychallenges.february2023;

import java.util.SortedSet;
import java.util.TreeSet;

/*
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInASortedArray {
    public int singleNonDuplicate(int[] nums) {
        SortedSet<Integer> sortedNums = new TreeSet<>();
        for (int num : nums) {
            if (sortedNums.contains(num)) {
                sortedNums.remove(num);
            } else {
                sortedNums.add(num);
            }
        }
        return sortedNums.first();
    }

    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(
                new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}
        )); // 2
    }
}
