package dailychallenges.june2020;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3350/
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length >> 1; i++) {
            char temp = s[i];
            s[i] = s[s.length - i - 1];
            s[s.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        new ReverseString().reverseString(new char[]{'h', 'e', 'l', 'l', 'o'}); // 'o','l','l','e','h'
    }
}
