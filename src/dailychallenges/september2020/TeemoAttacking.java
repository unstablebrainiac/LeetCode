package dailychallenges.september2020;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/september-leetcoding-challenge/557/week-4-september-22nd-september-28th/3473/
 */
public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        return timeSeries.length == 0
                ? 0
                : IntStream.range(0, timeSeries.length - 1)
                    .map(index -> timeSeries[index + 1] - timeSeries[index])
                    .map(time -> Math.min(time, duration))
                    .sum() + duration;
    }

    public static void main(String[] args) {
        System.out.println(new TeemoAttacking().findPoisonedDuration(
                new int[]{1, 2},
                2
        )); // 3
    }
}
