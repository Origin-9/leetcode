package leetcode.普通题;

public class Q205 {
    class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s.length() != t.length())
                return false;

            int[] cnts1 = new int[256];
            int[] cnts2 = new int[256];
            for (int i = 0; i < s.length(); i++){
                char c1 = s.charAt(i), c2 = t.charAt(i);
                if(cnts1[c1] != cnts2[c2])
                    return false;
                cnts1[c1] = i+1;
                cnts2[c2] = i+1;
            }
            return true;
        }
    }
}
