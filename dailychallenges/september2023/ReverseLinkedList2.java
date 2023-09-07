package dailychallenges.september2023;

import common.ListNode;

/*
 * https://leetcode.com/problems/reverse-linked-list-ii/
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head, lastNodeBeforeSequence = null;
        for (int i = 1; i < left; i++) {
            lastNodeBeforeSequence = current;
            current = current.next;
        }
        ListNode firstNodeOfSequence = current, next = null, temp;
        for (int i = left; i <= right; i++) {
            temp = current.next;
            current.next = next;
            next = current;
            current = temp;
        }
        firstNodeOfSequence.next = current;
        if (lastNodeBeforeSequence != null) {
            lastNodeBeforeSequence.next = next;
        } else {
            head = next;
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLinkedList2().reverseBetween(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4
        )); // 1,4,3,2,5
    }
}
