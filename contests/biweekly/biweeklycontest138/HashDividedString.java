package contests.biweekly.biweeklycontest138;

/*
 * https://leetcode.com/problems/hash-divided-string/
 */
public class HashDividedString {

    public String stringHash(String s, int k) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length() / k; i++) {
            int sum = 0;
            for (int j = 0; j < k; j++) {
                sum += s.charAt(i * k + j) - 'a';
            }
            result.append((char) ('a' + sum % 26));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new HashDividedString().stringHash("abcd", 2)); // bf
    }
}
