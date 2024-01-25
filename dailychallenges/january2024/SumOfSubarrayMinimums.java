package dailychallenges.january2024;

import java.util.Stack;

/*
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] leftCount = new int[arr.length];
        int[] rightCount = new int[arr.length];
        long sum = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!left.isEmpty() && arr[left.peek()] > arr[i]) {
                left.pop();
            }
            leftCount[i] = left.isEmpty() ? i + 1 : i - left.peek();
            left.push(i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!right.isEmpty() && arr[right.peek()] >= arr[i]) {
                right.pop();
            }
            rightCount[i] = right.isEmpty() ? arr.length - i : right.peek() - i;
            right.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            long product = (long) leftCount[i] * (long) rightCount[i] % 1_000_000_007;
            sum = (sum + product * arr[i]) % 1_000_000_007;
        }

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSubarrayMinimums().sumSubarrayMins(
                new int[]{3, 1, 2, 4}
        )); // 17
    }
}
