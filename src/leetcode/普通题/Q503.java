package leetcode.普通题;

import java.util.Arrays;
import java.util.Stack;

public class Q503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            if(nums == null)
                return null;
            if(nums.length == 0)
                return new int[0];
            int  length = nums.length;
            int[] res = new int[length];
            Arrays.fill(res, -1);
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < length * 2; i++){
                int tmp = nums[i % length];
                while (!stack.empty() && tmp > nums[stack.peek()]){
                    int pre = stack.pop();
                    res[pre] = tmp;
                }
                if(i < length)
                    stack.push(i);
            }
            return res;
        }
    }
}
