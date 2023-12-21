package dailychallenges.december2023;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/
 */
public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        List<Integer> sortedX = Arrays.stream(points)
                .map(point -> point[0])
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        return IntStream.range(0, sortedX.size() - 1)
                .map(i -> sortedX.get(i + 1) - sortedX.get(i))
                .max()
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(new WidestVerticalAreaBetweenTwoPointsContainingNoPoints().maxWidthOfVerticalArea(new int[][]{{8,7},{9,9},{7,4},{9,7}})); // 1
    }
}
