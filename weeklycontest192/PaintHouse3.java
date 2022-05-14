package weeklycontest192;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/weekly-contest-192/problems/paint-house-iii/
 */
public class PaintHouse3 {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int minCost = -1;
        if (minNumberOfNeighborhoods(houses) > target) {
            return -1;
        }
        if (maxNumberOfNeighborhoods(houses, n) < target) {
            return -1;
        }
        int numberOfHousesToBePainted = (int) Arrays.stream(houses).filter(value -> value == 0).count();
        if (numberOfHousesToBePainted == 0) {
            int numberOfNeighborhoods = numberOfNeighborhoods(houses);
            return numberOfNeighborhoods == target ? 0 : -1;
        }
        for (int i = 0; i < m; i++) {
            if (houses[i] == 0) {
//                if (i == 0 && houses[1] != 0 ||
//                i == m - 1 && houses[m - 1] != 0 ||
//                houses[i - 1] != 0 && houses[i + 1] != 0) {
//                    int colourWithMinimumCost = Arrays.stream(cost[i]).min().getAsInt();
//                    houses[i] = colourWithMinimumCost;
//                    int currentCost =
//                }
                for (int j = 1; j <= n; j++) {
                    houses[i] = j;
                    int cost1 = minCost(houses, cost, m, n, target);
                    houses[i] = 0;
                    if (cost1 == -1) {
                        continue;
                    }
                    int currentCost = cost[i][j - 1] + cost1;
                    minCost = minCost == -1 ? currentCost : Math.min(currentCost, minCost);
                }
            }
        }
        return minCost;
    }

    private int numberOfNeighborhoods(int[] houses) {
        int num = 1;
        int currentColour = houses[0];
        for (int i = 1; i < houses.length; i++) {
            if (currentColour != houses[i]) {
                num++;
                currentColour = houses[i];
            }
        }
        return num;
    }

    private int maxNumberOfNeighborhoods(int[] houses, int n) {
        if (n == 1) {
            return 1;
        }
        int num = 1;
        int currentColour = houses[0];
        if (n == 2) {
            for (int i = 1; i < houses.length; i++) {
                if (currentColour != houses[i] && houses[i] != 0) {
                    num++;
                    currentColour = houses[i];
                } else if (houses[i] == 0) {
                    num++;
                    currentColour = currentColour == 1 ? 2 : 1;
                }
            }
        } else {
            for (int i = 1; i < houses.length; i++) {
                if (currentColour != houses[i] && houses[i] != 0) {
                    num++;
                    currentColour = houses[i];
                } else if (houses[i] == 0) {
                    num++;
                    currentColour = n + 1;
                }
            }
        }
        return num;
    }

    private int minNumberOfNeighborhoods(int[] houses) {
        int num = 1;
        int currentColour = houses[0];
        for (int i = 0; i < houses.length; i++) {
            if (currentColour != houses[i] && houses[i] != 0 && currentColour != 0) {
                num++;
                currentColour = houses[i];
            }
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new PaintHouse3().minCost(
                new int[]{0, 2, 1, 2, 0},
                new int[][]{{1, 10}, {10, 1}, {10, 1}, {1, 10}, {5, 1}},
                5,
                2,
                3
        ));
    }
}
