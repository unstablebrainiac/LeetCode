package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/546/week-3-july-15th-july-21st/3396/
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        head.next = removeElements(head.next, val);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveLinkedListElements().removeElements(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(6,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6))))))),
                6
        )); // 1->2->3->4->5
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return next == null ? String.valueOf(val) : val + "->" + next;
        }
    }
}
