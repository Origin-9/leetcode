import java.util.Stack;

public class Q155 {
    class MinStack {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        /** initialize your data structure here. */
        public MinStack() {
            stack1 = new Stack<Integer>();
            stack2 = new Stack<Integer>();
        }

        public void push(int x) {
            stack1.push(x);
            if(!stack2.empty()) {
                int tmp = stack2.peek();
                if(x < tmp) {
                    stack2.push(x);
                }else
                    stack2.push(tmp);
            }else
                stack2.push(x);
        }

        public void pop() {
            stack1.pop();

            stack2.pop();
        }

        public int top() {
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
