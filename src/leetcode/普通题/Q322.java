package leetcode.普通题;

public class Q322 {
    class Solution {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0)
                return -1;

            // dp[i]表示凑成总金额 i 所需的最少的硬币个数
            int[] dp = new int[amount+1];
            for(int i = 1; i <= amount; i ++){
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length;j++){
                    if(i-coins[j] >= 0 && dp[i-coins[j]] < min)
                        min = dp[i-coins[j]] + 1;
                }
                dp[i] = min;
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }


    class Solution2 {
        public int coinChange(int[] coins, int amount) {
            if(coins == null || coins.length == 0)
                return -1;

            // dp[i]表示凑成总金额 i 所需的最少的硬币个数
            int[] dp = new int[amount+1];
            for(int i = 1; i <= amount; i ++){
                dp[i] = Integer.MAX_VALUE;
                for (int j = 0; j < coins.length;j++){
                    if(i-coins[j] >= 0 && dp[i-coins[j]] < dp[i])
                        dp[i] = dp[i-coins[j]] + 1;
                }
            }
            return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
        }
    }
}
