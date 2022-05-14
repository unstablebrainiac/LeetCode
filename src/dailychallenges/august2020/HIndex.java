package dailychallenges.august2020;

import java.util.Arrays;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3420/
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int[] numCitations = new int[citations.length + 1];
        Arrays.stream(citations).forEach(value -> numCitations[Math.min(value, citations.length)]++);
        int sum = 0;
        for (int i = numCitations.length - 1; i >= 0; i--) {
            sum += numCitations[i];
            if (sum >= i) {
                return i;
            }
        }
        return citations.length;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(
                new int[]{3, 0, 6, 1, 5}
        )); // 3
    }
}
