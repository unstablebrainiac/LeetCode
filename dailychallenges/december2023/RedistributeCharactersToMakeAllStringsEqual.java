package dailychallenges.december2023;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/
 */
public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        return Arrays.stream(words)
                .flatMapToInt(String::chars)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .allMatch(count -> count % words.length == 0);
    }

    public static void main(String[] args) {
        System.out.println(new RedistributeCharactersToMakeAllStringsEqual().makeEqual(new String[]{"abc", "aabc", "bc"})); // true
    }
}
