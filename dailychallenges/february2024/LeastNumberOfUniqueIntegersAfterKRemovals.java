package dailychallenges.february2024;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/
 */
public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Long> frequencyMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int count = frequencyMap.size();

        List<Integer> frequencies = frequencyMap.values()
                .stream()
                .map(Math::toIntExact)
                .sorted()
                .collect(Collectors.toList());

        for (int frequency : frequencies) {
            if (k - frequency < 0) {
                break;
            }
            k -= frequency;
            count--;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new LeastNumberOfUniqueIntegersAfterKRemovals().findLeastNumOfUniqueInts(
                new int[]{4, 3, 1, 1, 3, 3, 2}, 3
        )); // 2
    }
}
