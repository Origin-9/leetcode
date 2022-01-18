package leetcode.普通题;

public class Q27 {
    class Solution {
        public int removeElement(int[] nums, int val) {
            int ret = nums.length;

            for (int i = 0; i < ret; ) {
                if (nums[i] == val) {
                    int tmp = nums[i];
                    nums[i] = nums[ret - 1];
                    nums[ret - 1] = tmp;
                    ret--;
                    continue;
                }
                i++;
            }
            return ret;
        }
    }
}
