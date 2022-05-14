package dailychallenges.july2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3387/
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int start) {
        if (start == nums.length - 1) {
            return Arrays.asList(Collections.singletonList(nums[start]), Collections.emptyList());
        }
        return subsets(nums, start + 1)
                .stream()
                .map(integers -> {
                    ArrayList<Integer> integers1 = new ArrayList<>(integers);
                    integers1.add(nums[start]);
                    return Stream.of(integers1, integers);
                })
                .flatMap(Function.identity())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(
                new int[]{1, 2, 3}
        ));
    }
}
