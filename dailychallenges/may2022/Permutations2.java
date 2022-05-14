package dailychallenges.may2022;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;

/*
 * https://leetcode.com/problems/permutations-ii/
 */
public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return permuteUnique(nums, 0);
    }

    private List<List<Integer>> permuteUnique(int[] nums, int index) {
        if (index == nums.length - 1) {
            LinkedList<Integer> singleton = new LinkedList<>();
            singleton.add(nums[index]);
            return singletonList(singleton);
        }
        return permuteUnique(nums, index + 1)
                .stream()
                .map(list -> createLists(list, nums[index]))
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    private List<List<Integer>> createLists(List<Integer> list, int num) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= list.size(); i++) {
            List<Integer> newList = new LinkedList<>(list);
            newList.add(i, num);
            lists.add(newList);
        }
        return lists.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Permutations2().permuteUnique(
                new int[]{1, 1, 2}
        )); // [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}
