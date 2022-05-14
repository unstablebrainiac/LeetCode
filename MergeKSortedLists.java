import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;

/*
 * https://leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        Optional<Integer> maybeMinIndex =
                IntStream
                        .range(0, lists.length)
                        .boxed()
                        .filter(integer -> lists[integer] != null)
                        .min(Comparator.comparingInt(value -> lists[value].val));
        if (maybeMinIndex.isEmpty()) {
            return null;
        }
        Integer minIndex = maybeMinIndex.get();
        ListNode head = lists[minIndex];
        lists[minIndex] = head.next;
        head.next = mergeKLists(lists);
        return head;
    }

    public static void main(String[] args) {
        System.out.println(new MergeKSortedLists().mergeKLists(
                new ListNode[]{
                        new ListNode(1,
                                new ListNode(4,
                                        new ListNode(5))),
                        new ListNode(1,
                                new ListNode(3,
                                        new ListNode(4))),
                        new ListNode(2,
                                new ListNode(6))
                }
        )); // 1,1,2,3,4,4,5,6
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
