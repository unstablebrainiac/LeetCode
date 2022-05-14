package dailychallenges.august2020;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/explore/challenge/card/august-leetcoding-challenge/552/week-4-august-22nd-august-28th/3437/
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        return IntStream.range(0, n)
                .map(operand -> operand + 1)
                .mapToObj(this::stringValue)
                .collect(Collectors.toList());
    }

    private String stringValue(int value) {
        if (value % 3 == 0 && value % 5 == 0) {
            return "FizzBuzz";
        } else if (value % 3 == 0) {
            return "Fizz";
        } else if (value % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(value);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FizzBuzz().fizzBuzz(15)); // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
    }
}
