package leetcode;

import java.util.Arrays;

public class Q646 {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            if(pairs.length == 0)
                return 0;
            Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
            int[] dp = new int[pairs.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if(pairs[j][1] < pairs[i][0])
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            int res = 0;
            for (int i = 0; i < pairs.length; i++) {
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}
