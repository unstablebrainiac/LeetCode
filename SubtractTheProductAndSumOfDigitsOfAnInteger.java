/*
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 */
public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').reduce((a, b) -> a * b).orElse(0) - String.valueOf(n).chars().map(c -> c - '0').sum();
    }

    public static void main(String[] args) {
        System.out.println(new SubtractTheProductAndSumOfDigitsOfAnInteger().subtractProductAndSum(234)); // 15
    }
}
