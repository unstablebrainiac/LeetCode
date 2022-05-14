import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/problems/regular-expression-matching/
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }

        List<String> groups = splitIntoGroups(p);

        return isMatch(s, groups);
    }

    private List<String> splitIntoGroups(String p) {
        List<String> groups = new ArrayList<>();
        int startIndex = 0;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {
                String group1 = p.substring(startIndex, i - 1);
                String group2 = p.substring(i - 1, i + 1);
                startIndex = i + 1;
                groups.add(group1);
                groups.add(group2);
            } else if (c == '.') {
                String group1 = p.substring(startIndex, i);
                groups.add(group1);
                if (i != p.length() - 1 && p.charAt(i + 1) == '*') {
                    String group2 = p.substring(i, i + 2);
                    groups.add(group2);
                    startIndex = i + 2;
                    i++;
                } else {
                    String group2 = p.substring(i, i + 1);
                    groups.add(group2);
                    startIndex = i + 1;
                }
            }
        }
        if (startIndex != p.length()) {
            String group = p.substring(startIndex);
            groups.add(group);
        }
        return groups;
    }

    private boolean isMatch(String s, List<String> groups) {
        List<String> filteredGroups = groups.stream().filter(s1 -> !s1.isEmpty()).collect(Collectors.toList());
        int[] flags = new int[filteredGroups.size()];
        return isMatch(s, filteredGroups, flags, 0);
    }

    private boolean isMatch(String s, List<String> groups, int[] flags, int currentFlagIndex) {
        if (currentFlagIndex == groups.size() - 1) {
            return groupMatch(s.substring(flags[currentFlagIndex]), groups.get(currentFlagIndex));
        }
        if (flags[flags.length - 1] == s.length() + 1) {
            return false;
        }
        int minIndex = flags[currentFlagIndex];
        int maxIndex = flags[currentFlagIndex + 1];
        String currentString = s.substring(minIndex, maxIndex);
        if (groupMatch(currentString, groups.get(currentFlagIndex))) {
            if (isMatch(s, groups, flags, currentFlagIndex + 1)) {
                return true;
            } else {
                return isMatch(s, groups, incrementAllFlagsAfterIndex(flags, currentFlagIndex + 1), currentFlagIndex);
            }
        } else {
            return isMatch(s, groups, incrementAllFlagsAfterIndex(flags, currentFlagIndex + 1), currentFlagIndex);
        }
    }

    private boolean groupMatch(String s, String p) {
        if (p.equals(".*")) {
            return true;
        } else if (p.equals(".")) {
            return s.length() == 1;
        } else if (p.endsWith("*")) {
            char starChar = p.charAt(0);
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (starChar != c) {
                    return false;
                }
            }
            return true;
        } else {
            return p.equals(s);
        }
    }

    private int[] incrementAllFlagsAfterIndex(int[] flags, int index) {
        int[] clone = flags.clone();
        for (int i = index; i < clone.length; i++) {
            clone[i]++;
        }
        return clone;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatching().isMatch("mississippi", "mis*is*.p*.")); // true
    }
}
