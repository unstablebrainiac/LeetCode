package dailychallenges.september2023;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node ans = new Node(head.val);
        Map<Node, Node> oldToNewMap = new HashMap<>();
        Node current = head, newCurrent = ans;
        while (current != null) {
            oldToNewMap.put(current, newCurrent);
            current = current.next;
            if (current != null) {
                newCurrent.next = new Node(current.val);
                newCurrent = newCurrent.next;
            }
        }
        current = head;
        while (current != null) {
            oldToNewMap.get(current).next = oldToNewMap.get(current.next);
            oldToNewMap.get(current).random = oldToNewMap.get(current.random);
            current = current.next;
        }
        return ans;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this(val, null, null);
        }

        public Node(int val, Node next) {
            this(val, next, null);
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        @Override
        public String toString() {
            return val + (random == null ? "" : " (" + random.val + ")") + (next == null ? "" : " -> " + next);
        }
    }

    public static void main(String[] args) {
        Node one = new Node(1);
        Node ten = new Node(10, one);
        Node eleven = new Node(11, ten);
        Node thirteen = new Node(13, eleven);
        Node seven = new Node(7, thirteen);
        thirteen.random = seven;
        eleven.random = one;
        ten.random = seven;
        one.random = seven;
        System.out.println(new CopyListWithRandomPointer().copyRandomList(seven)); // 7 -> 13 (7) -> 11 (1) -> 10 (7) -> 1 (7)
    }
}
