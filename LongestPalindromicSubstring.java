/*
 * https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        String max = s.substring(0, 1);
        for (int i = 1 ; i < s.length() ; i++) {
            StringBuilder stringBuilder = new StringBuilder(s);
            String s1 = stringBuilder.insert(i, s.charAt(i)).toString();
            int halfPalindromeLength = halfPalindromeLength(s, i);
            if ((halfPalindromeLength << 1) + 1 > max.length()) {
                max = s.substring(i - halfPalindromeLength, i + halfPalindromeLength + 1);
            }
            int halfPalindromeLength1 = halfPalindromeLength(s1, i);
            if ((halfPalindromeLength1 << 1) > max.length()) {
                max = s.substring(i - halfPalindromeLength1, i + halfPalindromeLength1);
            }
        }
        return max;
    }

    private int halfPalindromeLength(String s, int index) {
        int i = 1;
        while (i != index + 1 && i + index != s.length()) {
            if (s.charAt(index - i) != s.charAt(index + i)) {
                return i - 1;
            }
            i++;
        }
        return i - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad")); // bab
    }
}
