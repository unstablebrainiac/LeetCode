package dailychallenges.july2020;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3393/
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        return Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity()))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(integerListEntry -> ((Map.Entry<Integer, List<Integer>>) integerListEntry).getValue().size()).reversed())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequentElements().topKFrequent(
                new int[]{1, 1, 1, 2, 2, 3},
                2
        ))); // [1, 2]
    }
}
