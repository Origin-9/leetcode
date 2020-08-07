import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            lists.add(list);
            if(nums.length == 0)
                return lists;
            Arrays.sort(nums);
            int n = nums.length;
            boolean[] used = new boolean[n];
            for(int i = 1; i <= n; i++){
                dfs(i,0,nums,0, used, lists, list);
            }

            return lists;
        }

        private void dfs(int n, int depth, int[] nums, int index,boolean[] used,
                         List<List<Integer>> lists, List<Integer> list){
            if(depth == n){
                lists.add(new ArrayList<>(list));
                return;
            }

            for(int i = index; i < nums.length; i++){
                if(i!=0 && nums[i-1] == nums[i] && !used[i-1])
                    continue;
                list.add(nums[i]);
                used[i] = true;
                dfs(n, depth+1, nums, i+1, used,lists, list);
                used[i] = false;
                list.remove(list.size() - 1);
            }

        }
    }
}
