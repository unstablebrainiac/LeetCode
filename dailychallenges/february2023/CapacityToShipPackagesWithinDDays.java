package dailychallenges.february2023;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int minSize = (int) Math.ceil((double) Arrays.stream(weights).sum() / days);
        while (!trySize(minSize, weights, days)) {
            minSize++;
        }
        return minSize;
    }

    private boolean trySize(int size, int[] weights, int days) {
        int day = 0, capacity = 0;
        for (int weight : weights) {
            if (weight > size) {
                return false;
            }
            if (capacity + weight > size) {
                day++;
                capacity = 0;
            }
            if (day == days) {
                return false;
            }
            capacity += weight;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CapacityToShipPackagesWithinDDays().shipWithinDays(
                new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                5
        )); // 15
    }
}
