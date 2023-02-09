package dailychallenges.february2023;

import java.util.*;

/*
 * https://leetcode.com/problems/naming-a-company/
 */
public class NamingACompany {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> ideaMap = new HashMap<>();
        Arrays.stream(ideas).forEach(idea -> ideaMap.computeIfAbsent(idea.charAt(0), value -> new HashSet<>()).add(idea.substring(1)));

        long ans = 0;
        for (Map.Entry<Character, Set<String>> idea1 : ideaMap.entrySet()) {
            for (Map.Entry<Character, Set<String>> idea2 : ideaMap.entrySet()) {
                if (idea1.getKey() == idea2.getKey()) {
                    continue;
                }
                long ans1 = idea1.getValue().stream().filter(value -> !idea2.getValue().contains(value)).count();
                long ans2 = idea2.getValue().stream().filter(value -> !idea1.getValue().contains(value)).count();
                ans += ans1 * ans2;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new NamingACompany().distinctNames(
                new String[]{
                        "coffee",
                        "donuts",
                        "time",
                        "toffee"
                }
        )); // 6
    }
}
