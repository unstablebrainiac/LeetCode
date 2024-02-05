package dailychallenges.february2024;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/first-unique-character-in-a-string/
 */
public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        Map<Character, Long> frequency = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (frequency.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("leetcode")); // 0
    }
}
