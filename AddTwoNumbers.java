import common.ListNode;

/*
 * https://leetcode.com/problems/add-two-numbers/
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        int sum = l1.val + l2.val;
        boolean carry = false;
        if (sum > 9) {
            sum -= 10;
            carry = true;
        }
        if (l1.next != null || l2.next != null) {
            if (carry) {
                return new ListNode(sum, addTwoNumbers(new ListNode(1), addTwoNumbers(l1.next, l2.next)));
            }
            return new ListNode(sum, addTwoNumbers(l1.next, l2.next));
        } else if (carry) {
            return new ListNode(sum, new ListNode(1));
        }
        return new ListNode(sum);
    }

    public static void main(String[] args) {
        System.out.println(new AddTwoNumbers().addTwoNumbers(
                new ListNode(2, new ListNode(4, new ListNode(3))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        )); // 7,0,8
    }
}

