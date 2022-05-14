import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

/*
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        String[] characterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return digits.chars()
                .map(charValue -> charValue - 48)
                .mapToObj(digit -> characterMap[digit])
                .map(s ->
                        s.chars()
                                .mapToObj(charValue -> (char) charValue)
                                .map(Object::toString)
                                .collect(toList())
                )
                .reduce(this::cartesianProduct)
                .orElse(Collections.emptyList());
    }

    private List<String> cartesianProduct(List<String> list1, List<String> list2) {
        return list1.stream().flatMap(s1 -> list2.stream().map(s2 -> s1 + s2)).collect(toList());
    }

    public static void main(String[] args) {
        System.out.println(new LetterCombinationsOfAPhoneNumber().letterCombinations("23"));
        // [ad, ae, af, bd, be, bf, cd, ce, cf]
    }
}
