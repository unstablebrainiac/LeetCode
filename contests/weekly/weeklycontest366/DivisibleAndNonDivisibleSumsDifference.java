package contests.weekly.weeklycontest366;

/*
 * https://leetcode.com/problems/divisible-and-non-divisible-sums-difference/
 */
public class DivisibleAndNonDivisibleSumsDifference {
    public int differenceOfSums(int n, int m) {
        int num1 = 0, num2 = 0;

        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                num1 += i;
            } else {
                num2 += i;
            }
        }

        return num1 - num2;
    }

    public static void main(String[] args) {
        System.out.println(new DivisibleAndNonDivisibleSumsDifference().differenceOfSums(10, 3)); // 19
    }
}
