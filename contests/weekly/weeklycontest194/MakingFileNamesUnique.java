package contests.weekly.weeklycontest194;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * https://leetcode.com/contest/weekly-contest-194/problems/making-file-names-unique/
 */
public class MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        HashSet<String> usedNames = new HashSet<>();
        Map<String, Integer> nameIndex = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            if (!usedNames.contains(names[i])) {
                usedNames.add(names[i]);
                nameIndex.put(names[i], 1);
                ans[i] = names[i];
                continue;
            }
            Integer index = nameIndex.get(names[i]);
            int suffixIndex;
            if (index != null) {
                suffixIndex = getSuffixedIndex(names[i], usedNames, index);
            } else {
                suffixIndex = getSuffixedIndex(names[i], usedNames, 1);
            }
            String suffixedName = names[i] + "(" + suffixIndex + ")";
            usedNames.add(suffixedName);
            nameIndex.put(names[i], suffixIndex + 1);
            ans[i] = suffixedName;
        }
        return ans;
    }

    private int getSuffixedIndex(String name, HashSet<String> usedNames, int startIndex) {
        for (int i = startIndex; i < usedNames.size() + 1; i++) {
            String suffixedName = name + "(" + i + ")";
            if (!usedNames.contains(suffixedName)) {
                return i;
            }
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MakingFileNamesUnique().getFolderNames(
                new String[]{"kaido", "kaido(1)", "kaido", "kaido(1)"}
        )));
    }
}
