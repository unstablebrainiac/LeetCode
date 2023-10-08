package weeklycontest366;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://leetcode.com/problems/minimum-processing-time/
 */
public class MinimumProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        tasks.sort(Comparator.comparingInt(a -> a));
        processorTime.sort(Comparator.comparingInt(a -> (int) a).reversed());

        int max = 0;
        int j = 0;
        for (int i = 0; i < tasks.size(); i++) {
            if (i % 4 == 3) {
                max = Math.max(max, tasks.get(i) + processorTime.get(j++));
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumProcessingTime().minProcessingTime(
                Arrays.asList(8, 10),
                Arrays.asList(2, 2, 3, 1, 8, 7, 4, 5)
        )); // 16
    }
}
