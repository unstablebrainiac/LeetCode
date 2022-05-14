package dailychallenges.july2020;

import java.util.*;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/548/week-5-july-29th-july-31st/3406/
 */
public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakList(s, wordDict, new HashMap<>()).stream().map(strings -> strings.stream().reduce((s1, s2) -> s1 + " " + s2).get()).collect(Collectors.toList());
    }

    public List<List<String>> wordBreakList(String s, List<String> wordDict, Map<String, List<List<String>>> dp) {
        if (s.isEmpty()) {
            return Collections.singletonList(new LinkedList<>());
        }
        if (dp.containsKey(s)) {
            return dp.get(s).stream().map(LinkedList::new).collect(Collectors.toList());
        }
        List<List<String>> ans = wordDict.stream()
                .filter(s::startsWith)
                .map(word -> {
                    List<List<String>> lists = wordBreakList(s.substring(word.length()), wordDict, dp);
                    lists.forEach(strings -> strings.add(0, word));
                    return lists;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        List<List<String>> clone = ans.stream().map(LinkedList::new).collect(Collectors.toList());
        dp.put(s, clone);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new WordBreak2().wordBreak(
                "aaaaaaa",
                Arrays.asList("a", "aa", "aaaa")
        )); // [pine apple pen apple, pine applepen apple, pineapple pen apple]
//        System.out.println(new WordBreak2().wordBreak(
//                "pineapplepenapple",
//                Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")
//        )); // [pine apple pen apple, pine applepen apple, pineapple pen apple]
    }
}
