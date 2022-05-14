package dailychallenges.july2020;

/*
 * https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/545/week-2-july-8th-july-14th/3386/
 */
public class FlattenAMultilevelDoublyLinkedList {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node next = head.next;
        if (head.child == null) {
            flatten(next);
            return head;
        }
        Node child = flatten(head.child);
        if (head.next == null) {
            head.next = flatten(child);
            child.prev = head;
            head.child = null;
            return head;
        }
        head.next = child;
        child.prev = head;
        head.child = null;
        while (child.next != null) {
            child = child.next;
        }
        child.next = next;
        next.prev = child;
        return head;
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
