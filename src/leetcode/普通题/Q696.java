package leetcode.普通题;

import java.util.ArrayList;
import java.util.List;

public class Q696 {
    class Solution {
        public int countBinarySubstrings(String s) {
            List<Integer> counts = new ArrayList<Integer>();
            int ptr = 0, n = s.length();
            while (ptr < n) {
                char c = s.charAt(ptr);
                int count = 0;
                while (ptr < n && s.charAt(ptr) == c) {
                    ++ptr;
                    ++count;
                }
                counts.add(count);
            }
            int ans = 0;
            for (int i = 1; i < counts.size(); ++i) {
                ans += Math.min(counts.get(i), counts.get(i - 1));
            }
            return ans;
        }
    }
}
