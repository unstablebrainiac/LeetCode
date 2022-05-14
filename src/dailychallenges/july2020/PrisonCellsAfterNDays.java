package dailychallenges.july2020;

import java.util.*;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int N) {
        List<Integer> sequence = new LinkedList<>();
        Set<Integer> sequenceSet = new HashSet<>();
        int[] next;
        boolean cycleFound = false;
        for (int i = 0; i < N; N--) {
            next = new int[cells.length];
            Integer integer = binaryToInt(cells);
            sequence.add(integer);
            if (sequenceSet.contains(integer) && !cycleFound) {
                cycleFound = true;
                int index = sequence.indexOf(integer);
                int cycleLength = sequence.size() - index - 1;
                N = (N - 1) % cycleLength + 1;
            }
            for (int j = 1; j < cells.length - 1; j++) {
                next[j] = cells[j - 1] == cells[j + 1] ? 1 : 0;
            }
            sequenceSet.add(integer);
            cells = Arrays.copyOf(next, next.length);
        }
        return cells;
    }

    private Integer binaryToInt(int[] cells) {
        return IntStream.range(0, cells.length)
                .map(operand -> (int) (cells[operand] * Math.pow(2, operand)))
                .sum();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PrisonCellsAfterNDays().prisonAfterNDays(
                new int[]{1, 0, 0, 0, 1, 0, 0, 1},
                99
        )));
    }
}
