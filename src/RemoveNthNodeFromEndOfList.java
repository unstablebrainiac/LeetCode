/*
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (indexFromRight(head, n) == n) {
            return head.next;
        }
        return head;
    }

    private int indexFromRight(ListNode node, int n) {
        if (node.next == null) {
            return 1;
        }
        int index = 1 + indexFromRight(node.next, n);
        if (index == n + 1) {
            if (n == 1) {
                node.next = null;
            } else {
                node.next = node.next.next;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveNthNodeFromEndOfList().removeNthFromEnd(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5))))),
                2
        )); // 1,2,3,5
    }

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + ((next != null) ? "," + next : "");
        }
    }
}
