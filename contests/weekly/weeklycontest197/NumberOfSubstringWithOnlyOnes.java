package contests.weekly.weeklycontest197;

import java.util.Arrays;
import java.util.regex.Pattern;

/*
 * https://leetcode.com/contest/weekly-contest-197/problems/number-of-substrings-with-only-1s/
 */
public class NumberOfSubstringWithOnlyOnes {
    public int numSub(String s) {
        Pattern pattern = Pattern.compile("0+");
        String[] split = pattern.split(s);
        long count = Arrays.stream(split)
                .filter(s1 -> !s1.isEmpty())
                .mapToLong(String::length)
                .map(operand -> operand * (operand + 1) / 2)
                .sum();
        return (int) (count % (int) (Math.pow(10, 9) + 7));
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSubstringWithOnlyOnes().numSub("110111")); // 9
    }
}
