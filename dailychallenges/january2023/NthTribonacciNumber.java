package dailychallenges.january2023;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        return tribonacci(n, dp);
    }

    private int tribonacci(int n, int[] dp) {
        if (n == 0 || dp[n] != 0) {
            return dp[n];
        }
        int result = tribonacci(n - 1, dp) + tribonacci(n - 2, dp) + tribonacci(n - 3, dp);
        dp[n] = result;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(25)); // 1389537
    }
}
