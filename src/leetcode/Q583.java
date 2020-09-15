package leetcode;

public class Q583 {
    class Solution {
        //转换为求最长公共子序列问题 lcs
        //len1+len2 - lcs * 2
        public int minDistance(String word1, String word2) {
            if(word1.length() == 0 || word1.length() == 0)
                return 0;
            int len1 = word1.length();
            int len2 = word2.length();
            int[][] dp = new int[len1+1][len2+1];

            for(int i = 1; i <= len1; i++){
                for(int j = 1; j <= len2; j++){
                    if(word1.indexOf(i) == word2.indexOf(j))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        dp[i-1][j-1] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
            return len1+len2 - dp[len1][len2]*dp[len1][len2];
        }
    }
}
