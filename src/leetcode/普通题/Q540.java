package leetcode.普通题;

import java.util.Arrays;

public class Q540 {
    static class Solution {
        public int singleNonDuplicate(int[] nums) {
            int l = 0, r = nums.length-1;
            while(l < r){
                int mid = l + (r-l)/2;
                boolean flag = (mid - l)%2 == 0;
                if(nums[mid+1] == nums[mid]){
                    if(flag){
                        l = mid + 2;
                    }
                    else {
                        r = mid - 1;
                    }
                }
                else if(nums[mid-1] == nums[mid]){
                    if(flag){
                        r = mid - 2;
                    }else {
                        l = mid + 1;
                    }
                }
                else
                    return nums[mid];
            }
            return nums[r];
        }
    }

    public static void main(String[] args) {
        new Solution().singleNonDuplicate(new int[]{1,2,2,3,3});
    }
}
