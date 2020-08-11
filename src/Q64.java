public class Q64 {
    //递归   超时
    static class Solution1 {
        public int minPathSum(int[][] grid) {
            return minPathSum(grid, 0 ,0 ,grid.length -1,grid[0].length -1);
        }

        private int minPathSum(int[][] grid, int a, int b, int c, int d) {
            int res = grid[a][b];
            if(a == c && b== d){
                return res;
            }
            if(a == c){
                return res + minPathSum(grid,a, b+1,c,d);
            }
            if(b == d){
                return res + minPathSum(grid,a + 1, b,c,d);
            }
            return res + Math.min(minPathSum(grid,a+1,b,c,d),
                    minPathSum(grid,a,b+1,c,d));
        }
    }

    class Solution {
        public int minPathSum(int[][] grid) {
            int[][] dp = new int[grid.length][grid[0].length];
            dp[0][0] = grid[0][0];
            dp[grid.length - 1][grid[0].length - 1] = grid[grid.length - 1][grid[0].length - 1];
            for(int i = grid.length - 2; i >= 0; i--){
                dp[i][grid[0].length - 1] = dp[i+1][grid[0].length - 1] + grid[i][grid[0].length - 1];
            }
            for(int j = grid[0].length - 2; j >= 0; j--){
                dp[grid.length - 1][j] = dp[grid.length - 1][j+1] + grid[grid.length - 1][j];
            }
            for(int i = grid.length - 2; i >= 0; i--){
                for(int j = grid[0].length - 2; j >= 0; j--){
                    dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
                }
            }
            return dp[0][0];
        }
    }



    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        new Solution1().minPathSum(grid);
    }
}
