package dailychallenges.august2020;

import java.util.List;
import java.util.stream.Collectors;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/550/week-2-august-8th-august-14th/3422/
 */
public class IteratorForCombination {

    public static void main(String[] args) {
        CombinationIterator iterator = new CombinationIterator("abc", 2);
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }

    static class CombinationIterator {

        public CombinationIterator(String characters, int combinationLength) {
            List<Character> combinationList = characters.chars()
                    .mapToObj(value -> (char) value)
                    .collect(Collectors.toList());
        }

        public String next() {
            return null;
        }

        public boolean hasNext() {
            return false;
        }
    }
}
