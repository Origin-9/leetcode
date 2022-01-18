package leetcode.普通题;

public class Q714 {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            if(prices == null || prices.length == 0 || prices.length == 1)
                return 0;

            //第i天持有股票的最大利益
            int[] hold = new int[prices.length];
            //第i天不持有股票最大的利益
            int[] unHold = new int[prices.length];
            hold[0] = -prices[0];

            hold[1] = Math.max(-prices[0], -prices[1]);
            unHold[0] = 0;
            unHold[1] = Math.max(unHold[0], hold[0] + prices[1] -fee);

            for(int i = 2; i < prices.length; i++){
                hold[i] = Math.max(hold[i-1], unHold[i-1] - prices[i]);
                unHold[i] = Math.max(unHold[i-1], hold[i-1] + prices[i] - fee);
            }
            return unHold[prices.length-1];
        }
    }
}
