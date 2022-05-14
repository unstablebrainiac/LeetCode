package dailychallenges.june2020;

import java.util.*;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3352/
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            int compare = Integer.compare(o1[0], o2[0]);
            if (compare == 0) {
                return Integer.compare(o2[1], o1[1]);
            }
            return compare;
        });

        int[][] ans = new int[people.length][2];
        boolean[] indices = new boolean[people.length];
        for (int i = 0; i < people.length; i++) {
            int index = people[i][1];
            for (int j = 0; j <= index; j++) {
                if (indices[j]) {
                    index++;
                }
            }
            ans[index] = people[i];
            indices[index] = true;
        }
        return ans;
    }

    public static void main(String[] args) {
        Arrays.stream(new QueueReconstructionByHeight().reconstructQueue(
                new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}}
        )).forEach(person -> System.out.print(Arrays.toString(person))); // [5, 0][7, 0][5, 2][6, 1][4, 4][7, 1]
    }
}
