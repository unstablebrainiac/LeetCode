package contests.weekly.weeklycontest372;

import common.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/
 *
 * Does not pass
 */
public class FindBuildingWhereAliceAndBobCanMeet {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        List<List<Pair<Integer, Integer>>> heightToIndex = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            heightToIndex.add(new LinkedList<>());
        }
        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                if (heights[i] >= heights[j]) {
                    heightToIndex.get(j).add(0, new Pair<>(i, heights[i]));
                } else {
                    break;
                }
            }
        }
        System.out.println(heightToIndex);
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == queries[i][1]) {
                ans[i] = queries[i][0];
                continue;
            }
            int secondBuilding = Math.max(queries[i][0], queries[i][1]);
            int minHeight = Math.max(heights[queries[i][0]], heights[queries[i][1]]);
            int firstHeight = heights[Math.min(queries[i][0], queries[i][1])];
            int secondHeight = heights[secondBuilding];
            if (firstHeight >= secondHeight) {
                minHeight++;
            }
            for (Pair<Integer, Integer> nextHeight : heightToIndex.get(secondBuilding)) {
                if (nextHeight.getValue() >= minHeight) {
                    ans[i] = nextHeight.getKey();
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindBuildingWhereAliceAndBobCanMeet().leftmostBuildingQueries(
                new int[]{6, 4, 8, 5, 2, 7},
                new int[][]{
                        {0, 1},
                        {0, 3},
                        {2, 4},
                        {3, 4},
                        {2, 2}
                }
        ))); // [2,5,-1,5,2]
    }
}
