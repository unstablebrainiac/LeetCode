package dailychallenges.june2020;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/543/week-5-june-29th-june-30th/3375/
 */
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        Map<Integer, BigInteger> factorials = new HashMap<>();
        factorials.put(0, BigInteger.valueOf(1));
        return factorial(m + n - 2, factorials).divide(factorial(m - 1, factorials)).divide(factorial(n - 1, factorials)).intValue();
    }

    private BigInteger factorial(int n, Map<Integer, BigInteger> factorials) {
        if (factorials.containsKey(n)) {
            return factorials.get(n);
        }
        return factorial(n - 1, factorials).multiply(BigInteger.valueOf(n));
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(7, 3)); // 28
    }
}
