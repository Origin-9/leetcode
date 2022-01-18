package leetcode.普通题;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Q225 {
    class MyStack {
        private Queue<Integer> queue1;
        private Queue<Integer> queue2;
        /** Initialize your data structure here. */
        public MyStack() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queue1.offer(x);
            while(!queue2.isEmpty()){
                queue1.offer(queue2.poll());
            }
            Queue<Integer> tmp = queue2;
            queue2 = queue1;
            queue1 = tmp;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            return queue2.poll();
        }

        /** Get the top element. */
        public int top() {
            return queue2.peek();
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queue2.isEmpty();
        }
    }
}
