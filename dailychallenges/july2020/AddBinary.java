package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3395/
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        return addBinary(a, b, 0);
    }

    private String addBinary(String a, String b, int carry) {
        if (a.isEmpty()) {
            if (carry == 0) {
                return b;
            } else {
                return addBinary("1", b, 0);
            }
        }
        if (b.isEmpty()) {
            if (carry == 0) {
                return a;
            } else {
                return addBinary(a, "1", 0);
            }
        }
        int lastDigitA = a.charAt(a.length() - 1) - '0';
        int lastDigitB = b.charAt(b.length() - 1) - '0';
        int result = lastDigitA + lastDigitB + carry;
        return addBinary(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1), result / 2) + (result % 2);
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1010", "1011")); // 10101
    }
}
