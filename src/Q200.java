public class Q200 {
    class Solution {
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0){
                return 0;
            }

            int m = grid.length;
            int n = grid[0].length;
            int res = 0;
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] != '1')
                        continue;
                    else {
                        res += infect(grid, i, j, m, n);
                    }
                }
            }
            return res;
        }
        private int infect(char[][] grid, int i, int j, int m, int n){
            if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1')
                return 0;
            grid[i][j] = '2';
            infect(grid, i+1, j, m, n);
            infect(grid, i-1, j, m, n);
            infect(grid, i, j+1, m, n);
            infect(grid, i, j-1, m, n);
            return 1;
        }
    }
}
