package leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Q349 {

    class Solution {
        public int[] intersection(int[] nums1, int[] nums2) {

            // 存储最后返回的交集
            ArrayList<Integer> arrayList = new ArrayList<>();

            TreeSet<Integer> treeSet = new TreeSet<>();

            for(int num : nums1)
                treeSet.add(num);

            for(int num : nums2){
                if (treeSet.contains(num)){
                    arrayList.add(num);
                    treeSet.remove(num);
                }
            }

            int[] res = new int[arrayList.size()];

            for(int i = 0 ; i < arrayList.size() ; i ++){
                res[i] = arrayList.get(i);
            }
            return res;
        }
    }
}
