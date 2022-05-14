import java.util.Arrays;

/*
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        if (size2 == 0) {
            return findMedian(nums1);
        } else if (size1 == 0) {
            return findMedian(nums2);
        }

        if (nums1[0] >= nums2[size2 - 1]) {
            int[] arr = Arrays.copyOf(nums2, size1 + size2);
            System.arraycopy(nums1, 0, arr, size2, size1);
            return findMedian(arr);
        } else if (nums2[0] >= nums1[size1 - 1]) {
            int[] arr = Arrays.copyOf(nums1, size1 + size2);
            System.arraycopy(nums2, 0, arr, size1, size2);
            return findMedian(arr);
        } else {
            if (nums1[0] <= nums2[0]) {
                nums1 = Arrays.copyOfRange(nums1, 1, size1--);
            } else {
                nums2 = Arrays.copyOfRange(nums2, 1, size2--);
            }
            if (nums1[size1 - 1] <= nums2[size2 - 1]) {
                nums2 = Arrays.copyOfRange(nums2, 0, size2 - 1);
            } else {
                nums1 = Arrays.copyOfRange(nums1, 0, size1 - 1);
            }
            return findMedianSortedArrays(nums1, nums2);
        }
    }

    public double findMedian(int[] nums) {
        int size = nums.length;
        if ((size & 1) == 0) {
            return (double) (nums[(size >> 1) - 1] + nums[size >> 1]) / 2;
        } else {
            return nums[(size - 1) >> 1];
        }
    }

    public static void main(String[] args) {
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1, 3, 5},
                new int[]{2}
        )); // 2.5
    }
}
