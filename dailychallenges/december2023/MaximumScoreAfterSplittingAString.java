package dailychallenges.december2023;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class MaximumScoreAfterSplittingAString {
    public int maxScore(String s) {
        int[] zeroes = new int[s.length()];
        int[] ones = new int[s.length()];
        int zeroCount = 0, oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zeroes[i] = zeroCount++;
                ones[i] = oneCount;
            } else {
                zeroes[i] = zeroCount;
                ones[i] = oneCount++;
            }
        }
        int finalOneCount = oneCount;
        return IntStream.range(1, s.length())
                .map(i -> zeroes[i] - ones[i] + finalOneCount)
                .max()
                .orElseThrow();
    }

    public static void main(String[] args) {
        System.out.println(new MaximumScoreAfterSplittingAString().maxScore("011101")); // 5
    }
}
