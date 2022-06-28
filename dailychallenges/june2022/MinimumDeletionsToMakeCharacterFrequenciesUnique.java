package dailychallenges.june2022;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        List<Long> frequencies = s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        int ans = 0;
        long current = Long.MAX_VALUE;
        for (Long frequency : frequencies) {
            if (current == 0) {
                ans += frequency;
            } else {
                if (frequency >= current) {
                    ans += frequency - current + 1;
                    current--;
                } else {
                    current = frequency;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique().minDeletions("ceabaacb")); // 2
    }
}
