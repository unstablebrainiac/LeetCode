import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
 */
public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(5);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(5, Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            maxQueue.add(num);
            minQueue.add(num);
            if (i > 3) {
                maxQueue.poll();
                minQueue.poll();
            }
        }
        int[] min = new int[4];
        int[] max = new int[4];
        for (int i = 3; i >= 0; i--) {
            min[i] = minQueue.poll();
            max[i] = maxQueue.poll();
        }
        int amplitude = max[0] - min[0];

        return amplitude - IntStream.of(
                max[0] - max[3],
                max[0] - max[2] + min[1] - min[0],
                max[0] - max[1] + min[2] - min[0],
                min[3] - min[0]
        ).max().orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves().minDifference(
                new int[]{1, 5, 0, 10, 14}
        )); // 1
    }
}
