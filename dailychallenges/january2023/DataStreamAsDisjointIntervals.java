package dailychallenges.january2023;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/data-stream-as-disjoint-intervals/
 */
public class DataStreamAsDisjointIntervals {

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1]]
        summaryRanges.addNum(3);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1], [3, 3]]
        summaryRanges.addNum(7);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 3], [7, 7]]
        summaryRanges.addNum(6);
        System.out.println(Arrays.deepToString(summaryRanges.getIntervals())); // [[1, 3], [6, 7]]
    }

    private static class SummaryRanges {

        private Map<Integer, int[]> valueToIntervalMap;
        private int[][] intervals;

        public SummaryRanges() {
            valueToIntervalMap = new HashMap<>();
            intervals = new int[0][0];
        }

        public void addNum(int value) {
            if (valueToIntervalMap.get(value) != null) {
                return;
            }

            if (value == 0) {
                int[] interval = valueToIntervalMap.get(1);
                if (interval != null) {
                    interval[0] = 0;
                } else {
                    interval = new int[]{0, 0};
                }
                valueToIntervalMap.put(0, interval);
                return;
            }

            if (value == Integer.MAX_VALUE) {
                int[] interval = valueToIntervalMap.get(value - 1);
                if (interval != null) {
                    interval[1] = value;
                } else {
                    interval = new int[]{value, value};
                }
                valueToIntervalMap.put(value, interval);
                return;
            }

            int[] previousInterval = valueToIntervalMap.get(value - 1);
            int[] nextInterval = valueToIntervalMap.get(value + 1);

            if (previousInterval != null && nextInterval != null) {
                int[] interval = new int[]{previousInterval[0], nextInterval[1]};
                for (int i = previousInterval[0]; i <= nextInterval[1]; i++) {
                    valueToIntervalMap.put(i, interval);
                }
            } else if (previousInterval != null) {
                previousInterval[1] = value;
                valueToIntervalMap.put(value, previousInterval);
            } else if (nextInterval != null) {
                nextInterval[0] = value;
                valueToIntervalMap.put(value, nextInterval);
            } else {
                int[] interval = new int[]{value, value};
                valueToIntervalMap.put(value, interval);
            }
        }

        public int[][] getIntervals() {
            intervals = valueToIntervalMap
                    .values()
                    .stream()
                    .distinct()
                    .sorted(Comparator.comparingInt(ints -> ints[0]))
                    .toArray(size -> new int[size][2]);
            return intervals;
        }
    }
}
