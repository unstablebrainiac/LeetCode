package dailychallenges.january2024;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        return longestCommonSubsequence(text1, text2, 0, 0, new Integer[text1.length()][text2.length()]);
    }

    private int longestCommonSubsequence(String text1, String text2, int index1, int index2, Integer[][] dp) {
        if (index1 == text1.length() || index2 == text2.length()) {
            return 0;
        }

        if (dp[index1][index2] != null) {
            return dp[index1][index2];
        }

        if (text1.charAt(index1) == text2.charAt(index2)) {
            int ans = 1 + longestCommonSubsequence(text1, text2, index1 + 1, index2 + 1, dp);
            dp[index1][index2] = ans;
            return ans;
        }

        int ans = Math.max(
                longestCommonSubsequence(text1, text2, index1 + 1, index2, dp),
                longestCommonSubsequence(text1, text2, index1, index2 + 1, dp)
        );
        dp[index1][index2] = ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace")); // 3
    }
}
