package leetcode;

import java.util.Stack;

public class Q20 {

    class Solution {

        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < s.length() ; i++){
                char c = s.charAt(i);
                if(c == '(' || c == '{' ||c == '['){
                    stack.push(c);
                }
                else{
                    if(stack.empty())
                        return false;

                    char topChar = stack.pop();

                    if(c == '}' && topChar != '{')
                        return false;
                    if(c == ']' && topChar != '[')
                        return false;
                    if(c == ')' && topChar != '(')
                        return false;
                }
            }
            return stack.empty();
        }
    }
}

