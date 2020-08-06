import java.util.ArrayList;
import java.util.List;

public class Q77 {
    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            if(n == 0 || k == 0){
                return new ArrayList<>();
            }
            List<List<Integer>> lists = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            boolean[] used = new boolean[n];

            dfs(n,k,0,0,lists,list,used);
            return lists;
        }
        private void dfs(int n, int k, int index, int depth, List<List<Integer>> lists, List<Integer> list, boolean[] used){
            if(depth == k){
                lists.add(new ArrayList<>(list));
                return;
            }
            for(int i = index; i < n; i++){
                if(!used[i]){
                    int value = i +1;
                    list.add(value);
                    used[i] = true;

                    dfs(n,k,i+1,depth+1,lists,list,used);

                    used[i] = false;
                    list.remove(list.size()-1);
                }
            }
        }

    }

    public static void main(String[] args) {
        new Solution().combine(4,2);
    }
}
