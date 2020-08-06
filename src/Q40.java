import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if(candidates == null || candidates.length == 0)
                return new ArrayList<>();
            Arrays.sort(candidates);
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            boolean[] used = new boolean[candidates.length];
            dfs(candidates, target, 0, used, lists, list);

            return lists;
        }

        private void dfs(int[] candidates, int target, int index, boolean[] used, List<List<Integer>> lists, List<Integer> list){
            if(target == 0){
                lists.add(new ArrayList<>(list));
                return;
            }
            if (target < 0)
                return;
            for(int i = index; i < candidates.length; i++){
                if(i!=0 && candidates[i] == candidates[i-1] && !used[i-1])
                    continue;
                list.add(candidates[i]);
                used[i] = true;
                dfs(candidates, target - candidates[i], i+1, used,  lists, list);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
