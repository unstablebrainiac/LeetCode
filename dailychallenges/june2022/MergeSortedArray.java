package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        boolean takeElementFromFirst;
        while(index1 != index) {
            if (index1 == -1) {
                takeElementFromFirst = false;
            } else if (index2 == -1) {
                takeElementFromFirst = true;
            } else {
                takeElementFromFirst = nums1[index1] > nums2[index2];
            }
            if (takeElementFromFirst) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new MergeSortedArray().merge(
                nums1,
                3,
                nums2,
                3
        );
        System.out.println(Arrays.toString(nums1)); // [1, 2, 2, 2, 5, 6]
    }
}
