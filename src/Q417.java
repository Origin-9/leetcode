import java.util.ArrayList;
import java.util.List;

public class Q417 {
    class Solution {
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            if (matrix == null || matrix.length == 0)
                return null;
            int m = matrix.length;
            int n = matrix[0].length;
            boolean[][] canReachP = new boolean[m][n];
            boolean[][] canReachA = new boolean[m][n];
            List<List<Integer>> ret = new ArrayList<>();
            for(int i = 0; i < m; i++){
                dfs(matrix, i, 0, m, n, canReachP);
                dfs(matrix, i, n-1, m, n, canReachA);
            }
            for(int j = 0; j < n; j++){
                dfs(matrix, 0, j, m, n, canReachP);
                dfs(matrix, m-1, j, m, n, canReachA);
            }
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(canReachP[i][j] && canReachA[i][j]){
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(i);
                        tmp.add(j);
                        ret.add(tmp);
                    }
                }
            }
            return ret;
        }

        private void dfs(int[][] matrix, int i, int j, int m, int n,boolean[][] canReach){
            if(canReach[i][j])
                return;
            canReach[i][j] = true;
            for (int[] tmp : dir){
                int nextR = tmp[0] + i;
                int nextC = tmp[1] + j;
                if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n
                        || matrix[i][j] > matrix[nextR][nextC]) {
                    continue;
                }
                dfs(matrix, nextR, nextC, m, n, canReach);
            }

        }
    }
}
