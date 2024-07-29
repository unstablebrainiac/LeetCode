package biweeklycontest135;

import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/minimum-length-of-string-after-operations/
 */
public class MinimumLengthOfStringAfterOperations {

    public int minimumLength(String s) {
        return s.chars()
                .boxed()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .values()
                .stream()
                .mapToInt(i -> i % 2 == 0 ? 2 : 1)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumLengthOfStringAfterOperations().minimumLength("abaacbcbb")); // 5
    }
}
