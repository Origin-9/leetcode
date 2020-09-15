package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            if(nums.length == 0)
                return lists;

            int n = nums.length;
            for(int i = 1; i <= n; i++){
                dfs(i,0,nums,0,lists,list);
            }

            return lists;
        }

        private void dfs(int n, int depth, int[] nums, int index, List<List<Integer>> lists, List<Integer> list){
            if(depth == n){
                lists.add(new ArrayList<>(list));
                return;
            }

            for(int i = index; i < nums.length; i++){
                list.add(nums[i]);
                dfs(n, depth+1, nums, i+1, lists, list);
                list.remove(list.size() - 1);
            }

        }
    }
}
