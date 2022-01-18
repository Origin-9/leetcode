package leetcode.普通题;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            if(nums.length == 0)
                return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            List<Integer> path = new ArrayList<>();
            boolean[] visited = new boolean[nums.length];
            dfs(nums, 0 ,path,res,visited);
            return res;
        }

        private void dfs(int[] nums, int depth, List<Integer> path, List<List<Integer>> res, boolean[] visited){
            if(nums.length == depth){
                res.add(new ArrayList<>(path));
                return;
            }

            for(int i = 0;i < nums.length; i++){
                if(!visited[i]){
                    path.add(nums[i]);
                    visited[i] = true;

                    dfs(nums, depth+1 ,path,res,visited);

                    visited[i] = false;
                    path.remove(path.size()-1);
                }
            }
        }
    }
}
