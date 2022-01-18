package leetcode.普通题;

public class Q153 {
    static class Solution {
        public int findMin(int[] nums) {
            if(nums.length == 1)
                return nums[0];
            int l = 0, r = nums.length-1;
            if(nums[r] > nums[0]) {
                return nums[0];
            }
            while (l < r){
                int mid = l + (r-l)/2;
                if(nums[mid] > nums[mid+1])
                    return nums[mid+1];
                if(nums[mid-1] > nums[mid])
                    return nums[mid];
                if(nums[mid] > nums[l])
                    l = mid + 1;
                else if(nums[mid] < nums[l])
                    r = mid - 1;
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        new Solution().findMin(new int[]{3,4,5,1,2});
    }
}
