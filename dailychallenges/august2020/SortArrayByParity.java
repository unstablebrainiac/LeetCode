package dailychallenges.august2020;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3431/
 */
public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        return Arrays.stream(A)
                .boxed()
                .sorted(Comparator.comparing(integer -> integer % 2))
                .mapToInt(value -> value)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortArrayByParity().sortArrayByParity(
                new int[]{3, 1, 2, 4}
        ))); // [2, 4, 3, 1]
    }
}
