/*
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode kthNode = head;
        for (int i = 0; i < k - 1; i++) {
            kthNode = kthNode.next;
            if (kthNode == null) {
                return head;
            }
        }
        ListNode kPlusOnethNode = kthNode.next;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;
        ListNode nextNextNode;
        for (int i = 0; i < k - 1; i++) {
            nextNextNode = nextNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
            nextNode = nextNextNode;
        }
        head.next = reverseKGroup(kPlusOnethNode, k);
        return kthNode;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseNodesInKGroup().reverseKGroup(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5))))),
                3
        )); // 3,2,1,4,5
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
