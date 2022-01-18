package leetcode.普通题;

import java.util.List;

public class Q524 {
    class Solution {
        public String findLongestWord(String s, List<String> d) {
            String res = "";
            for(String target : d){
                int resLen = res.length();
                int tarLen = target.length();
                if(resLen > tarLen || (resLen == tarLen && res.compareTo(target) < 0))
                    continue;
                if(isSubStr(s, target)){
                    res = target;
                }
            }
            return res;
        }

        public boolean isSubStr(String s, String target){
            int l = 0, r = 0;
            while (l < s.length() && r < target.length()){
                if(s.charAt(l) == target.charAt(r)){
                    r++;
                }
                l++;
            }
            return r == target.length();
        }
    }
}
