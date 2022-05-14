import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/roman-to-integer/
 */
public class RomanToInteger {

    private Map<Character, Integer> initializeValueMap() {
        Map<Character, Integer> valueMap = new HashMap<>();
        valueMap.put('I', 1);
        valueMap.put('V', 5);
        valueMap.put('X', 10);
        valueMap.put('L', 50);
        valueMap.put('C', 100);
        valueMap.put('D', 500);
        valueMap.put('M', 1000);
        return valueMap;
    }

    public int romanToInt(String s) {
        Map<Character, Integer> valueMap = initializeValueMap();
        return romanToInt(s, valueMap);
    }

    public int romanToInt(String s, Map<Character, Integer> valueMap) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return valueMap.get(s.charAt(0));
        }
        char firstChar = s.charAt(0);
        char secondChar = s.charAt(1);

        int value1 = valueMap.get(firstChar);
        int value2 = valueMap.get(secondChar);

        if (value1 < value2) {
            return value2 - value1 + romanToInt(s.substring(2), valueMap);
        } else {
            return value1 + romanToInt(s.substring(1), valueMap);
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToInteger().romanToInt("MCMXCIV"));
    }
}
