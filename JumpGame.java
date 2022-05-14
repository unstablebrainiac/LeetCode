import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/jump-game/
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        return IntStream.range(0, nums.length)
                .filter(index -> nums[index] == 0)
                .allMatch(index -> existsJump(nums, index));
    }

    private boolean existsJump(int[] nums, int index) {
        return IntStream.range(0, index)
                .map(operand -> index - operand - 1)
                .anyMatch(value -> nums[value] > index - value);
    }

    public static void main(String[] args) {
        System.out.println(new JumpGame().canJump(
                new int[]{2, 3, 1, 1, 4}
        )); // true
    }
}
