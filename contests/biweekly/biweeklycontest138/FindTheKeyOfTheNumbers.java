package contests.biweekly.biweeklycontest138;

/*
 * https://leetcode.com/problems/find-the-key-of-the-numbers/
 */
public class FindTheKeyOfTheNumbers {

    public int generateKey(int num1, int num2, int num3) {
        String n1 = String.valueOf(num1);
        String n2 = String.valueOf(num2);
        String n3 = String.valueOf(num3);

        n1 = "0".repeat(4 - n1.length()) + n1;
        n2 = "0".repeat(4 - n2.length()) + n2;
        n3 = "0".repeat(4 - n3.length()) + n3;

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            if (n1.length() <= i || n2.length() <= i || n3.length() <= i) {
                break;
            }
            result.append(Math.min(n1.charAt(i) - '0', Math.min(n2.charAt(i) - '0', n3.charAt(i) - '0')));
        }

        return Integer.parseInt(result.toString());
    }

    public static void main(String[] args) {
        System.out.println(new FindTheKeyOfTheNumbers().generateKey(1, 10, 1000)); // 0
    }
}
