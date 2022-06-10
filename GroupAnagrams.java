import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/group-anagrams/
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                    char[] chars = s.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values());
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagrams().groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}
        )); // [[eat, tea, ate], [bat], [tan, nat]]
    }
}
