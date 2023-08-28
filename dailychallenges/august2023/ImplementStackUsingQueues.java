package dailychallenges.august2023;

import java.util.LinkedList;
import java.util.Queue;

/*
 * https://leetcode.com/problems/implement-stack-using-queues/
 */
public class ImplementStackUsingQueues {
    static class MyStack {

        Queue<Integer> backingQueue;
        Integer top;

        public MyStack() {
            backingQueue = new LinkedList<>();
        }

        public void push(int x) {
            top = x;
            backingQueue.offer(x);
        }

        public int pop() {
            for (int i = 0; i < backingQueue.size() - 1; i++) {
                Integer poll = backingQueue.poll();
                top = poll;
                backingQueue.offer(poll);
            }
            return backingQueue.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return backingQueue.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 2
        System.out.println(myStack.pop()); // 2
        System.out.println(myStack.empty()); // false
    }
}
