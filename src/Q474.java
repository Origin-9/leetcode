public class Q474 {
    // 思路 有可以装 0，1的两个背包，在物品中选
    // 双背包问题
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            if (strs == null || strs.length == 0)
                return 0;
            // dp[k][i][j] 表示区间 0-k,i个0,k个1下 可表示的字符串的最大数量
            int[][][] dp = new int[strs.length + 1][m + 1][n + 1];
            for (int i = 1; i < dp.length; i++) {
                String s = strs[i - 1];
                int zeros = 0;
                int ones = 0;
                for (char c : s.toCharArray()) {
                    if (c == '0')
                        zeros++;
                    else
                        ones++;
                }
                for (int j = 0; j <= m; j++) {
                    for (int k = 0; k <= n; k++) {
                        if (j >= zeros && k >= ones)
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], dp[i - 1][j - zeros][k - ones]+1);
                        else
                            dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
            return dp[strs.length][m][n];
        }
    }
}
