import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/3sum/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            twoSum(nums, i, list);
        }
        return list;
    }

    private void twoSum(int[] nums, int index, List<List<Integer>> list) {
        int twoSum = -nums[index];
        int i = index + 1, j = nums.length - 1;
        while (j > i) {
            if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                j--;
                continue;
            }
            int sum = nums[i] + nums[j];
            if (sum == twoSum && i != index && j != index) {
                list.add(asList(nums[index], nums[i], nums[j]));
                i++;
                j--;
            } else if (sum > twoSum) {
                j--;
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
//      [
//          [-1, 0, 1],
//          [-1, -1, 2]
//      ]
    }
}
