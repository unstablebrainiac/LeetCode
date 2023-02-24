package dailychallenges.february2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * https://leetcode.com/problems/minimize-deviation-in-array/
 */
public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Arrays.stream(nums)
                .map(num -> num % 2 == 0 ? num : 2 * num)
                .forEach(pq::offer);
        int min = pq.stream().min(Integer::compareTo).orElse(0);
        int range = Integer.MAX_VALUE;
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            range = Math.min(range, current - min);
            if (current % 2 == 1) {
                break;
            }
            current /= 2;
            min = Math.min(min, current);
            pq.offer(current);
        }
        return range;
    }

    public static void main(String[] args) {
        System.out.println(new MinimizeDeviationInArray().minimumDeviation(
                new int[]{4, 1, 5, 20, 3}
        )); // 3
    }
}
