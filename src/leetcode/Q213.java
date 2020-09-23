package leetcode;

public class Q213 {
    class Solution {
        public int rob(int[] nums) {
            if(nums.length == 0)
                return 0;
            //从index = 0 开始偷（最后一个屋子不会被偷）
            int[] dp1 = new int[nums.length];
            //从index = 1 开始偷
            int[] dp2 = new int[nums.length];
            dp1[0] = 0;
            dp1[1] = nums[0];

            dp2[0] = 0;
            dp2[1] = nums[1];
            for(int i = 2;i < dp1.length; i ++){
                dp1[i] = Math.max(dp1[i-1], dp1[i-2] + nums[i-1]);
            }

            for(int i = 2;i < dp2.length; i ++){
                dp2[i] = Math.max(dp2[i-1], dp2[i-2] + nums[i]);
            }

            return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
        }

    }
}
