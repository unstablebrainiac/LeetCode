package dailychallenges.august2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/551/week-3-august-15th-august-21st/3428/
 */
public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> current = IntStream.range(0, 10).boxed().collect(Collectors.toList());
        for (int i = 2; i <= N; i++) {
            List<Integer> newList = new ArrayList<>();
            for (int x : current) {
                int y = x % 10;
                if (x > 0 && y + K < 10)
                    newList.add(x * 10 + y + K);
                if (x > 0 && K > 0 && y - K >= 0)
                    newList.add(x * 10 + y - K);
            }
            current = newList;
        }
        return current.stream().mapToInt(j -> j).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NumbersWithSameConsecutiveDifferences().numsSameConsecDiff(3, 7)));
    }
}
