package leetcode.普通题;

import java.util.Arrays;

public class Q376{
    class Solution {
        public int wiggleMaxLength(int[] nums) {
            if (nums.length < 2)
                return nums.length;
            int[] up = new int[nums.length];
            int[] down = new int[nums.length];
            Arrays.fill(up, 1);
            Arrays.fill(down, 1);
            for (int i = 1; i < nums.length; i++) {
                for(int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        up[i] = Math.max(up[i],down[j] + 1);
                    } else if (nums[i] < nums[j]) {
                        down[i] = Math.max(down[i],up[j] + 1);
                    }
                }
            }
            return Math.max(down[nums.length - 1], up[nums.length - 1]);
        }
    }
}

