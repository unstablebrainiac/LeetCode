import java.util.Arrays;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 1;
        int current = 1;
        int size = s.length();
        char[] arr = new char[size];
        arr[0] = s.charAt(0);

        for (int i = 1; i < size; i++) {
            char ch = s.charAt(i);
            arr[current] = ch;
            int index = index(arr, ch, current);
            if (index != -1) {
                if (max < current) {
                    max = current;
                }
                current -= index;
                arr = Arrays.copyOfRange(arr, index + 1, arr.length);
                continue;
            }
            current++;
        }
        if (max < current) {
            max = current;
        }
        return max;
    }

    private int index(char[] diff, char num, int maxIndex) {
        for (int i = 0; i < maxIndex; i++) {
            if (diff[i] == num) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(
                "abcabcbb"
        )); // 3
    }
}
