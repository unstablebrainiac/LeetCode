/*
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String previous = countAndSay(n - 1);
        StringBuilder s = new StringBuilder();
        char current = previous.charAt(0);
        int count = 1;
        for (int i = 1; i < previous.length(); i++) {
            char c = previous.charAt(i);
            if (c == current) {
                count++;
            } else {
                s.append(count).append(current);
                current = c;
                count = 1;
            }
        }
        s.append(count).append(current);
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(4)); // 1211
    }
}
