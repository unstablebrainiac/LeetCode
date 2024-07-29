package companies.snowflake;

import java.math.BigInteger;

public class StringTransformation {
    public int numberOfWays(String s, String t, long k) {
        int[] z = zFunction(s, t);

        int moves = 0;
        for (int i = s.length() + 1; i < s.length() * 2; i++) {
            if (z[i] >= s.length()) {
                moves++;
            }
        }

        if (moves == 0 && z[s.length()] < s.length()) {
            return 0;
        }

        BigInteger mod = BigInteger.valueOf((long) (1e9 + 7));
        BigInteger a = BigInteger.valueOf(s.length() - 1)
                .modPow(BigInteger.valueOf(k), mod)
                .add(BigInteger.valueOf(k % 2 == 0 ? s.length() - 1 : 1 - s.length()))
                .multiply(BigInteger.valueOf(s.length()).modInverse(mod))
                .mod(mod);

        BigInteger b = a.add(BigInteger.valueOf(k % 2 == 0 ? -1 : 1));

        BigInteger total = z[s.length()] >= s.length() ? a : BigInteger.ZERO;
        total = total.add(b.multiply(BigInteger.valueOf(moves)));

        return total.mod(mod).intValue();
    }

    private int[] zFunction(String s, String t) {
        int len = s.length();

        s = t + s + s;

        int[] z = new int[len * 3];

        int left = 0;
        int right = 0;
        for (int i = 1; i < len * 2; i++) {
            if (i < right) {
                z[i] = Math.min(right - i, z[i - left]);
            }
            while (i + z[i] < s.length() && s.charAt(i + z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
            if (i + z[i] > right) {
                left = i;
                right = i + z[i];
            }
        }

        return z;
    }

    public static void main(String[] args) {
        System.out.println(new StringTransformation().numberOfWays("abcd", "cdab", 2)); // 2
    }
}
