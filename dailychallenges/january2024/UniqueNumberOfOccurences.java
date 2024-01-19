package dailychallenges.january2024;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/unique-number-of-occurrences/
 */
public class UniqueNumberOfOccurences {
    public boolean uniqueOccurrences(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .distinct()
                .count() == Arrays.stream(arr).distinct().count();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueNumberOfOccurences().uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3})); // true
    }
}
