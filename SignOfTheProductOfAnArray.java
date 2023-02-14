import java.util.Arrays;

/*
 * https://leetcode.com/problems/sign-of-the-product-of-an-array/
 */
public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        return Arrays.stream(nums).anyMatch(value -> value == 0)
                ? 0
                : (int) (1 - 2 * (Arrays.stream(nums).filter(value -> value < 0).count() % 2));
    }

    public static void main(String[] args) {
        System.out.println(new SignOfTheProductOfAnArray().arraySign(
                new int[]{-1, -2, -3, -4, 3, 2, 1}
        )); // 1
    }
}
