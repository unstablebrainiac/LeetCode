package dailychallenges.august2023;

import java.util.*;

/*
 * https://leetcode.com/problems/maximum-length-of-pair-chain/
 */
public class MaximumLengthOfPairChain {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparing(pair -> pair[0]));
        return findLongestChain(pairs, pairs[0][0] - 1, 0, new HashMap<>());
    }

    private int findLongestChain(int[][] pairs, int start, int startIndex, Map<IntegerPair, Integer> dp) {
        IntegerPair key = IntegerPair.of(start, startIndex);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (startIndex == pairs.length) {
            return 0;
        }
        Integer smallestStartIntervalEnd = null;
        int maxLength = 0;
        for (int i = startIndex; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (smallestStartIntervalEnd != null && pair[0] > smallestStartIntervalEnd) {
                break;
            }
            if (pair[0] <= start) {
                continue;
            }
            smallestStartIntervalEnd = pair[1];
            int longestChain = findLongestChain(pairs, pair[1], i + 1, dp);
            maxLength = Math.max(maxLength, longestChain);
        }
        int ans = smallestStartIntervalEnd == null ? 0 : maxLength + 1;
        dp.put(key, ans);
        return ans;
    }

    static class IntegerPair {
        int one;
        int two;

        public IntegerPair(int one, int two) {
            this.one = one;
            this.two = two;
        }

        public static IntegerPair of(int one, int two) {
            return new IntegerPair(one, two);
        }

        @Override
        public boolean equals(Object obj) {
            return one == ((IntegerPair) obj).one && two == ((IntegerPair) obj).two;
        }

        @Override
        public int hashCode() {
            return Objects.hash(one, two);
        }

        @Override
        public String toString() {
            return "[" + one + "," + two + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(
                new int[][]{
                        {1, 2},
                        {2, 3},
                        {3, 4},
                }
        )); // 2
    }
}
