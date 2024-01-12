package dailychallenges.january2024;

import java.util.Set;
import java.util.stream.Stream;

/*
 * https://leetcode.com/problems/determine-if-string-halves-are-alike/
 */
public class DetermineIfStringHalvesAreAlike {
    public boolean halvesAreAlike(String s) {
        return Stream.of(s.substring(0, s.length() / 2), s.substring(s.length() / 2))
                .mapToLong(half ->
                        half.chars()
                                .mapToObj(i -> (char) i)
                                .filter(c -> Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').contains(c))
                                .count()
                )
                .distinct()
                .count() == 1;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineIfStringHalvesAreAlike().halvesAreAlike("book")); // true
    }
}
