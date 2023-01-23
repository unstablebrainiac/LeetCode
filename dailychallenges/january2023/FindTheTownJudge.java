package dailychallenges.january2023;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindTheTownJudge {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) {
            return 1;
        }
        boolean[] trusting = new boolean[n + 1];
        Arrays.stream(trust).forEach(trustPair -> trusting[trustPair[0]] = true);
        Map<Integer, Integer> trustSum = Arrays.stream(trust)
                .collect(Collectors.groupingBy(trustPair -> trustPair[1], Collectors.summingInt(trustPair -> trustPair[0])));
        int totalTrust = n * (n + 1) / 2;

        return IntStream.range(1, n + 1)
                .filter(citizen -> !trusting[citizen])
                .filter(trustSum::containsKey)
                .filter(citizen -> trustSum.get(citizen) == totalTrust - citizen)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(new FindTheTownJudge().findJudge(
                3,
                new int[][]{
                        new int[]{1, 3},
                        new int[]{2, 3}
                }
        ));
    }
}
