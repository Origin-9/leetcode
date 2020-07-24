public class Q665 {
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int res = 0;
            for(int i = 1; i < nums.length && res < 2; i++){
                if(nums[i] >= nums[i-1])
                    continue;
                res++;

                if(i-2 >= 0 && nums[i-2] > nums[i])
                     nums[i] = nums[i-1];
                else
                    nums[i-1] = nums[i];
            }
            return res <= 1;
        }
    }
}
