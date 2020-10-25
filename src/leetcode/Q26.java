package leetcode;

public class Q26 {
    static class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length < 2){
                return nums.length;
            }
            int i = 0, j = 1;
            for (; j < nums.length; j++){
                if (nums[i] != nums[j]){
                    nums[i+1] = nums[j];
                    i++;
                }
            }
            return i+1;
        }
    }

    public static void main(String[] args) {
        new Solution().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
}
