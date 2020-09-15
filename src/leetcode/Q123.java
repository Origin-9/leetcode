package leetcode;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Q123 {
    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length == 0)
                return 0;
            // dp[天数][是否持股][次数]
            int[][][] dp = new int[prices.length][2][3];
            //第一天未持股
            dp[0][0][0] = 0;
            dp[0][0][1] = 0;
            dp[0][0][2] = 0;
            //第一天持股
            dp[0][1][0] = -prices[0];
            //不可能的情况，不影响
            dp[0][1][1] = Integer.MIN_VALUE;
            dp[0][1][2] = Integer.MIN_VALUE;

            for (int i = 1; i < prices.length; i++) {
                //i天未持股

                dp[i][0][0] = 0;
                //i天未持股，交易次数一次：今天卖出/昨天卖出
                dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
                //i天未持股，交易次数两次：今天卖出/昨天卖出
                dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);

                //i天持股

                dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);

                dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
                dp[i][1][2] = Integer.MIN_VALUE;
            }
            return Math.max(dp[prices.length - 1][0][1], dp[prices.length - 1][0][2]);
        }
    }
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[][][] dp = new int[prices.length][2][3];
        /** * 定义第二位数组
         * 【0】代表持股，【1】代表持股 * 定义第三维数组 【】代表已购买的次数，范围为0~2
         * 【6】 种状态
         * 1.持股，卖出0次
         * 2.持股，卖出1次
         * 3.持股，卖出2次
         * 4.未持股，卖出0次
         * 5.未持股，卖出1次
         * 6.未持股，卖出2次 *
         * 动态规划步骤：
         * 1. 定义状态 * 2. 转移方程 * 3. 确定起始 * 4. 确定终了 */
        // 第一天不买股票就是利润为0，第一天买股票就是利润为负
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;
        dp[0][0][2] = 0;
        dp[0][1][0] = -prices[0];
        dp[0][1][1] = -prices[0];
        dp[0][1][2] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            // 今天未持股，并且卖出次数为0，那么前一天一定没有买股票
            dp[i][0][0] = dp[i - 1][0][0];
            // 今天未持股，并且卖出次数为1，那么前一天持股，今天卖出，或前一天未持股，今天未行动
            dp[i][0][1] = Math.max(dp[i - 1][1][0] + prices[i], dp[i - 1][0][1]);
            // 今天未持股，并且卖出次数为2，那么前一天持股，今天卖出，或前一天未持股，今天未行动
            dp[i][0][2] = Math.max(dp[i - 1][1][1] + prices[i], dp[i - 1][0][2]);
            // 今天持股，卖出0次，那么前一天要么持股，今天未行动，要么前一天未持股，今天买入
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][0] - prices[i]);
            // 今天持股，卖出1次，那么前一天要么持股，今天未行动，要么前一天未持股，今天买入
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][0][1] - prices[i]);
            // 已经卖出两次了，利润不能变了，并且此状态还持有股票，是多余的
            dp[i][1][2] = dp[i - 1][1][2];
        }
        return Math.max(dp[prices.length - 1][0][1], Math.max(dp[prices.length - 1][0][1],
                Math.max(dp[prices.length - 1][0][2], 0)));
    }
}

