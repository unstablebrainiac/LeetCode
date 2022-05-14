/*
 * https://leetcode.com/problems/divide-two-integers/
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE) {
            if (divisor > 0) {
                return divide(dividend + divisor, divisor) - 1;
            } else if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else {
                return divide(dividend - divisor, divisor) + 1;
            }
        }

        boolean isNegative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isNegative = true;
        }

        int positiveQuotient = positiveDivide(Math.abs(dividend), Math.abs(divisor));
        return isNegative ? -positiveQuotient : positiveQuotient;
    }

    private int positiveDivide(int dividend, int divisor) {
        return (int) Math.floor(Math.exp(Math.log(dividend) - Math.log(divisor)));
    }

    public static void main(String[] args) {
        System.out.println(new DivideTwoIntegers().divide(Integer.MIN_VALUE, -1)); // -3
        System.out.println(new DivideTwoIntegers().divide(-10, 3)); // -3
    }
}
