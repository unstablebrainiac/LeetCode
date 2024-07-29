package contests.biweekly.biweeklycontest31;

import java.util.Arrays;

/*
 * https://leetcode.com/contest/biweekly-contest-31/problems/number-of-sub-arrays-with-odd-sum/
 */
public class NumberOfSubArraysWithOddSum {
    public int numOfSubarrays(int[] arr) {
        long numEven = Arrays.stream(arr)
                .filter(value -> value % 2 == 0)
                .count();
        long numOdd = arr.length - numEven;
        return (int) ((Math.pow(2, numEven) * oddCombinations(numOdd)) % (Math.pow(10, 9) + 7));
    }

    private long oddCombinations(long num) {
        long product = num;
        long sum = num;
        for (int i = 3; i <= num; i += 2) {
            product *= (num - i - 1) * (num - i - 2);
            product /= (i * (i - 1));
            sum += product;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubArraysWithOddSum().numOfSubarrays(
                new int[]{1, 2, 3, 4, 5, 6, 7}
        ));
    }
}
