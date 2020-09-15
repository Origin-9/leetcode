package leetcode;

public class Q695 {
    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0){
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] != 1)
                        continue;
                    else {
                        int tmp = infect(grid, i, j, m, n);
                        res = Math.max(res, tmp);
                    }
                }
            }
            return res;
        }
        private int infect(int[][] grid, int i, int j, int m, int n){
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1)
                return 0;
            grid[i][j] = 2;
            int tmp1 = infect(grid, i+1, j, m, n);
            int tmp2 = infect(grid, i-1, j, m, n);
            int tmp3 = infect(grid, i, j+1, m, n);
            int tmp4 = infect(grid, i, j-1, m, n);
            return tmp1 + tmp2 +tmp3 + tmp4 + 1;
        }
    }
}
