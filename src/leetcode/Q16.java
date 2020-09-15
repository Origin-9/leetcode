package leetcode;

import java.util.Arrays;

public class Q16 {
    class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int minGap = nums[0] + nums[1] + nums[2];
            for(int index = 0 ; index < nums.length - 2 ; index++){
                if(index > 0 && nums[index] == nums[index-1]){
                    continue;
                }
                int l = index + 1, r = nums.length - 1;
                while(l < r){
                    int tmp = nums[index] + nums[l] + nums[r];
                    if(Math.abs(tmp - target) < Math.abs(minGap - target))
                        minGap = tmp;
                    if(tmp > target)
                        r--;
                    else if(tmp < target)
                        l++;
                    else
                        return minGap;
                }
            }
            return minGap;
        }
    }
}
