package leetcode.剑指;

import java.util.ArrayList;
import java.util.List;

public class 剑指Offer38 {
    static class Solution {
        public String[] permutation(String s) {
            if (s.length() == 0)
                return new String[]{};
            boolean[] used = new boolean[s.length()];
            List<String> res = new ArrayList<>();
            dfs(s, used, res, new StringBuilder(), 0, s.length());
            return res.toArray(new String[res.size()]);
        }
        private void dfs(String s, boolean[] used, List<String> res,StringBuilder sb, int n, int length){
            if (n == length){
                res.add(sb.toString());
                return;
            }
            for (int i = 0; i < length; i++){
                if (!used[i]){
                    sb.append(s.charAt(i));
                    used[i] = true;
                    dfs(s, used, res, sb, ++n, length);
                    used[i] = false;
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().permutation("abc");
    }
}
