package biweeklycontest32;

/*
 * https://leetcode.com/contest/biweekly-contest-32/problems/kth-missing-positive-number/
 */
public class KthMissingPositiveNumber {
    public int findKthPositive(int[] arr, int k) {
        int count = 0;
        int current = 1;
        for (int i : arr) {
            if (i == current) {
                current++;
            } else {
                count += i - current;
                current = i + 1;
            }
            if (count >= k) {
                return current - count + k - 2;
            }
        }
        return current + k - count - 1;
    }

    public static void main(String[] args) {
        System.out.println(new KthMissingPositiveNumber().findKthPositive(
                new int[]{2, 3, 4, 7, 11},
                5
        )); // 9
    }
}
