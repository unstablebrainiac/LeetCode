import java.util.Arrays;

/*
 * https://leetcode.com/problems/find-greatest-common-divisor-of-array/
 */
public class FindGreatestCommonDivisorOfArray {
    public int findGCD(int[] nums) {
        int max = Arrays.stream(nums).max().orElse(0);
        int min = Arrays.stream(nums).min().orElse(0);

        return findGCD(max, min);
    }

    private int findGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGCD(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new FindGreatestCommonDivisorOfArray().findGCD(
                new int[]{2, 5, 6, 9, 10}
        )); // 2
    }
}
