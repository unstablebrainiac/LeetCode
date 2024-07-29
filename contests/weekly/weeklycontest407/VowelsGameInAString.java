package contests.weekly.weeklycontest407;

import java.util.Set;

/*
 * https://leetcode.com/problems/vowels-game-in-a-string/
 */
public class VowelsGameInAString {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        return s.chars().mapToObj(c -> (char) c).anyMatch(vowels::contains);
    }

    public static void main(String[] args) {
        System.out.println(new VowelsGameInAString().doesAliceWin("leetcoder")); // true
    }
}
