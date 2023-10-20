package dailychallenges.october2023;

/*
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int i1 = s.length() - 1, i2 = t.length() - 1;
        int backspace1 = 0, backspace2 = 0;
        while (i1 >= 0 || i2 >= 0) {
            while (i1 >= 0) {
                char c1 = s.charAt(i1);
                if (c1 == '#') {
                    backspace1++;
                    i1--;
                } else if (backspace1 != 0) {
                    backspace1--;
                    i1--;
                } else {
                    break;
                }
            }
            while (i2 >= 0) {
                char c2 = t.charAt(i2);
                if (c2 == '#') {
                    backspace2++;
                    i2--;
                } else if (backspace2 != 0) {
                    backspace2--;
                    i2--;
                } else {
                    break;
                }
            }
            if (i1 < 0 && i2 < 0) {
                return true;
            } else if (i1 >= 0 && i2 >= 0) {
                if (s.charAt(i1) != t.charAt(i2)) {
                    return false;
                } else {
                    i1--;
                    i2--;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceStringCompare().backspaceCompare("bxj##tw", "bxj###tw")); // true
    }
}
