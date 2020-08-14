public class Q5 {
    class Solution {
        public String longestPalindrome(String s) {
            if(s==null || s.length() < 2)
                return s;
            //dp[i][j] 表示子串 s[i..j] 是否为回文子串
            boolean[][] dp = new boolean[s.length()][s.length()];
            for(int i = 0; i < dp.length; i++){
                dp[i][i] = true;
            }
            char[] chars = s.toCharArray();
            int start = 0;
            int maxLen = 1;
            for (int j = 1; j < dp.length; j++){
                for(int i = 0; i < j; i++){
                    // si == sj 且 dp[i+1][j-1]) == true 则 dp[i][j] = true; 或者
                    // dp[i + 1][j - 1] 就得考虑边界情况，
                    // j-1 - (i+1) + 1 < 2 则 一定为回文串（串长度为1/2），故有 j-i <= 2
                    if(s.charAt(i) == s.charAt(j) && (j-i <= 2 || dp[i+1][j-1]) == true) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxLen) {
                            start = i;
                            maxLen = j - i + 1;
                        }
                    }
                }
            }
            return s.substring(start, start + maxLen);
        }
    }
}
