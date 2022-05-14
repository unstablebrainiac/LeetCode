import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (target > 0) {
            List<List<Integer>> lists =
                    IntStream.range(0, candidates.length)
                            .boxed()
                            .collect(Collectors.toMap(
                                    Function.identity(),
                                    index -> combinationSum2(Arrays.copyOfRange(candidates, index + 1, candidates.length), target - candidates[index])
                            ))
                            .entrySet()
                            .stream()
                            .map(integerListEntry ->
                                    integerListEntry.getValue()
                                            .stream()
                                            .peek(integers -> integers.add(0, candidates[integerListEntry.getKey()]))
                                            .collect(Collectors.toList()))
                            .flatMap(Collection::stream)
                            .distinct()
                            .collect(Collectors.toList());
            if (Arrays.binarySearch(candidates, target) >= 0) {
                lists.add(new LinkedList<>(Collections.singleton(target)));
            }
            return lists;
        }
        return new LinkedList<>();
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2().combinationSum2(new int[]{2, 3, 6, 7}, 7)); // [[7]]
    }
}
