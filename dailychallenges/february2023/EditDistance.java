package dailychallenges.february2023;

/*
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        return minDistance(word1, word2, 0, 0, new Integer[word1.length()][word2.length()]);
    }

    private int minDistance(String word1, String word2, int index1, int index2, Integer[][] dp) {
        if (index1 == word1.length()) {
            return word2.length() - index2;
        }
        if (index2 == word2.length()) {
            return word1.length() - index1;
        }
        if (dp[index1][index2] != null) {
            return dp[index1][index2];
        }
        if (word1.charAt(index1) == word2.charAt(index2)) {
            int ans = minDistance(word1, word2, index1 + 1, index2 + 1, dp);
            dp[index1][index2] = ans;
            return ans;
        }

        int option1 = minDistance(word1, word2, index1 + 1, index2, dp);
        int option2 = minDistance(word1, word2, index1, index2 + 1, dp);
        int option3 = minDistance(word1, word2, index1 + 1, index2 + 1, dp);
        int ans = Math.min(option1, Math.min(option2, option3)) + 1;
        dp[index1][index2] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new EditDistance().minDistance(
                "horse",
                "ros"
        )); // 3
    }
}
