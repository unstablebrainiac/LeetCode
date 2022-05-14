package dailychallenges.august2020;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/549/week-1-august-1st-august-7th/3414/
 */
public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        int num, index;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            if (num == 0) {
                continue;
            }
            index = num - 1;
            if (num == nums[index] && index == i) {
                continue;
            }
            nums[i] = 0;
            while (num != nums[index]) {
                if (nums[index] == 0) {
                    nums[index] = num;
                    num = 0;
                    break;
                }
                if (index != i) {
                    int temp = nums[index];
                    nums[index] = num;
                    num = temp;
                    index = num - 1;
                    if (index == -1) {
                        break;
                    }
                }
            }
            if (num != 0) {
                ans.add(num);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllDuplicatesInAnArray().findDuplicates(
                new int[]{4, 3, 2, 7, 8, 2, 3, 1}
        )); // [3, 2]
    }
}
