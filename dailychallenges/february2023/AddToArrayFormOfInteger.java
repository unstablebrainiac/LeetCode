package dailychallenges.february2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/add-to-array-form-of-integer/
 */
public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        return addToArrayForm(num, k, num.length - 1);
    }

    private List<Integer> addToArrayForm(int[] num, int k, int index) {
        if (k == 0) {
            return IntStream.range(0, index + 1)
                    .map(value -> num[value])
                    .boxed()
                    .collect(Collectors.toList());
        }
        int currentDigit = k % 10;
        if (index >= 0) {
            currentDigit += num[index];
        }
        k = k / 10 + (currentDigit > 9 ? 1 : 0);

        List<Integer> prefix = addToArrayForm(num, k, index - 1);
        prefix.add(currentDigit % 10);

        return prefix;
    }

    public static void main(String[] args) {
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(
                new int[]{2, 1, 5},
                806
        )); // [1, 0, 2, 1]
    }
}
