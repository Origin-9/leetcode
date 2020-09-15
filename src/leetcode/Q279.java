package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q279 {
    // 广度优先
    class Solution1 {
        public int numSquares(int n) {
            if(n == 0)
                return 0;

            int steps = 0, tempSize, tempValue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(n);
            while(!queue.isEmpty()){
                tempSize = queue.size();

                while (tempSize-- != 0){
                    tempValue = queue.poll();

                    for (int j = (int) Math.sqrt(tempValue); j > 0; j--){
                        if(tempValue == j * j)
                            return steps + 1;
                        else {
                            queue.add(tempValue - j * j);
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }

    // 动态规划
    static class Solution {

        public int numSquares(int n) {
            if(n == 0)
                return 0;

            int[] dp = new int[n+1];
            dp[0] = 0;
            for(int i = 1; i < dp.length; i++){
                dp[i] = Integer.MAX_VALUE;
                for(int j = 1; j <= (int)Math.sqrt(i); j++){
                    dp[i] = Math.min(dp[i] , dp[i-j*j] + 1);
                }
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {
        new Solution().numSquares(12);
    }
}