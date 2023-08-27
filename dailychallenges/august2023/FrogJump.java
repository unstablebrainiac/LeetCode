package dailychallenges.august2023;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/frog-jump/
 */
public class FrogJump {
    public boolean canCross(int[] stones) {
        int destination = stones[stones.length - 1];
        Set<Integer> stonePositions = Arrays.stream(stones).boxed().collect(Collectors.toSet());
        return canCross(stonePositions, 0, destination, 0, new HashMap<>());
    }

    private boolean canCross(Set<Integer> stonePositions, int position, int destination, int k, Map<IntegerPair, Boolean> dp) {
        if (position == destination) {
            return true;
        }
        if (position > destination) {
            return false;
        }
        IntegerPair key = IntegerPair.of(position, k);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        for (int jumpLength = k + 1; jumpLength >= Math.max(k - 1, 1); jumpLength--) {
            int next = position + jumpLength;
            if (stonePositions.contains(next)) {
                if (canCross(stonePositions, next, destination, jumpLength, dp)) {
                    return true;
                }
            }
        }
        dp.put(key, false);
        return false;
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
        System.out.println(new FrogJump().canCross(
                new int[]{0, 1, 3, 5, 6, 8, 12, 17}
        )); // true
    }
}
