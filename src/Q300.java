import java.util.Arrays;

public class Q300 {
    //dp[i] 表示以 nums[i] 结尾的「上升子序列」的长度。
    // 注意：这个定义中 nums[i] 必须被选取，且必须是这个子序列的最后一个元素。
    class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(nums[j] < nums[i])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
