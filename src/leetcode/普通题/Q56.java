package leetcode.普通题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q56 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            if(intervals.length < 2)
                return intervals;

            int[][] res = new int[intervals.length][2];
            Arrays.sort(intervals, (c1, c2) -> c1[0] - c2[0]);
            res[0] = intervals[0];
            int index = 0;
            for(int i = 1 ; i < intervals.length ; i++){
                int l = intervals[i][0], r = intervals[i][1];

                if(res[index][1] < l){
                    index++;
                    res[index] = new int[]{l, r};
                }
                else {
                    res[index][1] = Math.max(res[index][1], r);
                }
            }
            return Arrays.copyOf(res, index);
        }
    }

    public static void main(String[] args) {
        int[][] res = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        new Solution().merge(res);
    }
}
