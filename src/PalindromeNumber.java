/*
 * https://leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int numDigits = (int) Math.floor(Math.log10(x) + 1);
        for (int i = 0; i <= numDigits >> 1; i++) {
            if (!(getDigit(x, i) == getDigit(x, numDigits - i - 1))) {
                return false;
            }
        }
        return true;
    }

    private int getDigit(int x, int i) {
        return (int)(x / Math.pow(10, i)) % 10;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(121)); // true
    }
}
