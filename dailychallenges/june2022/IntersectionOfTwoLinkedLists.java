package dailychallenges.june2022;

import common.ListNode;

import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = length(headA);
        int lengthB = length(headB);

        ListNode biggerList = lengthA > lengthB ? headA : headB;
        ListNode smallerList = lengthA > lengthB ? headB : headA;

        for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
            biggerList = biggerList.next;
        }

        while (biggerList != null && smallerList != null) {
            if (biggerList == smallerList) {
                return biggerList;
            }
            biggerList = biggerList.next;
            smallerList = smallerList.next;
        }
        return null;
    }

    private int length(ListNode node) {
        if (node.next == null) {
            return 1;
        }
        return length(node.next) + 1;
    }

    public static void main(String[] args) {
        ListNode intersection = new ListNode(
                8,
                new ListNode(
                        4,
                        new ListNode(5)
                )
        );

        System.out.println(new IntersectionOfTwoLinkedLists().getIntersectionNode(
                new ListNode(
                        4,
                        new ListNode(
                                1,
                                intersection
                        )
                ),
                new ListNode(
                        5,
                        new ListNode(
                                6,
                                new ListNode(
                                        1,
                                        intersection
                                )
                        )
                )
        )); // 8,4,5
    }
}
