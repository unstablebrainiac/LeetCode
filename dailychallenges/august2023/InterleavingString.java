package dailychallenges.august2023;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * https://leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return isInterleave(s1, s2, s3, 0, 0, new HashMap<>());
    }

    private boolean isInterleave(String s1, String s2, String s3, int index1, int index2, Map<IntegerPair, Boolean> dp) {
        IntegerPair key = IntegerPair.of(index1, index2);
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        if (index1 == s1.length() && index2 == s2.length()) {
            return true;
        }
        if (index1 == s1.length()) {
            return s3.substring(index1 + index2).equals(s2.substring(index2));
        }
        if (index2 == s2.length()) {
            return s3.substring(index1 + index2).equals(s1.substring(index1));
        }
        char c1 = s1.charAt(index1);
        char c2 = s2.charAt(index2);
        char c3 = s3.charAt(index1 + index2);
        if (c3 == c1 && c3 == c2) {
            boolean ans = isInterleave(s1, s2, s3, index1 + 1, index2, dp) || isInterleave(s1, s2, s3, index1, index2 + 1, dp);
            dp.put(key, ans);
            return ans;
        }
        if (c3 == c1) {
            boolean ans = isInterleave(s1, s2, s3, index1 + 1, index2, dp);
            dp.put(key, ans);
            return ans;
        }
        if (c3 == c2) {
            boolean ans = isInterleave(s1, s2, s3, index1, index2 + 1, dp);
            dp.put(key, ans);
            return ans;
        }
        return false;
    }

    static class IntegerPair {
        int one;
        int two;

        public IntegerPair(int one, int two) {
            this.one = one;
            this.two = two;
        }

        public static IntegerPair of(int one, int two) {
            return new IntegerPair(one, two);
        }

        @Override
        public boolean equals(Object obj) {
            return one == ((IntegerPair) obj).one && two == ((IntegerPair) obj).two;
        }

        @Override
        public int hashCode() {
            return Objects.hash(one, two);
        }
    }

    public static void main(String[] args) {
        System.out.println(new InterleavingString().isInterleave(
                "aabcc",
                "dbbca",
                "aadbbcbcac"
        )); // true
    }
}
