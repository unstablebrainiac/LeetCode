import common.ListNode;

/*
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.val == head.val) {
            head.next = head.next.next;
            return deleteDuplicates(head);
        }
        head.next = deleteDuplicates(head.next);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicatesFromSortedList().deleteDuplicates(
                new ListNode(
                        1,
                        new ListNode(
                                1,
                                new ListNode(
                                        2,
                                        new ListNode(
                                                3,
                                                new ListNode(3)
                                        )
                                )
                        )
                )
        ));
    }
}
