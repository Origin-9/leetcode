package leetcode.普通题;

import java.util.HashSet;

public class Q217 {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            for(int tmp : nums){
                if(set.contains(tmp))
                    return true;
                set.add(tmp);
            }
            return false;
        }
    }
}
