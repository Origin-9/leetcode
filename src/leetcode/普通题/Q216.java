package leetcode.普通题;

import java.util.ArrayList;
import java.util.List;

public class Q216 {
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            if( n == 0 || k == 0)
                return new ArrayList<>();

            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();

            boolean[] used = new boolean[9];

            dfs(k, n, 0, 0, lists,list,used);
            return lists;
        }

        private void dfs(int k, int n, int depth, int index,
                         List<List<Integer>> lists, List<Integer> list, boolean[] used){
            if(k < depth)
                return;
            if(k == depth && n != 0)
                return;
            if(k == depth && n == 0){
                lists.add(new ArrayList<>(list));
                return;
            }

            for(int i = index; i < 9; i++){
                if(!used[i]){
                    int value = i + 1;
                    list.add(value);
                    used[i] = true;
                    dfs(k, n-value, depth + 1, i + 1, lists,list,used);
                    used[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        new Solution().combinationSum3(3,7);
    }
}
