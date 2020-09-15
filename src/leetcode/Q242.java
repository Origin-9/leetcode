package leetcode;

public class Q242 {
    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] cnts = new int[26];

            for(char c : s.toCharArray()){
                cnts[c - 'a'] ++;
            }
            for(char c : t.toCharArray()){
                cnts[c - 'a'] --;
            }
            for(int tmp : cnts){
                if(tmp != 0)
                    return false;
            }
            return true;
        }
    }
}
