package dailychallenges.june2020;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        Map<Integer, Integer> numTreesByNum = new HashMap<>();
        numTreesByNum.put(0, 1);
        return numTrees(n, numTreesByNum);
    }

    private int numTrees(int n, Map<Integer, Integer> numTreesByNum) {
        if (numTreesByNum.containsKey(n)) {
            return numTreesByNum.get(n);
        }
        int count = IntStream.range(0, n)
                .map(i -> numTrees(i, numTreesByNum) * numTrees(n - i - 1, numTreesByNum))
                .sum();
        numTreesByNum.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueBinarySearchTrees().numTrees(3)); // 5
    }
}
