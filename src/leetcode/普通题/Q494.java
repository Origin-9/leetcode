package leetcode.普通题;

public class Q494 {
    class Solution {
        //sum(P) - sum(N) = target
        //sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
        //2 * sum(P) = target + sum(nums)
        public int findTargetSumWays(int[] nums, int S) {
            if(nums == null || nums.length == 0)
                return 0;
            int sum = 0;
            for(int num : nums)
                sum += num;
            if(sum < S || (sum+S) % 2 == 1)
                return 0;
            sum = (S+sum)/2;
            //dp[i][j] 表示 0-i 个元素中，和为 j 的子集和
            int[][] dp = new int[nums.length+1][sum+1];
            for(int i = 0; i < dp.length; i++){
                dp[i][0] = 1;
            }
            for(int i = 1; i < dp.length; i++){
                for(int j = 0; j <= sum; j++){
                    if(j >= nums[i-1])
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                    else
                        dp[i][j] = dp[i-1][j];
                }
            }
            return dp[nums.length][sum];
        }
    }
}
