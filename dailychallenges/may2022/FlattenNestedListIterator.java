package dailychallenges.may2022;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import static java.util.Arrays.asList;

/*
 * https://leetcode.com/problems/flatten-nested-list-iterator/
 */
public class FlattenNestedListIterator implements Iterator<Integer> {

    private final Stack<Iterator<NestedInteger>> nestedIteratorStack;
    private Integer next;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        this.nestedIteratorStack = new Stack<>();
        nestedIteratorStack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        if (next != null) {
            Integer ans = next;
            next = null;
            return ans;
        }
        while (!nestedIteratorStack.isEmpty()) {
            Iterator<NestedInteger> nestedIterator = nestedIteratorStack.peek();
            if (nestedIterator.hasNext()) {
                return getNext(nestedIterator);
            } else {
                nestedIteratorStack.pop();
            }
        }
        throw new IllegalStateException();
    }

    @Override
    public boolean hasNext() {
        while (!nestedIteratorStack.isEmpty()) {
            Iterator<NestedInteger> nestedIterator = nestedIteratorStack.peek();
            if (nestedIterator.hasNext()) {
                if (checkNext(nestedIterator)) {
                    return true;
                } else {
                    nestedIteratorStack.pop();
                }
            } else {
                nestedIteratorStack.pop();
            }
        }
        return false;
    }

    private boolean checkNext(Iterator<NestedInteger> nestedIterator) {
        if (!nestedIterator.hasNext()) {
            return false;
        }
        NestedInteger next = nestedIterator.next();
        if (next.isInteger()) {
            this.next = next.getInteger();
            return true;
        }
        Iterator<NestedInteger> iterator = next.getList().iterator();
        nestedIteratorStack.push(iterator);
        return checkNext(iterator);
    }

    private Integer getNext(Iterator<NestedInteger> nestedIterator) {
        NestedInteger next = nestedIterator.next();
        if (next.isInteger()) {
            return next.getInteger();
        }
        Iterator<NestedInteger> iterator = next.getList().iterator();
        nestedIteratorStack.push(iterator);
        return getNext(iterator);
    }

    public static void main(String[] args) {
        FlattenNestedListIterator flattenNestedListIterator = new FlattenNestedListIterator(
                asList(
                        new NestedIntegerImpl(
                                asList(
                                        new NestedIntegerImpl(1),
                                        new NestedIntegerImpl(1)
                                )
                        ),
                        new NestedIntegerImpl(2),
                        new NestedIntegerImpl(
                                asList(
                                        new NestedIntegerImpl(1),
                                        new NestedIntegerImpl(
                                                asList(
                                                        new NestedIntegerImpl(2),
                                                        new NestedIntegerImpl(3)
                                                )
                                        )
                                )
                        )
                )
        ); // 112123

        while (flattenNestedListIterator.hasNext()) {
            System.out.print(flattenNestedListIterator.next());
        }
    }
}
