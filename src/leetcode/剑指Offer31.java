package leetcode;

import java.util.Stack;

public class 剑指Offer31 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int l = 0, r = 0;
            Stack<Integer> stack = new Stack<>();
            for(; l < pushed.length; l++){
                stack.push(pushed[l]);
                while (!stack.isEmpty() && stack.peek() == popped[r]){
                    stack.pop();
                    r++;
                }
            }
            return stack.isEmpty();
        }
    }
}
