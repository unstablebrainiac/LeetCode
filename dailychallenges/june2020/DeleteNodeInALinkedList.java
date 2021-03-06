package dailychallenges.june2020;

import common.ListNode;

/*
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3347/
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(
                4,
                new ListNode(
                        5,
                        new ListNode(
                                1,
                                new ListNode(9))));
        new DeleteNodeInALinkedList().deleteNode(
                root.next
        ); // 4,1,9
    }
}
