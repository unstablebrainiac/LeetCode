import java.util.Arrays;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int current = nums[0], j = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == current) {
                continue;
            }
            current = nums[i];
            nums[j] = current;
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(
                new int[]{0,0,1,1,1,2,2,3,3,4}
        )); // 0,1,2,3,4
    }
}
