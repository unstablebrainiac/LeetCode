package contests.weekly.weeklycontest367;

/*
 * https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
 */
public class ShortestAndLexicographicallySmallestBeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        int start = 0, end = 0, ones = 0;
        String minString = null;
        while (start < s.length()) {
            if (ones == k) {
                minString = min(minString, s.substring(start, end));
                if (s.charAt(start) == '1') {
                    ones--;
                }
                start++;
            } else if (ones < k) {
                if (end == s.length()) {
                    break;
                }
                if (s.charAt(end) == '1') {
                    ones++;
                }
                end++;
            } else {
                if (s.charAt(start) == '1') {
                    ones--;
                }
                start++;
            }
        }
        return minString == null ? "" : minString;
    }

    private String min(String s1, String s2) {
        if (s1 == null) {
            return s2;
        }
        if (s1.length() != s2.length()) {
            return s1.length() < s2.length() ? s1 : s2;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                continue;
            }
            return s1.charAt(i) < s2.charAt(i) ? s1 : s2;
        }
        return s1;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestAndLexicographicallySmallestBeautifulString().shortestBeautifulSubstring("100011001", 3)); // 11001
    }
}
