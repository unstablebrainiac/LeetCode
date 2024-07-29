package companies.snowflake;

public class StringPatterns {
    public int numPatterns(int wordLen, int maxVowels) {
        if (maxVowels == 0) {
            return (int) Math.pow(21, wordLen);
        }
        return numPatterns(wordLen, maxVowels, new Integer[wordLen + 1][maxVowels + 1]);
    }

    private int numPatterns(int wordLen, int maxVowels, Integer[][] dp) {
        if (wordLen == 0) {
            return 1;
        }
        if (dp[wordLen][maxVowels] != null) {
            return dp[wordLen][maxVowels];
        }

        int count = 0;
        for (int i = 0; i <= maxVowels && i < wordLen; i++) {
            count += (int) (Math.pow(5, i) * 21 * numPatterns(wordLen - i - 1, maxVowels, dp));
        }

        if (wordLen <= maxVowels) {
            count += (int) (Math.pow(5, wordLen));
        }

        dp[wordLen][maxVowels] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new StringPatterns().numPatterns(2, 2)); // 676
    }
}
