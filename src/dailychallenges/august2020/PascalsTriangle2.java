package dailychallenges.august2020;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3421/
 */
public class PascalsTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }
        List<Integer> temp = getRow(rowIndex - 1);
        List<Integer> ans = new java.util.ArrayList<>(Collections.singletonList(1));
        ans.addAll(IntStream.range(1, rowIndex)
                .mapToObj(operand -> temp.get(operand) + temp.get(operand - 1))
                .collect(Collectors.toList()));
        ans.add(1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle2().getRow(4)); // [1, 4, 6, 4, 1]
    }
}
