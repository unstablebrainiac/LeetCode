import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/4sum/
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            threeSum(nums, i, list, target);
        }
        return removeDuplicates(list);
    }

    private void threeSum(int[] nums, int index, List<List<Integer>> list, int target) {
        for (int i = index + 1; i < nums.length; i++) {
            twoSum(nums, index, i, list, target);
        }
    }

    private void twoSum(int[] nums, int index1, int index2, List<List<Integer>> list, int target) {
        int twoSum = nums[index1] + nums[index2];
        int i = index2 + 1, j = nums.length - 1;
        while (j > i) {
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
                continue;
            }
            int sum = nums[i] + nums[j];
            if (sum + twoSum == target) {
                list.add(asList(nums[index1], nums[index2], nums[i], nums[j]));
                i++;
                j--;
            } else if (sum + twoSum > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    private List<List<Integer>> removeDuplicates(List<List<Integer>> list) {
        return list.stream().peek(integers -> integers.sort(Integer::compareTo)).distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(new FourSum().fourSum(new int[]{0,0,0,0}, 0));
    }
}
