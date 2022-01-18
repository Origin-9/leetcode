package leetcode.普通题;

public class Q343 {
    // 递归超时
    static class Solution1 {
        public int integerBreak(int n) {
            if(n < 2)
                return 0;

            return recur(n);

        }
        //recur() n 拆分为至少两个正整数的和，返回这些整数的乘积最大值
        private int recur(int n){
            if(n <= 2)
                return 1;
            int max = -1;
            for(int i = n-1; i > 0; i--){
                max = Math.max(max,
                        Math.max(i * (n-i), i * recur(n-i)) );
            }
            return max;
        }
    }
    // 动态规划
    class Solution {
        public int integerBreak(int n) {
            if(n < 2)
                return 0;

            int[] dp = new int[n+1];
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 1;

            for(int i = 3; i < dp.length;i++){
                for(int j = 1; j <= i-1; j++)
                    dp[i] = Math.max(dp[i], Math.max(j*(i-j), j * dp[i-j]));
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().integerBreak(10));
    }
}
