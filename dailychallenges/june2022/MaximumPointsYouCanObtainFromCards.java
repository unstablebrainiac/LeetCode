package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 */
public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int subArrayLength = cardPoints.length - k;
        int total = Arrays.stream(cardPoints).sum();
        int sum = Arrays.stream(cardPoints).limit(subArrayLength).sum();
        int minSoFar = sum;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i + subArrayLength] - cardPoints[i];
            minSoFar = Math.min(sum, minSoFar);
        }
        return total - minSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumPointsYouCanObtainFromCards().maxScore(
                new int[]{1, 2, 3, 4, 5, 6, 1},
                3
        )); // 12
    }
}
