package biweeklycontest27;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/contest/biweekly-contest-27/problems/course-schedule-iv/
 */
public class CourseSchedule4 {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean[][] prerequisiteGrid = new boolean[n][n];
        for (int[] prerequisite : prerequisites) {
            addPrerequisiteToGrid(n, prerequisiteGrid, prerequisite);
        }
        return Arrays.stream(queries).map(query -> prerequisiteGrid[query[0]][query[1]]).collect(Collectors.toList());
    }

    private void addPrerequisiteToGrid(int n, boolean[][] prerequisiteList, int[] prerequisite) {
        prerequisiteList[prerequisite[0]][prerequisite[1]] = true;
        for (int i = 0; i < n; i++) {
            if (prerequisiteList[i][prerequisite[0]]) {
                addPrerequisiteToGrid(n, prerequisiteList, new int[]{i, prerequisite[1]});
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule4().checkIfPrerequisite(
                5,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}},
                new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}}
        )); // [true,false,true,false]
    }
}
