package dailychallenges.july2022;

/*
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
    public int fib(int n) {
        return n < 2 ? n : fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(4)); // 3
    }
}
