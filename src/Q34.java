public class Q34 {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0)
                return new int[]{-1,-1};
            int first = findFirst(nums,target);
            int end = findFirst(nums,target + 1) - 1;
            if(first == nums.length || nums[first] != target)
                return new int[]{-1,-1};
            else
                return new int[]{first, end};
        }
        private int findFirst(int[] nums, int targrt){
            int l = 0, r = nums.length;
            while(l < r){
                int mid = l + (r-l)/2;
                if(nums[mid] >= targrt){
                    r = mid;
                }
                else if (nums[mid] < targrt){
                    l = mid + 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        new Solution().searchRange(new int[]{2,2},2);
    }
}
