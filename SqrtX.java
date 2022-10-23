/*
 * https://leetcode.com/problems/sqrtx/
 */
public class SqrtX {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        for (int i = 0; i <= x; i++) {
            if (Math.pow(i, 2) > x) {
                return i - 1;
            }
        }
        throw new IllegalStateException();
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(8)); // 2
    }
}
