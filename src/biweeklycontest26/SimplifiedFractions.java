package biweeklycontest26;

import java.util.ArrayList;
import java.util.List;

/*
 * https://leetcode.com/contest/biweekly-contest-26/problems/simplified-fractions/
 */
public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> list = new ArrayList<>();
        for (int denominator = 2 ; denominator <= n ; denominator++) {
            for (int numerator = 1 ; numerator <= denominator - 1 ; numerator++) {
                if (!coprime(numerator, denominator)) {
                    continue;
                }
                list.add(numerator + "/" + denominator);
            }
        }
        return list;
    }

    private boolean coprime(int numerator, int denominator) {
        for (int i = 2; i <= numerator; i++) {
            if (numerator % i == 0 && denominator % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new SimplifiedFractions().simplifiedFractions(6)); // [1/2, 1/3, 2/3, 1/4, 3/4, 1/5, 2/5, 3/5, 4/5, 1/6, 5/6]
    }
}