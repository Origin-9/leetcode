package leetcode.普通题;

import java.util.LinkedList;
import java.util.List;

public class Q93 {
    class Solution {
        public List<String> restoreIpAddresses(String s) {
            if(s == null || s.length() == 0)
                return new LinkedList<>();

            StringBuilder sb = new StringBuilder();
            List<String> res = new LinkedList<>();

            dfs(0, s, res, sb);
            return res;
        }
        //s可能的 ip 地址
        private void dfs(int index, String s, List<String> res, StringBuilder sb){
            if(index == 4 || s.length() == 0){
                res.add(sb.toString());
                return;
            }
            for(char c : s.toCharArray()) {
                sb.append(c);
                int tmp = Integer.valueOf(sb.toString());
                if (tmp > 255) {
                    sb.deleteCharAt(sb.length()-1);
                    sb.append('.');
                    dfs(0, s.substring(s.indexOf(c), s.length()), res, sb);
                }
            }
        }

    }
}
