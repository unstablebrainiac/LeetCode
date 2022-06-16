package dailychallenges.june2022;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/delete-operation-for-two-strings/
 */
public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, new Integer[word1.length() + 1][word2.length() + 1]);
    }

    private int minDistance(String word1, String word2, int index1, int index2, Integer[][] dp) {
        if (dp[index1][index2] != null) {
            return dp[index1][index2];
        }
        if (index1 == word1.length() || index2 == word2.length()) {
            int ans = word1.length() + word2.length() - index1 - index2;
            dp[index1][index2] = ans;
            return ans;
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            int ans = minDistance(word1, word2, index1 + 1, index2 + 1, dp);
            dp[index1][index2] = ans;
            return ans;
        }
        int ans = 1 + Math.min(
                minDistance(word1, word2, index1 + 1, index2, dp),
                minDistance(word1, word2, index1, index2 + 1, dp)
        );
        dp[index1][index2] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteOperationForTwoStrings().minDistance(
                "sajalnarang",
                "jaltarang"
        )); // 4
    }
}
