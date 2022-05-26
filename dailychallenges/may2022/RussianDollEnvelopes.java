package dailychallenges.may2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * https://leetcode.com/problems/russian-doll-envelopes/
 * Does not pass
 */
public class RussianDollEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        return maxEnvelopes(envelopes, 10000, 10000, new HashMap<>()) - 1;
    }

    private int maxEnvelopes(int[][] envelopes, int width, int height, Map<IntegerPair, Integer> dp) {
        IntegerPair pair = IntegerPair.of(width, height);
        if (dp.containsKey(pair)) {
            return dp.get(pair);
        }
        int count = Arrays.stream(envelopes)
                .filter(size -> size[0] < width)
                .filter(size -> size[1] < height)
                .mapToInt(size -> maxEnvelopes(envelopes, size[0], size[1], dp))
                .max()
                .orElse(0) + 1;

        dp.put(pair, count);
        return count;
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
    }

    public static void main(String[] args) {
        System.out.println(new RussianDollEnvelopes().maxEnvelopes(
                new int[][]{
                        new int[]{5,4},
                        new int[]{6,4},
                        new int[]{6,7},
                        new int[]{2,3}
                }
        )); // 3
    }
}
