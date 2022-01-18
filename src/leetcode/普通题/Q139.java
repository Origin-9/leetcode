package leetcode.普通题;

import java.util.List;

public class Q139 {
    class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            if(wordDict.size() == 0) {
                if (s.length() == 0)
                    return true;
                return false;
            }

            //dp[i] 表示字符串 s 前 i 个字符组成的字符串 s[0..i-1]
            // 是否能被空格拆分成若干个字典中出现的单词

            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for(int i = 1; i < dp.length; i++){
                for(int j = 0; j < s.length(); j++){
                    if(dp[j] && wordDict.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }

                }
            }
            return dp[s.length()];
        }
    }
}
