public class Q91 {
    class Solution {
        //dp[i]的意思是到第i个字符有多少种解法。可以认为已有i-1个字符，
        // 就可以分为最后一个字符是单独解码（dp[i-1种解法]）或者跟前一个字符（第i-1个字符）共同解码（dp[i-2]种解法）
        public int numDecodings(String s) {
            return 0;
        }
    }
}
