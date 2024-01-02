package dailychallenges.january2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/
 */
public class ConvertAnArrayIntoA2DArrayWithConditions {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Long> frequency = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < frequency.values().stream().mapToLong(l -> l).max().orElseThrow(); i++) {
            ans.add(new ArrayList<>());
        }

        for (Map.Entry<Integer, Long> entry : frequency.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                ans.get(i).add(entry.getKey());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new ConvertAnArrayIntoA2DArrayWithConditions().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1})); // [[1, 2, 3, 4], [1, 3], [1]]
    }
}
