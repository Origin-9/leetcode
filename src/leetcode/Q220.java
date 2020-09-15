package leetcode;

import java.util.TreeMap;
import java.util.TreeSet;

public class Q220 {
    class Solution {
        public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
            TreeSet<Integer> treeSet = new TreeSet();

            for(int i = 0; i < nums.length; i++){
                //找后继
                Integer tmp1 = treeSet.ceiling(nums[i]);
                if(tmp1 != null && tmp1 <= nums[i] + t)
                    return true;

                //找前驱
                Integer tmp2 = treeSet.floor(nums[i]);
                if(tmp1 != null && nums[i] <= tmp2 + t)
                    return true;

                treeSet.add(nums[i]);
                if(treeSet.size() > k)
                    treeSet.remove(nums[i-k]);
            }
            return false;
        }
    }
}
