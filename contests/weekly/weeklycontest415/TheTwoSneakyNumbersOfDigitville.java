package contests.weekly.weeklycontest415;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
 */
public class TheTwoSneakyNumbersOfDigitville {

    public int[] getSneakyNumbers(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 2)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TheTwoSneakyNumbersOfDigitville().getSneakyNumbers(new int[]{7, 1, 5, 4, 3, 4, 6, 0, 9, 5, 8, 2}))); // [4, 5]
    }
}
