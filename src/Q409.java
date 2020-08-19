import java.util.HashMap;

public class Q409 {
    class Solution {
        public int longestPalindrome(String s) {
            if(s.length() == 0)
                return 0;
            // A-Z a-z 在ASCLL表0-127
            int[] cnts = new int[128];
            for(char c: s.toCharArray()){
                cnts[c]++;
            }
            int length = 0;
            for (int tmp : cnts){
                length += (tmp/2)*2;
            }
            if(length != s.length())
                length++;
            return length;
        }
    }
}
