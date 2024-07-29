package contests.biweekly.biweeklycontest29;

/*
 * https://leetcode.com/contest/biweekly-contest-29/problems/the-kth-factor-of-n/
 */
public class TheKthFactorOfN {
    public int kthFactor(int n, int k) {
        int count = 0;
        int i;
        boolean atLeastKFactors = false;
        for (i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) {
                    atLeastKFactors = true;
                    break;
                }
            }
        }
        return atLeastKFactors ? i : -1;
    }

    public static void main(String[] args) {
        System.out.println(new TheKthFactorOfN().kthFactor(1000, 3)); // 4
    }
}
