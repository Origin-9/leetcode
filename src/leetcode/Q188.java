package leetcode;

public class Q188 {
    class Solution {
        //111 / 211 个通过测试用例
        public int maxProfit(int k, int[] prices) {
            if (prices.length == 0)
                return 0;
            // dp[天数][是否持股][次数]
            int[][][] dp = new int[prices.length][2][k+1];
            //第一天未持股
            for(int i = 0; i <= k; i ++){
                dp[0][0][k] = 0;

            }
            dp[0][1][0] = -prices[0];
            for(int i = 0; i <= k; i ++){
                dp[0][1][k] = Integer.MIN_VALUE;
            }

            for (int i = 1; i < prices.length; i++) {
                //i天未持股
                for(int j = 0; j <= k; j ++){
                    if(j==0) {
                        dp[i][0][j] = 0;
                        continue;
                    }
                    //i天未持股，交易次数一次：今天卖出/昨天卖出
                    dp[i][0][j] = Math.max(dp[i - 1][1][j-1] + prices[i], dp[i - 1][0][j]);
                }
                //i天持股
                for(int j = 0; j < k; j ++) {
                    dp[i][1][j] = Math.max(dp[i - 1][1][j], dp[i - 1][0][j] - prices[i]);
                }
            }
            int res = 0;
            for(int i = 1; i <= (int)prices.length/2; i++){
                res = Math.max(res, dp[prices.length - 1][0][i]);
            }
            return res;
        }
    }
}
