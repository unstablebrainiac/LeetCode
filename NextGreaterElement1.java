import java.util.*;

/*
 * https://leetcode.com/problems/next-greater-element-i/
 */
public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> decreasingStack = new Stack<>();
        Map<Integer, Integer> nextGreater = new HashMap<>();

        for (int num : nums2) {
            while (!decreasingStack.isEmpty() && decreasingStack.peek() < num) {
                nextGreater.put(decreasingStack.pop(), num);
            }
            decreasingStack.push(num);
        }

        return Arrays.stream(nums1)
                .map(key -> Optional.ofNullable(nextGreater.get(key)).orElse(-1))
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElement1().nextGreaterElement(
                new int[]{4, 1, 2},
                new int[]{1, 3, 4, 2}
        ))); // [-1, 3, -1]
    }
}
