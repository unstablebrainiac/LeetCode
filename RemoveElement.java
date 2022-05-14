import java.util.Arrays;

/*
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[j] = nums[i];
            j++;
        }
        return j;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(
                new int[]{0,1,2,2,3,0,4,2},
                2
        )); // 5
    }
}
