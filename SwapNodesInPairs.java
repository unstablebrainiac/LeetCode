import common.ListNode;

/*
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        head.next = swapPairs(head.next.next);
        second.next = head;
        return second;
    }

    public static void main(String[] args) {
        System.out.println(new SwapNodesInPairs().swapPairs(
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(4))))
        )); // 2,1,4,3
    }
}
