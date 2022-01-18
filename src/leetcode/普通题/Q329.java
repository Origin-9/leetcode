package leetcode.普通题;

public class Q329 {
    class Solution {
        public boolean isSubsequence(String s, String t) {
            int index = -1;
            for(char c : s.toCharArray()){
                index = t.indexOf(c, index+1);
                if(index == -1)
                    return false;
            }
            return true;
        }
    }
}
