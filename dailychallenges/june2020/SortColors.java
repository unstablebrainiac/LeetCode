package dailychallenges.june2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3357/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int leftIndex = 1;
        int rightIndex = nums.length - 1;
        for (int i = 0; leftIndex <= rightIndex + 1; i++) {
            System.out.println(i + " " + leftIndex + " " + rightIndex + " " + Arrays.toString(nums));
            switch (nums[i]) {
                case 0 -> leftIndex = Math.max(i + 1, leftIndex);
                case 1 -> {
                    if (leftIndex > rightIndex) {
                        leftIndex++;
                        break;
                    }
                    swap(nums, i, leftIndex);
                    leftIndex++;
                    i--;
                }
                case 2 -> {
                    swap(nums, i, rightIndex);
                    rightIndex--;
                    i--;
                }
            }
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        if (index1 == index2) {
            return;
        }
        arr[index1] ^= arr[index2];
        arr[index2] ^= arr[index1];
        arr[index1] ^= arr[index2];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 0, 0, 1, 2};
        new SortColors().sortColors(nums);
        System.out.println(Arrays.toString(nums)); // 0,0,1,1,2,2
    }
}
