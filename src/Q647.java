public class Q647 {
    class Solution {
        public int countSubstrings(String s) {
            if (s.length() == 0)
                return 0;
            //i-j是否为回文串
            boolean[][] dp = new boolean[s.length()][s.length()];
            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = true;
            }
            int res = 0;
            for (int j = 1; j < s.length(); j++) {
                for (int i = 0; i < j; i++) {
                    if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]) == true) {
                        dp[i][j] = true;
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
