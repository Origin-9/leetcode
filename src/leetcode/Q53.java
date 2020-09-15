package leetcode;

public class Q53 {

    //递归
    static class Solution1 {
        int maxSub = 0;
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            maxSub = nums[0];
            maxSubArray(nums, nums.length-1);
            return maxSub;
        }
        //index 以及之前连续的 最大和
        private int maxSubArray(int[] nums, int index){
            if(index == 0)
                return nums[index];
            int pre = index - 1;
            int preSum = maxSubArray(nums, pre);
            if(preSum < 0) {
                maxSub = Math.max(maxSub, nums[index]);
                return nums[index];
            }
            else {
                maxSub = Math.max(maxSub, nums[index] + preSum);
                return preSum + nums[index];
            }
        }

    }
    //动态规划
    class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0)
                return 0;
            if(nums.length == 1)
                return nums[0];
            //dp数组保存的是 i以及前边连续元素的最大和
            int[] dp = new int[nums.length];
            dp[0] = nums[0];
            int max =  nums[0];
            for(int i = 1; i < dp.length; i++){
                if(dp[i-1]<0)
                    dp[i] = nums[i];
                else
                    dp[i] = nums[i] + dp[i-1];
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().maxSubArray(new int[]{-1,-2}));
    }
}
