package leetcode.普通题;

import java.util.TreeMap;

public class Q121 {
    class Solution {
        public int maxProfit(int[] prices) {
            if(prices.length == 0)
                return 0;
            int max = 0;
            int minBefore = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(minBefore > prices[i-1])
                    minBefore = prices[i-1];
                max = Math.max(max, prices[i] - minBefore);
            }
            return max;
        }
    }
}
