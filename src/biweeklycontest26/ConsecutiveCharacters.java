package biweeklycontest26;

/*
 * https://leetcode.com/contest/biweekly-contest-26/problems/consecutive-characters/
 */
public class ConsecutiveCharacters {
    public int maxPower(String s) {
        char current = s.charAt(0);
        int currentLength = 1;
        int maxLength = 1;
        for (int i = 1 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (c == current) {
                currentLength++;
            } else {
                current = c;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                }
                currentLength = 1;
            }
        }
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new ConsecutiveCharacters().maxPower("leetcode")); // 2
    }
}
