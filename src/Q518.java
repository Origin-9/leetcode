public class Q518 {
    class Solution {
        public int change(int amount, int[] coins) {
            if(coins == null || coins.length == 0 || amount == 0)
                return 0;
            // dp[i][j] 表示0-i区间，金额为j的组合数量
            int[][] dp = new int[coins.length+1][amount+1];
            dp[0][0] = 1;
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = 1;
            }

            for(int i = 1; i < dp.length; i++){
                for(int j = 1; j < dp[0].length; j++){
                    for(int k = 0; j >= k*coins[i-1]; k++){
                        dp[i][j] += dp[i-1][j-k*coins[i-1]];
                    }
                }
            }
            return dp[coins.length][amount];
        }
    }
}
