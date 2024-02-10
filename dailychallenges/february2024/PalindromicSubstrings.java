package dailychallenges.february2024;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/palindromic-substrings/
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        return IntStream.range(0, s.length())
                .map(i -> countSubstrings(s, i))
                .sum();
    }

    private int countSubstrings(String s, int mid) {
        int count = 0;
        for (int i = 0; mid + i < s.length() && mid - i >= 0; i++) {
            if (s.charAt(mid + i) != s.charAt(mid - i)) {
                break;
            }
            count++;
        }
        for (int i = 0; mid + i < s.length() - 1 && mid - i >= 0; i++) {
            if (s.charAt(mid + i + 1) != s.charAt(mid - i)) {
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("aaa")); // 6
    }
}
