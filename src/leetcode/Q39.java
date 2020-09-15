package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0)
                return new ArrayList<>();

            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            dfs(candidates, target, 0, lists, list);

            return lists;
        }

        private void dfs(int[] candidates, int target, int index, List<List<Integer>> lists, List<Integer> list){
            if(target == 0){
                lists.add(new ArrayList<>(list));
                return;
            }
            if (target < 0)
                return;
            for(int i = index; i < candidates.length; i++){
                list.add(candidates[i]);
                dfs(candidates, target - candidates[i], i, lists, list);
                list.remove(list.size()-1);
            }
        }
    }
}
