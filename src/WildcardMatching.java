import java.util.Arrays;

/*
 * https://leetcode.com/problems/wildcard-matching/
 */
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        Boolean[][] match = new Boolean[s.length() + 1][p.length() + 1];
        return checkMatch(s, p, match);
    }

    private boolean checkMatch(String s, String p, Boolean[][] match) {
        if (p.isEmpty()) {
            match[s.length()][p.length()] = s.isEmpty();
            return s.isEmpty();
        }
        p = p.replaceAll("\\*\\*", "\\*");
        if (p.equals("*")) {
            match[s.length()][p.length()] = true;
            return true;
        }
        if (s.isEmpty()) {
            match[s.length()][p.length()] = false;
            return false;
        }

        if (match[s.length()][p.length()] != null) {
            return match[s.length()][p.length()];
        }
        int starCount = (int) p.chars().filter(value -> value == 42).count();
        if (s.length() < p.length() - starCount) {
            return false;
        }
        char firstPCharacter = p.charAt(0);
        char firstSCharacter = s.charAt(0);

        switch (firstPCharacter) {
            case '?':
                boolean b = checkMatch(s.substring(1), p.substring(1), match);
                match[s.length()][p.length()] = b;
                return b;
            case '*':
                boolean b2 = checkMatch(s.substring(1), p, match) || checkMatch(s, p.substring(1), match);
                match[s.length()][p.length()] = b2;
                return b2;
            default:
                boolean b1 = firstPCharacter == firstSCharacter && checkMatch(s.substring(1), p.substring(1), match);
                match[s.length()][p.length()] = b1;
                return b1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("babbbbaabababaabbababaababaabbaabababbaaababbababaaaaaabbabaaaabababbabbababbbaaaababbbabbbbbbbbbbaabbb", "b**bb**a**bba*b**a*bbb**aba***babbb*aa****aabb*bbb***a")); // true
//        System.out.println(new WildcardMatching().isMatch("abcdefghij", "a*??hi*j")); // true
    }
}
