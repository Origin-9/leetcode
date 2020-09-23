package leetcode;

public class Q1143 {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            if(text1.length() == 0 || text2.length() == 0)
                return 0;
            //dp[i][j] 的含义是：对于 s1[1..i] 和 s2[1..j]，它们的 LCS 长度是 dp[i][j]
            int[][] dp = new int[text1.length()+1][text2.length()+1];
            for (int i = 0; i < dp.length; i++){
                dp[i][0] = 0;
            }
            for (int i = 0; i < dp[0].length; i++){
                dp[0][i] = 0;
            }

            for(int i = 1; i < dp.length; i++){
                for (int j = 1; j < dp[0].length; j++){
                    if(text1.charAt(i-1) == text2.charAt(j-1))
                        dp[i][j] = dp[i-1][j-1] + 1;
                    else
                        // s1[i] 和 s2[j] 这两个字符至少有一个不在 lcs 中，需要丢弃一个
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }

            return dp[text1.length()][text2.length()];
        }
    }
}
