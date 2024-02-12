package dailychallenges.february2024;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max((entry1, entry2) -> (int) (entry1.getValue() - entry2.getValue()))
                .orElseThrow()
                .getKey();
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[]{3, 2, 3})); // 3
    }
}
