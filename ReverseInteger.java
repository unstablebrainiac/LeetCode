public class ReverseInteger {
    public int reverse(int x) {
        String maybeMinus = "";
        if (x < 0) {
            maybeMinus = "-";
            x = Math.abs(x);

        }
        try {
            return Integer.parseInt(new String(new StringBuilder(String.valueOf(x)).append(maybeMinus).reverse()));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(123)); // 321
    }
}
