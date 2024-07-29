package contests.biweekly.biweeklycontest29;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/contest/biweekly-contest-29/problems/parallel-courses-ii/
 */
public class ParallelCourses2 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[] branchLength = new int[n + 1];
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            branchLength[i] = computeBranchLength(dependencies, i, dp);
        }
        boolean[] coursesCompleted = new boolean[n + 1];
        boolean[] preReqsCleared = new boolean[n + 1];
        int semester = 0;
        while (hasIncompleteCourses(coursesCompleted)) {
            for (int i = 1; i <= n; i++) {
                preReqsCleared[i] = preReqsCleared(dependencies, coursesCompleted, i);
            }
            IntStream.range(1, n + 1)
                    .filter(value -> !coursesCompleted[value])
                    .filter(value -> preReqsCleared[value])
                    .boxed()
                    .sorted(Comparator.comparingInt(o -> branchLength[(int) o]).reversed())
                    .limit(k)
                    .forEach(integer -> coursesCompleted[integer] = true);
            semester++;
        }
        return semester;
    }

    private boolean hasIncompleteCourses(boolean[] coursesCompleted) {
        for (int i = 1; i < coursesCompleted.length; i++) {
            if (!coursesCompleted[i]) {
                return true;
            }
        }
        return false;
    }

    private boolean preReqsCleared(int[][] dependencies, boolean[] coursesCompleted, int i) {
        return Arrays.stream(dependencies)
                .filter(ints -> ints[1] == i)
                .mapToInt(value -> value[0])
                .filter(value -> !coursesCompleted[value])
                .count() == 0;
    }

    private int computeBranchLength(int[][] dependencies, int i, int[] dp) {
        if (dp[i] != 0) {
            return dp[i];
        }
        return Arrays.stream(dependencies)
                .filter(ints -> ints[0] == i)
                .mapToInt(ints -> ints[1])
                .map(i1 -> computeBranchLength(dependencies, i1, dp))
                .map(integer -> integer + 1)
                .max()
                .orElse(1);
    }

    public static void main(String[] args) {
        System.out.println(new ParallelCourses2().minNumberOfSemesters(
                8,
                new int[][]{
                        {1, 4},
                        {2, 5},
                        {3, 4},
                        {3, 5},
                        {3, 6},
                        {4, 7},
                        {5, 7},
                        {6, 7},
                        {7, 8}
                },
                2
        )); // 4
    }
}
