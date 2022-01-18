package leetcode.普通题;

public class Q198 {
//    1.定义子问题
//    2.写出子问题的递推关系
//    3.确定 DP 数组的计算顺序
//    4.空间优化（可选）
    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 0)
                return 0;
            // 子问题：
            // f(k) [0，k)房间的最大值
            // f(0) = 0;
            // f(1) = num[0];
            // f(k) = max{f(k-1), f(k-2) + num[k-1]}
            int[] dp = new int[nums.length+1];
            dp[0] = 0;
            dp[1] = nums[0];

            for(int i = 2; i <= nums.length; i++){
                dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
            }
            return dp[nums.length];
        }
    }
}
