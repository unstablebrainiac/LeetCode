package dailychallenges.june2020;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3360/
 */
public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> flightsBySource =
                Arrays.stream(flights).collect(Collectors.groupingBy(ints -> ints[0]));
        flightsBySource.values().forEach(ints -> ints.sort((o1, o2) -> o1[2] - o2[2]));
        return findCheapestPrice(n, flightsBySource, src, dst, K);
    }

    private int findCheapestPrice(int n, Map<Integer, List<int[]>> flightsBySource, int src, int dst, int K) {
        if (src == dst) {
            return 0;
        }
        if (K == -1) {
            return -1;
        }
        int minCost = Integer.MAX_VALUE;
        List<int[]> flights = flightsBySource.get(src);
        if (flights == null || flights.isEmpty()) {
            return -1;
        }
        for (int[] flight : flights) {
            if (flight[0] == src && flight[2] < minCost) {
                int onwardJourneyCost = findCheapestPrice(n, flightsBySource, flight[1], dst, K - 1);
                if (onwardJourneyCost != -1) {
                    minCost = Math.min(minCost, flight[2] + onwardJourneyCost);
                }
            }
        }
        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public static void main(String[] args) {
        System.out.println(new CheapestFlightsWithinKStops().findCheapestPrice(
                3,
                new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}},
                0,
                2,
                0
        ));
    }
}
