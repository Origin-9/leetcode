package leetcode.普通题;

import java.util.HashSet;

public class Q219 {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashSet<Integer> set = new HashSet<>();

            for(int i = 0; i < nums.length; i++){
                if(set.contains(nums[i]))
                    return true;
                set.add(nums[i]);
                if(set.size() > k)
                    set.remove(nums[i - k]);
            }
            return false;
        }
    }
}
