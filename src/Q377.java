public class Q377 {
    class Solution {
        public int combinationSum4(int[] nums, int target) {
            if (nums.length == 0)
                return 0;
            // dp[j] 目标和j的组合个数（包括不同排列）
            int[] dp = new int[target + 1];

            dp[0] = 1;
            for (int j = 1; j < dp.length; j++) {
                int sum = 0;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] <= j) {
                        sum += dp[j-nums[i]];
                    }
                }
                dp[j] = sum;
            }
            return dp[target];
        }
    }
}
