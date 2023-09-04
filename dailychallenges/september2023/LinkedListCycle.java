package dailychallenges.september2023;

import common.ListNode;

/*
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode testCase = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));
        testCase.next.next.next.next = testCase.next;
        System.out.println(new LinkedListCycle().hasCycle(
                testCase
        )); // true
    }
}
