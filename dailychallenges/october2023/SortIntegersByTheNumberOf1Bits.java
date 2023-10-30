package dailychallenges.october2023;

import java.util.Arrays;
import java.util.Comparator;

/*
 * https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
 */
public class SortIntegersByTheNumberOf1Bits {
    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .sorted(Comparator.comparing(num -> Integer.toBinaryString((Integer) num).chars().filter(c -> c == '1').count()).thenComparingInt(num -> (Integer) num))
                .mapToInt(num -> num)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortIntegersByTheNumberOf1Bits().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}))); // [0, 1, 2, 4, 8, 3, 5, 6, 7]
    }
}
