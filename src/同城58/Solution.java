package 同城58;


import java.util.*;


public class Solution {
    /**
     * @param input string字符串
     * @return int整型
     */
    public int calculate(String input) {
        if (input.trim().length() == 0)
            return 0;
        // write code here
        StringBuilder tmp = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stackInt = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ')
                continue;
            else if (c == '+' || i != 0 && c == '-' || c =='*' || c == '/'){
                if (!stack.empty() && stack.peek() == '*'){
                    int num1 = stackInt.pop();
                    int num2 = Integer.parseInt(tmp.toString());
                    tmp.delete(0, tmp.length());

                    int tmpNum = num1 * num2;
                    stackInt.push(tmpNum);
                    stack.pop();
                    stack.push(c);
                    continue;
                }else if (!stack.empty() && stack.peek() == '/'){
                    int num1 = stackInt.pop();
                    int num2 = Integer.parseInt(tmp.toString());

                    tmp.delete(0, tmp.length());

                    int tmpNum = num1/num2;
                    stackInt.push(tmpNum);
                    stack.pop();
                    stack.push(c);
                    continue;
                }
                stackInt.push(Integer.parseInt(tmp.toString()));
                tmp.delete(0, tmp.length());
                stack.push(c);
            }
            else
                tmp.append(c);
        }
        if (!stack.empty() && stack.peek() == '*'){
            int num1 = stackInt.pop();
            int num2 = Integer.parseInt(tmp.toString());
            int tmpNum = num1 * num2;
            stackInt.push(tmpNum);
            stack.pop();
        }else if (!stack.empty() && stack.peek() == '/'){
            int num1 = stackInt.pop();
            int num2 = Integer.parseInt(tmp.toString());
            int tmpNum = num1/num2;
            stackInt.push(tmpNum);
            stack.pop();
        }else {
            stackInt.push(Integer.parseInt(tmp.toString()));
        }
        while (!stack.empty()){
            int num1 = stackInt.pop();
            int num2 = stackInt.pop();
            char c = stack.pop();
            if (c == '+'){
                stackInt.push(num1+num2);
            }else if (c == '-'){
                stackInt.push(num2 - num1);
            }
        }
        return stackInt.pop();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().calculate(" "));
    }
}

