package dailychallenges.september2023;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
 */
public class TheKWeakestRowsInAMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        return IntStream.range(0, mat.length)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), i -> Arrays.stream(mat[i]).sum()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TheKWeakestRowsInAMatrix().kWeakestRows(
                new int[][]{
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 0},
                        {1, 0, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {1, 1, 1, 1, 1}
                }, 3
        ))); // [2, 0, 3]
    }
}
