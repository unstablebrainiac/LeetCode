package dailychallenges.may2022;

/*
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        long l = Integer.toUnsignedLong(n);
        return hammingWeight(l);
    }

    private int hammingWeight(long n) {
        if (n == 1) {
            return 1;
        }
        if (n % 2 == 0) {
            return hammingWeight(n /2);
        } else {
            return hammingWeight(n /2) + 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(11)); // 3
    }
}
