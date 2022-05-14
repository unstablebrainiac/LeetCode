package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3392/
 */
public class PowXN {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        if (x == -1) return n % 2 == 0 ? 1 : -1;
        if (n == 0) return 1;
        int i;
        double ans;
        if (n < 0) {
            ans = 1 / x;
            for (i = -1; 2 * i < 0 && 2 * i > n; i *= 2) {
                ans *= ans;
                if (ans == 0) {
                    return 0;
                }
            }
            for (; i > n; i--) {
                ans /= x;
            }
        } else {
            ans = x;
            for (i = 1; 2 * i < n; i *= 2) {
                ans *= ans;
                if (ans == 0) {
                    return 0;
                }
            }
            for (; i < n; i++) {
                ans *= x;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PowXN().myPow(2.0, 10)); // 1024
    }
}
