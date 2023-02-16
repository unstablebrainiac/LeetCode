import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        List<Integer> differingIndices = IntStream.range(0, s1.length())
                .filter(index -> s1.charAt(index) != s2.charAt(index))
                .boxed()
                .collect(Collectors.toList());

        if (differingIndices.size() > 2 || differingIndices.size() == 1) {
            return false;
        }
        if (differingIndices.size() == 0) {
            return true;
        }
        return s1.charAt(differingIndices.get(0)) == s2.charAt(differingIndices.get(1))
                && s1.charAt(differingIndices.get(1)) == s2.charAt(differingIndices.get(0));
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfOneStringSwapCanMakeStringsEqual().areAlmostEqual(
                "bank",
                "kanb"
        )); // true
    }
}
