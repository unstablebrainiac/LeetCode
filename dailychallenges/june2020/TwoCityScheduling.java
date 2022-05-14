package dailychallenges.june2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
 */
public class TwoCityScheduling {
    public int twoCitySchedCost(int[][] costs) {
        return Arrays.stream(costs)
                .mapToInt(value -> value[0])
                .sum() +
                Arrays.stream(costs)
                        .mapToInt(value -> value[1] - value[0])
                        .sorted()
                        .limit(costs.length >> 1)
                        .sum();
    }

    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling().twoCitySchedCost(
                new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}
        )); // 110
    }
}
