package weeklycontest300;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/decode-the-message/
 */
public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> characterMap = new HashMap<>();
        char current = 'a';
        for (char c : key.toCharArray()) {
            if (!Character.isLetter(c) || Character.isUpperCase(c)) {
                continue;
            }
            if (characterMap.containsKey(c)) {
                continue;
            }
            characterMap.put(c, current++);
        }
        characterMap.put(' ', ' ');
        StringBuilder ans = new StringBuilder();
        for (char c : message.toCharArray()) {
            ans.append(characterMap.get(c));
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeTheMessage().decodeMessage(
                "the quick brown fox jumps over the lazy dog",
                "vkbs bs t suepuv"
        ));
    }
}
