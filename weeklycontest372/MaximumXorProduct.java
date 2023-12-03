package weeklycontest372;

/*
 * https://leetcode.com/problems/maximum-xor-product/
 *
 * Does not pass
 */
public class MaximumXorProduct {
    public int maximumXorProduct(long a, long b, int n) {
        String binaryStringA = Long.toBinaryString(a);
        String binaryStringB = Long.toBinaryString(b);
        int minLength = Math.min(binaryStringA.length(), binaryStringB.length());
        String x;
        String y;
        boolean first = a < b;
        StringBuilder xBuilder = new StringBuilder(binaryStringA.substring(0, binaryStringA.length() - minLength));
        StringBuilder yBuilder = new StringBuilder(binaryStringB.substring(0, binaryStringB.length() - minLength));
        for (int i = Math.min(n, minLength); i > 0; i--) {
            if (binaryStringA.charAt(binaryStringA.length() - i) == binaryStringB.charAt(binaryStringB.length() - i)) {
                xBuilder.append("1");
                yBuilder.append("1");
            } else {
                if (first) {
                    xBuilder.append("1");
                    yBuilder.append("0");
                } else {
                    xBuilder.append("0");
                    yBuilder.append("1");
                }
                first = !first;
            }
        }
        y = yBuilder.toString();
        x = xBuilder.toString();
        if (binaryStringA.length() > x.length()) {
            x = binaryStringA.substring(0, binaryStringA.length() - x.length()) + x;
        }
        if (binaryStringB.length() > y.length()) {
            y = binaryStringB.substring(0, binaryStringB.length() - y.length()) + y;
        }
        // convert binary string to long
        long xLong = 0;
        long yLong = 0;
        for (int i = 0; i < x.length(); i++) {
            xLong = xLong * 2 + (x.charAt(i) - '0');
        }
        for (int i = 0; i < y.length(); i++) {
            yLong = yLong * 2 + (y.charAt(i) - '0');
        }
        return (int) (xLong * yLong % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new MaximumXorProduct().maximumXorProduct(12, 5, 4)); // 98
    }
}
