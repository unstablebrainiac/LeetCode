import java.util.Arrays;

/*
 * https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
 */
public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length < 3) {
            return true;
        }
        Arrays.sort(arr);
        int diff = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanMakeArithmeticProgressionFromSequence().canMakeArithmeticProgression(
                new int[]{3, 5, 1}
        )); // true
    }
}
