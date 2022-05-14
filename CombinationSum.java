import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/combination-sum/
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (target > 0) {
            List<List<Integer>> lists =
                    IntStream.range(0, candidates.length)
                            .boxed()
                            .collect(Collectors.toMap(
                                    index -> candidates[index],
                                    index -> combinationSum(Arrays.copyOfRange(candidates, index, candidates.length), target - candidates[index])
                            ))
                            .entrySet()
                            .stream()
                            .map(integerListEntry ->
                                    integerListEntry.getValue()
                                            .stream()
                                            .peek(integers -> integers.add(0, integerListEntry.getKey()))
                                            .collect(Collectors.toList()))
                            .flatMap(Collection::stream)
                            .collect(Collectors.toList());
            if (Arrays.binarySearch(candidates, target) >= 0) {
                lists.add(new LinkedList<>(Collections.singleton(target)));
            }
            return lists;
        }
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2, 2, 3], [7]]
    }
}
