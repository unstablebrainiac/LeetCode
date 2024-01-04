package dailychallenges.january2024;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/minimum-number-of-operations-to-make-array-empty/
 */
public class MinimumNumberOfOperationsToMakeArrayEmpty {
    public int minOperations(int[] nums) {
        Collection<Long> frequencies = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values();

        if (frequencies.stream().anyMatch(frequency -> frequency <= 1)) {
            return -1;
        }

        return frequencies.stream().mapToInt(Long::intValue).map(this::minOperations).sum();
    }

    private int minOperations(int frequency) {
        if (frequency % 3 == 0) {
            return frequency / 3;
        } else {
            return frequency / 3 + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinimumNumberOfOperationsToMakeArrayEmpty().minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4})); // 4
    }
}
