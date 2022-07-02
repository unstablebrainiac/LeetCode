package dailychallenges.july2022;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/maximum-units-on-a-truck/
 */
public class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        return Arrays.stream(boxTypes)
                .sorted(Comparator.comparing((int[] boxType) -> boxType[1]).reversed())
                .flatMapToInt(boxType -> IntStream.range(0, boxType[0]).map(i -> boxType[1]))
                .limit(truckSize)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumUnitsOnATruck().maximumUnits(
                new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 2},
                        new int[]{3, 1}
                },
                4
        ));
    }
}
