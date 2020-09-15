package leetcode;

public class Q547 {
    class Solution {
        public int findCircleNum(int[][] M) {
            if(M == null || M.length == 0 || M[0].length == 0)
                return 0;
            int n = M.length;
            int res = 0;
            boolean[] isVisited = new boolean[n];
            for(int i = 0; i < n; i++){
                if(!isVisited[i]){
                    dfs(M, i , isVisited);
                    res++;
                }
            }
            return res;
        }
        private void dfs(int[][] M, int i, boolean[] isVisited){
            isVisited[i] = true;
            for(int j = 0; j < M.length; j++){
                if(M[i][j] == 1 && !isVisited[j]){
                    dfs(M, j, isVisited);
                }
            }
        }
    }
}
