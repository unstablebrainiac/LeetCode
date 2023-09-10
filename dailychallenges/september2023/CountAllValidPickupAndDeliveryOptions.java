package dailychallenges.september2023;

/*
 * https://leetcode.com/problems/count-all-valid-pickup-and-delivery-options/
 */
public class CountAllValidPickupAndDeliveryOptions {
    public int countOrders(int i) {
        if (i == 1) {
            return 1;
        }
        int previous = countOrders(i - 1);
        int slots = 2 * i - 1;
        return (int) (previous * (slots + ((long) slots * (slots - 1) / 2)) % 1_000_000_007);
    }

    public static void main(String[] args) {
        System.out.println(new CountAllValidPickupAndDeliveryOptions().countOrders(500)); // 90
    }
}
