import java.util.Arrays;

public class Q62 {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            Arrays.fill(dp, 1);
            dp[m-1][n-1] = 0;
            for(int i = m - 2; i >= 0;i--){
                for (int j = n - 2;j >= 0; j--){
                    dp[i][j] = dp[i+1][j] + dp[i][j+1] ;
                }
            }
            return dp[0][0];
        }
    }
}
