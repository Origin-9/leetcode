package 小米;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in));
        String s = bufferedReader.readLine();

        while (s != ""){
            //字符串读入
            if (s.trim().length() == 0)
                System.out.println(true);
            else {
                //字符串判定
                Stack<Character> stack = new Stack<>();
                int length = s.length();
                for (int i = 0; i < length; i++) {
                    char tmp = s.charAt(i);
                    if (tmp == '(')
                        stack.push(')');
                    else if (tmp == '[')
                        stack.push(']');
                    else if (tmp == '{')
                        stack.push('}');
                    else {
                        if (tmp != stack.pop()) {
                            System.out.println(false);
                            break;
                        }
                    }
                    if (i == length - 1)
                        System.out.println(true);
                }
            }
            s = bufferedReader.readLine();
        }
    }
}

