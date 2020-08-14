import java.util.Arrays;

public class Q416 {
    class Solution {
        //看背包中有无 和为 sum/2 的
        public boolean canPartition(int[] nums) {
            if(nums == null || nums.length == 0 || nums.length == 1)
                return false;
            int sum = 0;
            for(int num : nums)
                sum += num;
            if (sum % 2 != 0) {
                return false;
            }
            sum = sum/2;
            // dp 代表 从 0-i 个元素，能否找到一个子集和为 j 的
            boolean[][] dp = new boolean[nums.length+1][sum+1];
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = true;
            }
            for(int i = 1; i <= dp.length; i++){
                for (int j = 0; j <= sum; j++){
                    if(j >= nums[i-1])
                        dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
            return dp[nums.length][sum];

        }
    }
}
