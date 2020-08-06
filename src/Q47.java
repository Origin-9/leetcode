import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q47 {
    //先排序，然后如果当前元素和前一元素相等 且 前一元素没有被访问过，则跳过该元素
    class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            if(nums == null || nums.length == 0)
                return new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            Arrays.sort(nums);
            List<List<Integer>> lists = new LinkedList<>();
            List<Integer> list = new LinkedList<>();

            dfs(nums,0,lists,list,used);
            return lists;
        }

        private void dfs(int[] nums, int depth, List<List<Integer>> lists, List<Integer> list, boolean[] used){
            if(nums.length == depth){
                lists.add(new ArrayList<>(list));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(!used[i]) {
                    if (i != 0 && nums[i] == nums[i - 1] && !used[i - 1])
                        continue;
                    list.add(nums[i]);
                    used[i] = true;

                    dfs(nums, depth + 1, lists, list, used);
                    used[i] = false;
                    list.remove(list.size() - 1);
                }
            }
        }

    }
}
