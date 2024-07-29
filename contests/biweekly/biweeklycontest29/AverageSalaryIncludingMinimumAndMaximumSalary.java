package contests.biweekly.biweeklycontest29;

/*
 * https://leetcode.com/contest/biweekly-contest-29/problems/average-salary-excluding-the-minimum-and-maximum-salary/
 */
public class AverageSalaryIncludingMinimumAndMaximumSalary {
    public double average(int[] salary) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int value : salary) {
            sum += value;
            max = Math.max(max, value);
            min = Math.min(min, value);
        }
        return (double) (sum - max - min) / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(new AverageSalaryIncludingMinimumAndMaximumSalary().average(
                new int[]{8000, 9000, 2000, 3000, 6000, 1000}
        )); // 4750
    }
}
