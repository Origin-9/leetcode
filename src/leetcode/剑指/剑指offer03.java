package leetcode.剑指;

public class 剑指offer03 {
    /**
     * 找出数组中重复的数字。
     *
     *
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 示例 1：
     *
     * 输入：
     * [2, 3, 1, 0, 2, 5, 3]
     * 输出：2 或 3
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    class Solution {
        public int findRepeatNumber1(int[] nums) {
            //可优化点：不使用额外的数组
            int[] numberArray = new int[nums.length];
            for(int num : nums){
                numberArray[num]++;
                if (numberArray[num] > 1) {
                    return num;
                }
            }
            return -1;
        }

        public int findRepeatNumber(int[] nums) {
            int i = 0;
            while (i < nums.length){
                if (nums[i] == i) {
                    i++;
                    continue;
                }
                if (nums[nums[i]] == nums[i])
                    return nums[i];
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
            }
            return -1;
        }
    }

}
