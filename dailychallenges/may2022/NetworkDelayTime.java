package dailychallenges.may2022;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/network-delay-time/
 */
public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[k] = 0;

        Map<Integer, List<int[]>> timesByNode = Arrays.stream(times)
                .collect(Collectors.groupingBy(time -> time[0]));

        populateNetworkDelayTime(timesByNode, k, dp);
        if (Arrays.stream(dp).anyMatch(value -> value == -1)) {
            return -1;
        }
        return Arrays.stream(dp).max().orElse(-1);
    }

    private void populateNetworkDelayTime(Map<Integer, List<int[]>> timesByNode, int k, int[] dp) {
        if (dp[k] == -1) {
            throw new IllegalStateException();
        }
        Optional.ofNullable(timesByNode.get(k))
                .orElse(Collections.emptyList())
                .forEach(time -> {
                    if (dp[time[1]] == -1 || dp[k] + time[2] < dp[time[1]]) {
                        dp[time[1]] = dp[k] + time[2];
                        populateNetworkDelayTime(timesByNode, time[1], dp);
                    }
                });
    }

    public static void main(String[] args) {
        System.out.println(new NetworkDelayTime().networkDelayTime(
                new int[][]{
                        new int[]{2, 1, 1},
                        new int[]{2, 3, 1},
                        new int[]{3, 4, 1}
                },
                4,
                2
        )); // 2
    }
}
