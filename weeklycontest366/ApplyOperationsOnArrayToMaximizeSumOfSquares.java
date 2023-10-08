package weeklycontest366;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/
 * Does not pass
 */
public class ApplyOperationsOnArrayToMaximizeSumOfSquares {
    public int maxSum(List<Integer> nums, int k) {
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int numi = nums.get(i);
                int numj = nums.get(j);
                int num1 = numi & numj;
                int num2 = numi | numj;

                if (num1 * num1 + num2 * num2 > numi * numi + numj * numj) {
                    nums.set(i, num1);
                    nums.set(j, num2);

                    return maxSum(nums, k);
                }
            }
        }

        return (int) (sumOfSquares(nums, k) % (Math.pow(10, 9) + 7));
    }

    private long sumOfSquares(List<Integer> nums, int k) {
        return nums
                .stream()
                .sorted(Comparator.reverseOrder())
                .mapToLong(a -> a)
                .map(a -> a * a)
                .limit(k)
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(new ApplyOperationsOnArrayToMaximizeSumOfSquares().maxSum(
                Arrays.asList(2, 6, 5, 8),
                2
        )); // 261
    }
}
