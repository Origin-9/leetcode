package leetcode.普通题;

import java.util.ArrayList;
import java.util.List;

public class Q17 {
    class Solution {
        public List<String> letterCombinations(String digits) {
            List<String> res = new ArrayList<>();
            if(digits == null || digits.length() == 0)
                return res;
            combination(res,digits,new StringBuilder());
            return res;
        }
        private void combination(List<String> res, String digits, StringBuilder sb){
            if(digits.length() == 0)
            {
                res.add(sb.toString());
                return;
            }
            for(char c : getChars(digits.charAt(0))) {
                sb.append(c);
                combination(res, digits.substring(1, digits.length()), sb);
                sb.deleteCharAt(sb.length()-1);
            }
        }

        private char[] getChars(char c){
            switch (c){
                case '2':
                    return new char[]{'a','b','c'};
                case '3':
                    return new char[]{'d', 'e', 'f'};
                case '4':
                    return new char[]{'g', 'h', 'i'};
                case '5':
                    return new char[]{'j', 'k', 'l'};
                case '6':
                    return new char[]{'m', 'n', 'o'};
                case '7':
                    return new char[]{'p', 'q', 'r', 's'};
                case '8':
                    return new char[]{'t', 'u', 'v'};
                case '9':
                    return new char[]{'w', 'x', 'y', 'z'};
                default:
                    return new char[0];
            }

        }
    }


}
