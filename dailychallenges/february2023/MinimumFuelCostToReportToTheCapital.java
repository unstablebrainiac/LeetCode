package dailychallenges.february2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * https://leetcode.com/problems/minimum-fuel-cost-to-report-to-the-capital/
 */
public class MinimumFuelCostToReportToTheCapital {
    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0) {
            return 0;
        }
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int[] road : roads) {
            adj.computeIfAbsent(road[0], value -> new ArrayList<>()).add(road[1]);
            adj.computeIfAbsent(road[1], value -> new ArrayList<>()).add(road[0]);
        }
        long[] fuel = {0};
        minimumFuelCost(adj, seats, 0, -1, fuel);
        return fuel[0];
    }

    private int minimumFuelCost(Map<Integer, List<Integer>> adj, int seats, int node, int parent, long[] fuel) {
        int numPeople = adj.get(node)
                .stream()
                .filter(value -> value != parent)
                .mapToInt(child -> minimumFuelCost(adj, seats, child, node, fuel))
                .sum() + 1;
        if (node != 0) {
            fuel[0] += (int) Math.ceil((double) numPeople / seats);
        }
        return numPeople;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumFuelCostToReportToTheCapital().minimumFuelCost(
                new int[][]{
                        new int[]{3, 1},
                        new int[]{3, 2},
                        new int[]{1, 0},
                        new int[]{0, 4},
                        new int[]{0, 5},
                        new int[]{4, 6}
                },
                2
        )); // 7
    }
}
