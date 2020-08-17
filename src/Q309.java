public class Q309 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length == 0 || prices.length == 1)
                return 0;
            //第i天持有股票的最大利益
            int[] hold = new int[prices.length];
            //第i天不持有股票最大的利益
            int[] unHold = new int[prices.length];

            //边界条件
            hold[0] = -prices[0];
            hold[1] = Math.max(-prices[0], -prices[1]);

            unHold[0] = 0;
            unHold[1] = Math.max(hold[0] + prices[1], unHold[0]);
            for(int i = 2; i < prices.length; i++){
                //第i天持有股票：
                //1. 今天休息，昨天持有股票
                //2. 今天入股，前天卖出股票
                hold[i] = Math.max(hold[i-1], unHold[i-2] - prices[i]);
                //第i天不持有股票：
                //1. 今天休息，昨天不持有股票
                //2. 今天卖出股票，昨天持有股票
                unHold[i] = Math.max(hold[i-1] + prices[i], unHold[i-1]);
            }
            return unHold[prices.length-1];
        }
    }
}
