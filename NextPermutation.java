import java.util.Arrays;

/*
 * https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int lastIncrementalIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                lastIncrementalIndex = i;
                break;
            }
        }
        System.out.println(lastIncrementalIndex);
        if (lastIncrementalIndex == -1) {
            Arrays.sort(nums);
            return;
        }
        int replacementIndex = nums.length - 1;
        for (int i = lastIncrementalIndex + 1; i < nums.length; i++) {
            if (nums[i] <= nums[lastIncrementalIndex]) {
                replacementIndex = i - 1;
                break;
            }
        }
        System.out.println(replacementIndex);
        swap(nums, lastIncrementalIndex, replacementIndex);
        Arrays.sort(nums, lastIncrementalIndex + 1, nums.length);
        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int index1, int index2) {
        nums[index1] ^= nums[index2];
        nums[index2] ^= nums[index1];
        nums[index1] ^= nums[index2];
    }

    public static void main(String[] args) {
        new NextPermutation().nextPermutation(new int[]{1, 5, 1}); // 1,3,2
    }
}

//12345
//12354
//12435
//12453
//12534
//12543
//13245
//13254
//13425
//13452
//13524
//13542
//14235
//14253
//14325
//14352
//14523
//14532
//15234
//15243
//15324
//15342
//15423
//15432
//21345
//
//25431 35421
//31245
