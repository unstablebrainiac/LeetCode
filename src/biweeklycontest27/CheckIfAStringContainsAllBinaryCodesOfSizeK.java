package biweeklycontest27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/*
 * https://leetcode.com/contest/biweekly-contest-27/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */
public class CheckIfAStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        if (s.isEmpty()) {
            return false;
        }
        return generateAllCodes(k).allMatch(s::contains);
    }

    private Stream<String> generateAllCodes(int k) {
        if (k == 0) {
            return Stream.of("");
        }
        Stream<String> codes = StreamSupport.stream(generateAllCodes(k - 1).spliterator(), false);
        return codes
                .map(s -> Stream.of(s + "0", s + "1"))
                .flatMap(Function.identity());
    }

    public static void main(String[] args) {
        System.out.println(new CheckIfAStringContainsAllBinaryCodesOfSizeK().hasAllCodes("00110", 2)); // true
    }
}
