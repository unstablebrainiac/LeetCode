/*
 * https://leetcode.com/problems/implement-strstr/
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("hello", "ll")); // 2
    }
}
