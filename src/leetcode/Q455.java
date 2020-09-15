package leetcode;

import java.util.Arrays;

public class Q455 {
    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int gIndex = g.length-1, sIndex = s.length-1;
            Arrays.sort(g);
            Arrays.sort(s);
            while(gIndex >= 0 && sIndex >= 0){
                if(s[sIndex] >= g[gIndex]){
                    sIndex--;
                    gIndex--;
                }
                else
                    gIndex--;
            }
            return s.length - 1 - sIndex;
        }
    }
}
