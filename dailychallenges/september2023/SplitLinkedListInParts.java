package dailychallenges.september2023;

import common.ListNode;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/split-linked-list-in-parts/
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }

        current = head;
        ListNode[] ans = new ListNode[k];
        int i = 0;
        while (current != null) {
            int size = (int) Math.ceil((double) length / k);
            ans[i++] = current;
            for (int j = 1; j < size; j++) {
                current = current.next;
            }
            ListNode next = current.next;
            current.next = null;
            current = next;
            length -= size;
            k--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SplitLinkedListInParts().splitListToParts(
                new ListNode(1, new ListNode(2, new ListNode(3))), 5
        ))); // [[1],[2],[3],[],[]]
    }
}
