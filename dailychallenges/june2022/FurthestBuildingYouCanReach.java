package dailychallenges.june2022;

import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/furthest-building-you-can-reach/
 */
public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int i;
        for (i = 0; i < heights.length - 1; i++) {
            int climb = heights[i + 1] - heights[i];
            if (climb < 0) {
                continue;
            }
            queue.add(climb);
            if (ladders > 0) {
                ladders--;
            } else {
                Integer minClimb = queue.poll();
                bricks -= minClimb;
                if (bricks < 0) {
                    break;
                }
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new FurthestBuildingYouCanReach().furthestBuilding(
                new int[]{4, 2, 7, 6, 9, 14, 12},
                5,
                1
        )); // 4
    }
}
