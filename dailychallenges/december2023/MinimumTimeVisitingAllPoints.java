package dailychallenges.december2023;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/minimum-time-visiting-all-points/
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        return IntStream.range(0, points.length - 1)
                .map(i -> Math.max(Math.abs(points[i][0] - points[i + 1][0]), Math.abs(points[i][1] - points[i + 1][1])))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new MinimumTimeVisitingAllPoints().minTimeToVisitAllPoints(
                new int[][]{
                        new int[]{1, 1},
                        new int[]{3, 4},
                        new int[]{-1, 0}
                }
        )); // 7
    }
}
