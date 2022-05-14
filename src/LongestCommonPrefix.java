import java.util.Arrays;
import java.util.Optional;

/*
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Optional<Integer> maybeMinLength = Arrays.stream(strs).map(String::length).min(Integer::compareTo);
        int minLength = maybeMinLength.orElse(0);
        if (minLength == 0) {
            return "";
        }
        int flag = minLength;
        for (int i = 1; i <= minLength; i++) {
            String prefix = strs[0].substring(0, i);
            if (!Arrays.stream(strs).allMatch(s -> s.startsWith(prefix))) {
                flag = i - 1;
                System.out.println(flag);
                break;
            }
        }
        return strs[0].substring(0, flag);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(
                new String[]{"flower", "flow", "flight"}
        )); // "fl"
    }
}
