import java.util.Arrays;

/*
 * https://leetcode.com/problems/two-sum/
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int size = nums.length;
        int[] diff = new int[size];
        int i, index = -1;
        for (i = 0 ; i < size ; i++) {
            int num = nums[i];
            index = index(diff, num, i);
            if (index != -1) {
                break;
            }
            diff[i] = target - num;
        }
        return new int[]{index,i};
    }

    private int index(int[] diff, int num, int maxIndex) {
        for (int i = 0 ; i < maxIndex ; i++) {
            if (diff[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum().twoSum(new int[]{2,7,11,15}, 9))); //[0,1]
    }
}